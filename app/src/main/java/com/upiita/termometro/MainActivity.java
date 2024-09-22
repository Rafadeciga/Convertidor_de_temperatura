
package com.upiita.termometro;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private EditText numIngresadoText;
    private TextView resultTextView;
    private Switch conversionSwitch;
    private Button convertButton;
    private RelativeLayout mainLayout;
    private ImageView temperatureImageView; // Referencia al ImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numIngresadoText = findViewById(R.id.numIngresadoText);
        resultTextView = findViewById(R.id.resultTextView);
        conversionSwitch = findViewById(R.id.conversionSwitch);
        convertButton = findViewById(R.id.convertButton);
        mainLayout = findViewById(R.id.mainLayout);
        temperatureImageView = findViewById(R.id.temperatureImageView); // Inicializa el ImageView

        conversionSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                conversionSwitch.setText("F° a C°");
                mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorFondo));
                temperatureImageView.setImageResource(R.drawable.teror); // Cambia a imagen Celsius
            } else {
                conversionSwitch.setText("C° a F°");
                mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorFondo));
                temperatureImageView.setImageResource(R.drawable.terar); // Cambia a imagen Fahrenheit
            }
        });

        convertButton.setOnClickListener(v -> {
            if (conversionSwitch.isChecked()) {
                convertFahrenheitToCelsius();
            } else {
                convertCelsiusToFahrenheit();
            }
        });
    }

    private void convertCelsiusToFahrenheit() {
        String tempString = numIngresadoText.getText().toString();
        if (!tempString.isEmpty()) {
            double celsius = Double.parseDouble(tempString);
            double fahrenheit = (celsius * 9 / 5) + 32;
            resultTextView.setText(String.format("Resultado: %.2f °F", fahrenheit));
        }
    }

    private void convertFahrenheitToCelsius() {
        String tempString = numIngresadoText.getText().toString();
        if (!tempString.isEmpty()) {
            double fahrenheit = Double.parseDouble(tempString);
            double celsius = (fahrenheit - 32) * 5 / 9;
            resultTextView.setText(String.format("Resultado: %.2f °C", celsius));
        }
    }
}
