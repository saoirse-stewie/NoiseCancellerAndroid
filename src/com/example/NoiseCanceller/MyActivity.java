package com.example.NoiseCanceller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;


public class MyActivity extends Activity {
    private static final int REQUEST_PICKER = 1;
    private static final int PICK_FROM_FILE = 1;
    final static int RQS_RECORDING = 1;
    Uri savedUri;
    Button b;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        b = (Button)findViewById(R.id.btn1);

      b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(
                       MediaStore.Audio.Media.RECORD_SOUND_ACTION);
               startActivityForResult(intent, RQS_RECORDING);
         //      Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
         //      intent.setType("image/*");
         //      startActivityForResult(Intent.createChooser(intent, "Complete action using"), REQUEST_PICKER);

           }
       });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RQS_RECORDING) {
            savedUri = data.getData();
            Toast.makeText(MyActivity.this,
                    "Saved: " + savedUri.getPath(), Toast.LENGTH_LONG).show();
        }
     //   if (resultCode != RESULT_OK)
           // return;
    //    if (requestCode == PICK_FROM_FILE) {
            // Get Uri of the file selected,
           // Uri theImageUri = data.getData();
            // Or if you want a Bitmap,
           // try {
            //    Bitmap theBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), theImageUri);
            ///} catch (IOException e) {
            //    e.printStackTrace();
           // }
        }



    }

