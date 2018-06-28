package com.example.android.gestures;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

    TextView tv;
    GestureDetectorCompat gdc;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView)findViewById(R.id.textView1);
        this.gdc= new GestureDetectorCompat(this,this);//context, listener
        //gdc.setOnDoubleTapListener(this);
    }


    //Implementing the methods of GestureDetector.OnGestureListener

    @Override
    public boolean onDown(MotionEvent e) {
        tv.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        tv.setText("onPress" );
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        tv.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        tv.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(   MotionEvent e) {
        tv.setText("OnLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        tv.setText("onFling");
        Intent i1 = new Intent (MainActivity.this, Activity2.class);
        startActivity(i1);
        return true;
    }


    //////Methods of GestureDetector.OnDoubleTapListener


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        tv.setText("OnSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        tv.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        tv.setText("OnDoubleTapEvent");
        return true;
    }

//This is the main method because of which every thing works
//Method of AppCompatibilt
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gdc.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

}
