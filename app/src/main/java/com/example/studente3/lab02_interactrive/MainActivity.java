package com.example.studente3.lab02_interactrive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        originalMessage();
        displayMessage();
    }

    private int mNumber = 0;
    private int mPrice = 50;
    private String mName = "卡卡西";
    private String mNT = "NT$";
    private StringBuilder mMessage =new StringBuilder();
    private StringBuilder mNumberText = new StringBuilder();




    public void order(View view) {
        resetPrice();
        setPrice();
        displayMessage();
    }

    public void increase(View view) {
        ++mNumber;
        displayQuantity();
        resetPrice();
        originalMessage();
        displayMessage();
    }

    public void decrease(View view) {

        if (mNumber > 0) {
            mNumber--;
        }
        displayQuantity();
        resetPrice();
        originalMessage();
        displayMessage();
    }

    private void setPrice() {
        CheckBox checkbox = (CheckBox)findViewById(R.id.toppings_checkbox);
        int money = mPrice * mNumber;
        mMessage.append("Name: ")
                .append(mName)
                .append("\n")
                .append("是否加泡菜?")
                .append(checkbox.isChecked())
                .append("\n");
        if (mNumber == 0){
            mMessage.append("Free");
        }else{
            mMessage.append("Quantity: ")
                    .append(mNumber)
                    .append("\n")
                    .append("價錢: ")
                    .append(money);
        }
    }

    private void displayMessage() {
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(mMessage);
    }

    private void displayQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        resetQuantity();
        mNumberText.append(mNumber);
        quantityTextView.setText(mNumberText);
    }
    private void resetPrice(){
        int start = 0;
        int end = mMessage.length();
        mMessage.delete(start, end);
    }

    private void originalMessage() {
        mMessage.append("臭豆腐")
                .append(mNT)
                .append(mPrice);
    }

    public void resetQuantity() {
        int start = 0;
        int end = mNumberText.length();
        mNumberText.delete(start, end);
    }

    public void pickle(View view) {
        resetPrice();
        originalMessage();
        displayMessage();
    }
}
