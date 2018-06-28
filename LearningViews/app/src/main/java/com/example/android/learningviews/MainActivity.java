package com.example.android.learningviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    EditText e1,e2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);

        e1=(EditText)findViewById(R.id.et1);
        e2=(EditText)findViewById(R.id.et2);

        t1=(TextView)findViewById(R.id.result);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer num1 = Integer.parseInt(e1.getText().toString());
                Integer num2 = Integer.parseInt(e2.getText().toString());
                Integer num3 = num1 + num2;
                t1.setText(num3.toString());
                Toast.makeText(MainActivity.this,"Addition completed",Toast.LENGTH_LONG).show();
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num1 = Integer.parseInt(e1.getText().toString());
                Integer num2 = Integer.parseInt(e2.getText().toString());
                Integer num3 = num1- num2;
                t1.setText(num3.toString());
                Toast.makeText(MainActivity.this, "Substraction Completed",Toast.LENGTH_LONG).show();
            }
        });

    }



    public void Multiplication(View view) {
        Integer mynum1=0;
        Editable editable=e1.getText();
        String i1 =editable.toString();
        try {
            mynum1=Integer.parseInt(i1);
        }catch (NumberFormatException e){
            Toast.makeText(MainActivity.this, "Number is not integer", Toast.LENGTH_LONG).show();
        }
        Integer i2=Integer.parseInt(e2.getText().toString());
        Integer i3=mynum1*i2;
        t1.setText(i3.toString());
        Toast.makeText(MainActivity.this, "Multiplication completed", Toast.LENGTH_LONG).show();
    }


    public void Division(View view) {
        Integer num = Integer.parseInt(e1.getText().toString())+Integer.parseInt(e2.getText().toString());
        t1.setText(num.toString());
        Toast.makeText(MainActivity.this, "Division Completed",Toast.LENGTH_LONG).show();
    }
}
