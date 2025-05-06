package com.example.pizzaapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton rbHawaiian, rbHamCheese;
    Button btnProcessOrder;
    CheckBox chbExtraCheese, chbMushrooms, chbOnions, chbTomatoes, chbPineApple;
    TextView pizzaText;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link Layout components to variables
        pizzaText = findViewById(R.id.pizza);
        rbHawaiian = findViewById(R.id.rbHawaiian);
        rbHamCheese = findViewById(R.id.rbHamCheese);
        btnProcessOrder = findViewById(R.id.btnProcessOrder);
        chbExtraCheese = findViewById(R.id.chbExtraCheese);
        chbMushrooms = findViewById(R.id.chbMushrooms);
        chbOnions = findViewById(R.id.chbOnions);
        chbTomatoes = findViewById(R.id.chbTomatoes);
        chbPineApple = findViewById(R.id.chbPineApple);

        btnProcessOrder.setOnClickListener(v -> {
            int toppingPrice = 0;
            String toppingSummary = "Extra Toppings:\n";
            String pizzaType;

            // Check pizza type
            if (rbHawaiian.isChecked()) {
                pizzaType = "Your pizza is Hawaiian";
            } else if (rbHamCheese.isChecked()) {
                pizzaType = "Your pizza is Ham and Cheese";
            } else {
                Toast.makeText(MainActivity.this, "Please Select Pizza Type to Proceed with Your Order!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate combinations
            if (chbTomatoes.isChecked() && chbOnions.isChecked()) {
                toppingPrice += 10;
                toppingSummary += "- Tomatoes & Onions (₱10)\n";
            } else if (chbPineApple.isChecked()) {
                toppingPrice += 15;
                toppingSummary += "- Pineapple (₱15)\n";
            } else if (chbExtraCheese.isChecked() && chbMushrooms.isChecked()) {
                toppingPrice += 20;
                toppingSummary += "- Extra Cheese & Mushrooms (₱20)\n";
            } else {
                toppingSummary += "- No valid topping combination selected.\n";
            }

            // Final output
            String result = pizzaType + "\n" + toppingSummary + "Total Topping Price: ₱" + toppingPrice;
            pizzaText.setText(result);
        });
    }
}
