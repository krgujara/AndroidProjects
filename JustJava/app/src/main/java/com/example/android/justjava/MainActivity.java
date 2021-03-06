package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {
    int quantity=2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(quantity);
        displayPrice(quantity*5);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }

    /**
     * This method displays price of the selected items
     */
    private void displayPrice(int number){
        TextView priceTextView=(TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number)+"\nThank you for Buying!!");

    }

    /**
     * This method is to increment the numberOfCoffeesOrdered
     */
    public void increment(View view){
        quantity=quantity+1;

        display(quantity);
    }


    /**
     * This method is to decrement the numberOfCoffeesOrdered
     */
    public void decrement(View view){
        TextView quantityTextView=(TextView)findViewById(R.id.quantity_text_view);
       if(quantity == 0)
       {
           quantity=0;
       }
        else {
           quantity = quantity - 1;
       }
        display(quantity);
    }

}