package com.example.android.myapplication_285;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();

    }
public void addListenerOnButton(){
    radioSexGroup = (RadioGroup) findViewById(R.id.RadioGroupSex);
    btnDisplay = (Button) findViewById(R.id.button1);

    btnDisplay.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            // get selected radio button from radioGroup
            int selectedId = radioSexGroup.getCheckedRadioButtonId();

            // find the radio button by returned id
            radioSexButton = (RadioButton) findViewById(selectedId);

            Toast.makeText(MainActivity.this,
                    radioSexButton.getText(), Toast.LENGTH_SHORT).show();

        }

    });




}
}
