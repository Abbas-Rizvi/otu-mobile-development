package com.example.mobile_lab;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private ArrayList<Note> allNotes;
    private ArrayList<Note> filteredNotes;

    public NoteAdapter(ArrayList<Note> notes) {
        allNotes = new ArrayList<>(notes); // Make a copy of the original list
        filteredNotes = new ArrayList<>(notes); // Initialize filteredNotes with allNotes
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note note = filteredNotes.get(position);
        holder.titleLabel.setText(note.getTitle());
        holder.descriptionLabel.setText(note.getDescription());
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(note.getColour());
        holder.noteItemLayout.setBackground(drawable);
    }

    @Override
    public int getItemCount() {
        return filteredNotes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        public TextView titleLabel;
        public TextView descriptionLabel;
        public LinearLayout noteItemLayout;

        public NoteViewHolder(View itemView) {
            super(itemView);
            titleLabel = itemView.findViewById(R.id.titleLabel);
            descriptionLabel = itemView.findViewById(R.id.descriptionLabel);
            noteItemLayout = itemView.findViewById(R.id.noteItemLayout);
        }
    }

    public void filter(String search) {
        filteredNotes.clear();
        if (search.isEmpty()) {
            filteredNotes.addAll(allNotes); // If the query is empty, show all notes
        } else {
            search = search.toUpperCase();
            for (Note note : allNotes) {
                if (note.getTitle().toUpperCase().contains(search) || note.getDescription().toUpperCase().contains(search)) {
                    filteredNotes.add(note);
                }
            }
        }
        notifyDataSetChanged(); // Notify the RecyclerView that the data has changed
    }
}
