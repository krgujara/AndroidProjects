package com.example.android.alarmmanagerbroadcast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button set;
    EditText editText;
    static int REQUEST_CODE = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        set = (Button)findViewById(R.id.buttonSetAlarm);
        editText = (EditText)findViewById(R.id.timeSeconds);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                int i = Integer.parseInt(text);

                Intent intent = new Intent(MainActivity.this,MyBroadcastReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,REQUEST_CODE,intent,0);

                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pendingIntent);
                Toast.makeText(MainActivity.this,"Alarm set after "+i+"seconds",Toast.LENGTH_LONG).show();
            }
        });
    }
}
