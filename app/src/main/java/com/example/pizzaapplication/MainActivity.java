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
    Button btnProcessOrder;

    TextView pizzaText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link Layout components to variables
        // repeat this pattern for RadioGroups for Size and Crust, CheckBoxes for toppings,TextView for order summary
        // To be used on validation and displaying the result.

        pizzaText = findViewById(R.id.pizza);
        rbHawaiian = findViewById(R.id.rbHawaiian);
        rbHamCheese = findViewById(R.id.rbHamCheese);
        btnProcessOrder = findViewById(R.id.btnProcessOrder);

        btnProcessOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbHawaiian.isChecked()) {
                    //---------------Continue Code Here---------------
                    pizzaText.setText("Your pizza is Hawaiian");


                } else if (rbHamCheese.isChecked()) {
                    //---------------Continue Code Here---------------
                    pizzaText.setText("Your pizza is Ham and Cheese");


                }else{

                    Toast.makeText(MainActivity.this, "Please Select Pizza Type to Proceed with Your Order!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}