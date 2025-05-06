package com.example.pizzaapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton rbHawaiian, rbHamCheese;
    RadioButton rbSmall, rbMedium, rbLarge;
    Button btnProcessOrder;

    TextView pizzaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI components
        pizzaText = findViewById(R.id.pizza);
        rbHawaiian = findViewById(R.id.rbHawaiian);
        rbHamCheese = findViewById(R.id.rbHamCheese);

        rbSmall = findViewById(R.id.rbSmall);
        rbMedium = findViewById(R.id.rbMedium);
        rbLarge = findViewById(R.id.rbLarge);

        btnProcessOrder = findViewById(R.id.btnProcessOrder);

        btnProcessOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pizza type selection check
                boolean isHawaiian = rbHawaiian.isChecked();
                boolean isHamCheese = rbHamCheese.isChecked();

                // Size selection check
                boolean isSmall = rbSmall.isChecked();
                boolean isMedium = rbMedium.isChecked();
                boolean isLarge = rbLarge.isChecked();

                // Validate pizza type
                if (!isHawaiian && !isHamCheese) {
                    Toast.makeText(MainActivity.this, "Please select a pizza type!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validate size
                if (!isSmall && !isMedium && !isLarge) {
                    Toast.makeText(MainActivity.this, "Please select a size!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int price = 0;
                String pizzaType = "";
                String size = "";

                // Calculate price based on selection
                if (isHawaiian) {
                    pizzaType = "Hawaiian";
                    if (isSmall) {
                        price = 100;
                        size = "Small";
                    } else if (isMedium) {
                        price = 150;
                        size = "Medium";
                    } else if (isLarge) {
                        price = 200;
                        size = "Large";
                    }
                } else if (isHamCheese) {
                    pizzaType = "Ham and Cheese";
                    if (isSmall) {
                        price = 200;
                        size = "Small";
                    } else if (isMedium) {
                        price = 300;
                        size = "Medium";
                    } else if (isLarge) {
                        price = 400;
                        size = "Large";
                    }
                }

                // Display the result
                pizzaText.setText("You ordered a " + size + " " + pizzaType + " pizza.\nPrice: " + price + " PHP");
            }
        });
    }
}
