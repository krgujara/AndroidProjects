package com.example.android.connectivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView tv1;
    EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        editText1 = (EditText)findViewById(R.id.et1);
        editText2 = (EditText)findViewById(R.id.et2);
        tv1=(TextView)findViewById(R.id.anstxt);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val1 = editText1.getText().toString();
                String val2 = editText2.getText().toString();

                int v1 = Integer.parseInt(val1);
                int v2 = Integer.parseInt(val2);

                int ans  = v1+v2;
                tv1.setText(""+ans);
            }
        });


    }
}
