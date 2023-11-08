package com.example.mobile_lab;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    public TextView titleLabel;
    public TextView descriptionLabel;
    public LinearLayout noteItemLayout;
    public ImageView noteImgView;

    public CardView cardView;

    public NoteViewHolder(View itemView) {
        super(itemView);
        titleLabel = itemView.findViewById(R.id.titleLabel);
        descriptionLabel = itemView.findViewById(R.id.descriptionLabel);
        noteItemLayout = itemView.findViewById(R.id.noteItemLayout);
        noteImgView = itemView.findViewById(R.id.noteImage);


        cardView = itemView.findViewById(R.id.mainContainer);
    }
}

