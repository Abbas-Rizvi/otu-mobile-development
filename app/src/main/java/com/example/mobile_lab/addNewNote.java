package com.example.mobile_lab;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addNewNote extends AppCompatActivity {

    private Button saveNote;
    private EditText titleText;
    private EditText descriptionText;
    private View updateColor;

    private SQLiteManager db  = new SQLiteManager(this);
//    public int noteColour = (ResourcesCompat.getColor(getResources(), R.color.red, null));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_note);

        updateColor = findViewById(R.id.colourSelected);
        titleText = findViewById(R.id.noteTitle);
        descriptionText = findViewById(R.id.noteDesc);
        saveNote = findViewById(R.id.saveNote_btn);




    }

    public void saveNoteClick(View v){

        if (titleText.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter note title", Toast.LENGTH_SHORT).show();
        } else {
            // create note
            Note note = new Note(titleText.getText().toString(),
                                 descriptionText.getText().toString(),
                                 ((ColorDrawable)updateColor.getBackground()).getColor());

            db.addDatabaseNote(note);

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        }

    }

    public void clickRed(View v){
        int colorLocal = (ResourcesCompat.getColor(getResources(), R.color.red, null));
        updateColor.setBackgroundColor(colorLocal);
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

}
