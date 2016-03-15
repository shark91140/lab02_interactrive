package com.example.studente3.lab02_interactrive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int mNumber = 0;
    private int mPrice = 10;
    private String mNT = "NT$";
    private StringBuilder mSB =new StringBuilder(mNT);

    public void order(View view) {

        displayPrice();
    }

    public void increase(View view) {

        displayQuantity(++mNumber);
        resetPrice();
    }

    private int getNumber() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        String numStr = quantityTextView.getText().toString();
        return Integer.parseInt(numStr);
    }

    public void decrease(View view) {

        if (mNumber > 0) {
            mNumber--;
        } else {
            mNumber = 0;
        }
        displayQuantity(mNumber);
        resetPrice();
    }

    private void displayPrice() {

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int money = mPrice * mNumber;
        int start = mNT.length();
        int end =mSB.length();
        mSB.delete(start,end).append(money)
                .append(money == 0 ? "\nFree" : "\nThank you");
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(mSB);
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));
    }
    private void resetPrice(){
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(" ");
    }

    public void resetQuantity(View view) {
        mNumber = 0;
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(mNumber));
                resetPrice();
    }
}
