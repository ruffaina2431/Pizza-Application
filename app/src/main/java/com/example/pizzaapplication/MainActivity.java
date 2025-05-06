package com.example.pizzaapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton rbHawaiian, rbHamCheese;
    RadioButton rbSmall, rbMedium, rbLarge;
    RadioButton rbThin, rbThick;
    Button btnProcessOrder;
    TextView pizzaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pizzaText = findViewById(R.id.pizza);
        rbHawaiian = findViewById(R.id.rbHawaiian);
        rbHamCheese = findViewById(R.id.rbHamCheese);
        rbSmall = findViewById(R.id.rbSmall);
        rbMedium = findViewById(R.id.rbMedium);
        rbLarge = findViewById(R.id.rbLarge);
        rbThin = findViewById(R.id.rbThin);
        rbThick = findViewById(R.id.rbThick);
        btnProcessOrder = findViewById(R.id.btnProcessOrder);

        // Use lambda instead of anonymous inner class
        btnProcessOrder.setOnClickListener(v -> {
            if (!rbHawaiian.isChecked() && !rbHamCheese.isChecked()) {
                Toast.makeText(MainActivity.this, "Please select a pizza type!", Toast.LENGTH_SHORT).show();
                return;
            }

            double sizePrice;
            if (rbSmall.isChecked()) {
                sizePrice = 100;
            } else if (rbMedium.isChecked()) {
                sizePrice = 150;
            } else if (rbLarge.isChecked()) {
                sizePrice = 200;
            } else {
                Toast.makeText(MainActivity.this, "Please select a pizza size!", Toast.LENGTH_SHORT).show();
                return;
            }

            double crustPrice;
            if (rbThin.isChecked()) {
                crustPrice = 0;
            } else if (rbThick.isChecked()) {
                crustPrice = sizePrice * 0.5;
            } else {
                Toast.makeText(MainActivity.this, "Please select a crust type!", Toast.LENGTH_SHORT).show();
                return;
            }

            String pizzaType = rbHawaiian.isChecked() ? "Hawaiian" : "Ham and Cheese";
            double total = sizePrice + crustPrice;

            String message = "Your pizza is " + pizzaType + "\n"
                    + "Size Price: ₱" + sizePrice + "\n"
                    + "Crust Charge: ₱" + crustPrice + "\n"
                    + "Total: ₱" + total;

            pizzaText.setText(message);
        });
    }
}
