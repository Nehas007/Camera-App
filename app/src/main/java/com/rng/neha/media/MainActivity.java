package com.rng.neha.media;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.R.attr.thumbnail;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Uri pictureUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCamera = (Button)findViewById(R.id.btnCamera);
        imageView = (ImageView)findViewById(R.id.imageView);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                pictureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"fname_" +String.valueOf(System.currentTimeMillis()) + ".jpg"));
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,pictureUri);
                startActivityForResult(cameraIntent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //  Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        //  imageView.setImageBitmap(bitmap);
    }

}

