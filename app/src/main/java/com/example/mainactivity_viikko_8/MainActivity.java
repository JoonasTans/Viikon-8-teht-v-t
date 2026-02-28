package com.example.mainactivity_viikko_8;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private EditText EuroInput;
    private TextView ResultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EuroInput = findViewById(R.id.EuroInput);
        ResultText = findViewById(R.id.ResultText);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void convertToUSD(View view) {
        String input = EuroInput.getText().toString();
        if (input.isEmpty()) {
            ResultText.setText("Syötä eurot");
            return;
        }
        double euros = Double.parseDouble(input);
        double result = euros * 1.05;

        String formatted = String.format("$%.2f", result);
        ResultText.setText(formatted);


    }

    public void convertToGDP(View view) {
        String input = EuroInput.getText().toString();

        if (input.isEmpty()) {
            ResultText.setText("Syötä eurot");
            return;
        }
        double euros = Double.parseDouble(input);
        double result = euros * 0.83;

        String formatted = String.format("£%.2f", result);
        ResultText.setText(formatted);
    }
}
