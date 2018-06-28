package com.example.android.learningproperties;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Gujarathi on 5/9/2016.
 */
public class Photo extends Activity implements View.OnClickListener{




    final  static int cameraData=0;
    Bitmap bmp;
    ImageView iv;
    ImageButton ib;
    Button button;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);

        setContentView(R.layout.photo);
        initialize();
        //code to set the default image when the user doesnot set some image.
        //  InputStream is = getResources().openRawResource(R.drawable.android);
        //bmp= BitmapFactory.decodeStream(is);
    }


    public void initialize(){
        iv = (ImageView)findViewById(R.id.ivReturnedPic);
        ib = (ImageButton)findViewById(R.id.ibTakePic);
        button = (Button)findViewById(R.id.bSetWall);
        ib.setOnClickListener(this);
        button.setOnClickListener(this);

    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.ibTakePic :
                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent1, cameraData);
                break;

            case R.id.bSetWall :
                    try {
                        getApplicationContext().setWallpaper(bmp);
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    break;
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data ){
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode== RESULT_OK){
            Bundle extras = data.getExtras();
            bmp = (Bitmap)extras.get("data");
            iv.setImageBitmap(bmp);
        }
    }
}

