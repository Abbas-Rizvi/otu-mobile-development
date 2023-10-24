package com.example.mobile_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.SearchView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton b1;
    private RecyclerView notesRecycler;
    private SQLiteManager db;

    private NoteAdapter noteAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new SQLiteManager(this);
        b1 = findViewById(R.id.newNote_btn);

        notesRecycler = (RecyclerView) findViewById(R.id.noteRecycler);

        ArrayList<Note> noteItems = new ArrayList<Note>();

        notesRecycler.setLayoutManager(new LinearLayoutManager(this));

        db.open();

        noteItems = viewNotes();

        noteAdapter = new NoteAdapter(noteItems);
        notesRecycler.setAdapter(noteAdapter);


        searchView = findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newText) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                noteAdapter.filter(newText);
                return true;
            }
        });
    }

    public void openNewNotePage(View v){
        Intent i = new Intent(this, addNewNote.class);
        startActivity(i);

    }



    private ArrayList<Note> viewNotes() {

        ArrayList<Note> allNotes = new ArrayList<Note>();
        Cursor cursor = db.getAllNotes();

        if (cursor != null) {

            while (cursor.moveToNext()) {
                String title = cursor.getString(cursor.getColumnIndexOrThrow(SQLiteManager.FeedEntry.COLUMN_NAME_TITLE));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(SQLiteManager.FeedEntry.COLUMN_NAME_DESCRIPTION));
                int color = cursor.getInt(cursor.getColumnIndexOrThrow(SQLiteManager.FeedEntry.COLUMN_NAME_COLOUR));

                allNotes.add(new Note(title, description, color));
            }
            cursor.close();
        }
        return allNotes; // print the notes from db
    }
}