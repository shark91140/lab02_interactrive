package com.example.studente3.lab02_interactrive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selfDestruct(View view) {

        display(0);
    }
    public void add(View view) {
        int number = getNumber();
        number++   ;
        display(number);
    }

    private int getNumber() {
        TextView quantitytextview = (TextView) findViewById(R.id.quantity_text_view);
        String numStr = quantitytextview.getText().toString();
        return Integer.parseInt(numStr);
    }

    public void Subtract(View view) {
        int number = getNumber();

        if (number>0){
            number--;
        }else {number = 0;}

        display(number);
    }

    private void display(int number) {

        TextView quantitytextview = (TextView) findViewById(R.id.quantity_text_view);
        quantitytextview.setText(String.valueOf(number));
        int money = 10 * number;
        String mymoney = NumberFormat.getCurrencyInstance().format(money);
        TextView price = (TextView) findViewById(R.id.price);
        if (number == 0){
            price.setText("Free\n "+mymoney);
        }
        if (number > 0){
            price.setText("Thank you\n "+mymoney);
        }

    }
}
