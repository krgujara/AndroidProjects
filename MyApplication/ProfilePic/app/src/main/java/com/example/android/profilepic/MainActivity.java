package com.example.android.profilepic;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView imageview;
    private static final int SELECT_FILE = 1;
    private static final int REQUEST_CAMERA = 2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview = (ImageView) findViewById(R.id.imageView);
        b1 = (Button) findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setItems(getResources().getStringArray(R.array.pickdialogfrom), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which) {
                            case 0:
                                userChoosenTask = "Take Photo";

                                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                File file = getFile();
                                i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                                startActivityForResult(i, REQUEST_CAMERA);
                                break;
                            case 1:
                                Intent i1 = new Intent(Intent.ACTION_PICK);
                                i1.setType("image/*");
                                startActivityForResult(i1, SELECT_FILE);
                                Toast.makeText(MainActivity.this, "Select from gallary", Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
     /*   if ((requestCode == 0) && (resultCode == Activity.RESULT_OK)) {
            String path = "sdcard/camera_app/cam_image.jpg";
            imageview.setImageDrawable(Drawable.createFromPath(path));
            Toast.makeText(MainActivity.this, "On Activity result", Toast.LENGTH_LONG).show();
        }
*/
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }


    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        imageview.setImageBitmap(bm);
    }


    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        imageview.setImageBitmap(thumbnail);
    }



    public File getFile() {
        File folder = new File("sdcard/camera_app");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File image = new File(folder, "cam_image.jpg");
        image.
        return image;
    }
}


