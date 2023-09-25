package com.example.mobile_lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addNewNote extends AppCompatActivity {

    private Button saveNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_note);

        saveNote = findViewById(R.id.saveNote_btn);
        saveNote.setOnClickListener(


                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        navigateMainPage();
                    }
                }

        );

    }

    public void navigateMainPage(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
