package com.example.mobile_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.newNote_btn);
        b1.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openNewNotePage();
                    }
                }
        );
    }

    public void openNewNotePage(){
        Intent i = new Intent(this, addNewNote.class);
        startActivity(i);

    }
}