package com.example.mobile_lab;

import android.content.ActivityNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addNewNote extends AppCompatActivity {

    private Button saveNote;
    private EditText titleText;
    private EditText descriptionText;
    private View updateColor;
    private ImageView attachedImg;

    private SQLiteManager db  = new SQLiteManager(this);
//    public int noteColour = (ResourcesCompat.getColor(getResources(), R.color.red, null));

    private final int REQUEST_IMAGE_CAPTURE = 100;
    private final int REQUEST_IMAGE_GALLERY = 200;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode ==RESULT_OK){

            if (requestCode==REQUEST_IMAGE_CAPTURE){
                // received from camera

                Bitmap img = (Bitmap)(data.getExtras().get("data"));
                attachedImg.setImageBitmap(img);

            } else if (requestCode==REQUEST_IMAGE_GALLERY){
                //received from gallery
                Uri imageUri = data.getData();

                attachedImg.setImageURI(imageUri);

            }

        }



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_note);

        updateColor = findViewById(R.id.colourSelected);
        titleText = findViewById(R.id.noteTitle);
        descriptionText = findViewById(R.id.noteDesc);
        saveNote = findViewById(R.id.saveNote_btn);
        attachedImg = findViewById(R.id.attachedImg);




    }



    public void saveNoteClick(View v){

        if (titleText.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter note title", Toast.LENGTH_SHORT).show();
        } else {
            // create note

            Bitmap imgBmp = ((BitmapDrawable)attachedImg.getDrawable()).getBitmap();

            byte[] imgData = DbBitmapUtility.getBytes(imgBmp);

            Note note = new Note(titleText.getText().toString(),
                                 descriptionText.getText().toString(),
                                 ((ColorDrawable)updateColor.getBackground()).getColor(),
                                imgData);

            db.addDatabaseNote(note);

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        }

    }


    public void uploadPictureClick(View v){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_IMAGE_GALLERY);


    }



    public void capturePictureClick(View v){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }



    }

    public void clickBlue(View v){
        int colorLocal = (ResourcesCompat.getColor(getResources(), R.color.blue, null));
        updateColor.setBackgroundColor(colorLocal);
    }

    public void clickMaroon(View v){
        int colorLocal = (ResourcesCompat.getColor(getResources(), R.color.maroon, null));
        updateColor.setBackgroundColor(colorLocal);
    }

    public void clickYellow(View v){
        int colorLocal = (ResourcesCompat.getColor(getResources(), R.color.yellow, null));
        updateColor.setBackgroundColor(colorLocal);
    }

    public void cancelClick(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
