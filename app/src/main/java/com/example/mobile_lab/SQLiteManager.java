package com.example.mobile_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class SQLiteManager extends SQLiteOpenHelper {

    private static SQLiteManager sqLiteManager;
    private static SQLiteDatabase db;
    private static final String DATABASE_NAME = "NOTE_DATABASE";
    private static final int DATABASE_VERSION = 2;


    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_notes";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "desc";
        public static final String COLUMN_NAME_COLOUR = "colour";

    }

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    FeedEntry.COLUMN_NAME_DESCRIPTION + " TEXT," +
                    FeedEntry.COLUMN_NAME_COLOUR + " INT)";



    public SQLiteManager(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    public void addDatabaseNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE, note.getTitle());
        values.put(FeedEntry.COLUMN_NAME_DESCRIPTION, note.getDescription());
        values.put(FeedEntry.COLUMN_NAME_COLOUR, note.getColour());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);


    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
//        db = sqLiteManager.getWritableDatabase();

    }

    public Cursor getAllNotes() {
        return db.query(FeedEntry.TABLE_NAME, null, null, null, null, null, null);
    }

}
