package com.example.pizzaapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton rbHawaiian, rbHamCheese;

    Button btnProcessOrder, btnNewOrder;

    RadioButton rbSmall, rbMedium, rbLarge;
    RadioButton rbThin, rbThick;

    CheckBox chbExtraCheese, chbMushrooms, chbOnions, chbTomatoes, chbPineApple, chbPwdSen;
    TextView pizzaText ,txtSizeAndCrust, txtSizeAndCrustPrice, txtExtraToppings, txtExtraTopPrice,totalPrice,txtVatDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link Layout components to variables
        // repeat this pattern for RadioGroups for Size and Crust, CheckBoxes for toppings,TextView for order summary
        // To be used on validation and displaying the result.

        rbHawaiian = findViewById(R.id.rbHawaiian);
        rbHamCheese = findViewById(R.id.rbHamCheese);
        btnProcessOrder = findViewById(R.id.btnProcessOrder);
        btnNewOrder =  findViewById(R.id.btnNewOrder);
        rbSmall = findViewById(R.id.rbSmall);
        rbMedium = findViewById(R.id.rbMedium);
        rbLarge = findViewById(R.id.rbLarge);

        rbThin = findViewById(R.id.rbThin);
        rbThick = findViewById(R.id.rbThick);

        pizzaText = findViewById(R.id.pizza);
        txtSizeAndCrust = findViewById(R.id.txtSizeAndCrust);
        txtSizeAndCrustPrice = findViewById(R.id.txtSizeAndCrustPrice);
        totalPrice= findViewById(R.id.totalPrice);
        txtVatDisplay = findViewById(R.id.txtVatDisplay);

        txtExtraToppings = findViewById(R.id.txtExtraToppings);
        txtExtraTopPrice = findViewById(R.id.txtExtraTopPrice);

        chbExtraCheese = findViewById(R.id.chbExtraCheese);
        chbMushrooms = findViewById(R.id.chbMushrooms);
        chbOnions = findViewById(R.id.chbOnions);
        chbTomatoes = findViewById(R.id.chbTomatoes);
        chbPineApple = findViewById(R.id.chbPineApple);
        btnProcessOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Crust
                rbThin = findViewById(R.id.rbThin);
                rbThick = findViewById(R.id.rbThick);
                int sizePrice = 0;
                String pizzaType = "";
                String size = "";
                if (rbHawaiian.isChecked()) {
                    //---------------Continue Code Here---------------
                    pizzaText.setText("Your pizza is Hawaiian");
                    if (rbSmall.isChecked()) {
                        sizePrice = 100;
                        size = " Small";
                    } else if (rbMedium.isChecked()) {
                        sizePrice = 150;
                        size = " Medium";
                    }else if (rbLarge.isChecked()){
                        sizePrice = 200;
                        size = " Large";
                    }
                } else if (rbHamCheese.isChecked()) {
                    //---------------Continue Code Here---------------
                    pizzaText.setText("Your pizza is Ham and Cheese");
                    if (rbSmall.isChecked()) {
                        sizePrice = 200;
                        size = " Small";
                    } else if (rbMedium.isChecked()) {
                        sizePrice = 300;
                        size = " Medium";
                    } else if (rbLarge.isChecked()) {
                        sizePrice = 400;
                        size = " Large";
                    } else {
                        Toast.makeText(MainActivity.this, "Please select a size!", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Please Select Pizza Type to Proceed with Your Order!", Toast.LENGTH_SHORT).show();
                }
                String crust = "";
                double crustPrice;
                double totalCrustAndSizePrice;
                if (rbThin.isChecked()) {
                    crust = "Thin";
                    crustPrice = 0.0;
                } else if (rbThick.isChecked()) {
                    crust = "Thick";
                    crustPrice = sizePrice * 0.5;
                } else {
                    Toast.makeText(MainActivity.this, "Please select a crust type!", Toast.LENGTH_SHORT).show();
                    return;
                }
                int toppingPrice = 0;
                String toppingSummary="";
                // Validate combinations
                if (chbTomatoes.isChecked()) {
                    toppingPrice += 10;
                    toppingSummary += " Tomatoes ";
                }

                if (chbOnions.isChecked()) {
                    toppingPrice += 10;
                    toppingSummary += " Onions ";
                }

                if (chbPineApple.isChecked()) {
                    toppingPrice += 15;
                    toppingSummary += " Pineapple ";
                }

                if (chbExtraCheese.isChecked()) {
                    toppingPrice += 20;
                    toppingSummary += " Extra Cheese ";
                }

                if (chbMushrooms.isChecked()) {
                    toppingPrice += 20;
                    toppingSummary += " Mushrooms ";
                }


                totalCrustAndSizePrice = sizePrice + crustPrice;
                double totalSum=0.0;
                txtSizeAndCrust.setText(size + " And " + crust);
                txtSizeAndCrustPrice.setText("="+(String.valueOf(totalCrustAndSizePrice)));
                txtExtraToppings.setText(toppingSummary);
                txtExtraTopPrice.setText("="+(String.valueOf(toppingPrice)));

                totalSum = totalCrustAndSizePrice + toppingPrice;

                chbPwdSen = findViewById(R.id.chbPwdSen);
                double discount=0.0;
                if (chbPwdSen.isChecked()){

                    //  Compute 20% discount
                    discount = totalSum * 0.20;

                }
                //Remove VAT (12% VAT inclusive price)
                double vatExclusivePrice = totalSum / 1.12;


                // Step 3: Compute final price after discount
                double finalPrice = vatExclusivePrice - discount;

                totalPrice.setText("=" + String.format("%.2f", finalPrice));
                txtVatDisplay.setText("VAT: " + String.format("%.2f", totalSum - vatExclusivePrice));


            }
        });


        btnNewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Uncheck RadioButtons
                rbHawaiian.setChecked(false);
                rbHamCheese.setChecked(false);
                rbSmall.setChecked(false);
                rbMedium.setChecked(false);
                rbLarge.setChecked(false);
                rbThin.setChecked(false);
                rbThick.setChecked(false);

                // Uncheck CheckBoxes
                chbExtraCheese.setChecked(false);
                chbMushrooms.setChecked(false);
                chbOnions.setChecked(false);
                chbTomatoes.setChecked(false);
                chbPineApple.setChecked(false);
                chbPwdSen.setChecked(false);

                // Clear TextViews
                pizzaText.setText("");
                txtSizeAndCrust.setText("");
                txtSizeAndCrustPrice.setText("");
                txtExtraToppings.setText("");
                txtExtraTopPrice.setText("");
                totalPrice.setText("");
                txtVatDisplay.setText("");

                Toast.makeText(MainActivity.this, "Order Reset", Toast.LENGTH_SHORT).show();
            }
        });


    }

}