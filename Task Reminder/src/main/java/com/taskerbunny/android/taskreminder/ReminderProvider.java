package com.taskerbunny.android.taskreminder;

import android.content.ContentProvider;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReminderProvider extends ContentProvider {

    // Database Related Constants
    private static final int DATABASE_VERSION = 1; 
    private static final String DATABASE_NAME = "data";
    private static final String DATABASE_TABLE = "reminders";
    // Database Columns
    public static final String COLUMN_ROWID = "_id";
    public static final String COLUMN_DATE_TIME = "reminder_date_time";
    public static final String COLUMN_BODY = "body";
    public static final String COLUMN_TITLE = "title";
    private static final String DATABASE_CREATE = "create table "
            + DATABASE_TABLE + " (" + COLUMN_ROWID
            + " integer primary key autoincrement, " + COLUMN_TITLE
            + " text not null, " + COLUMN_BODY + " text not null, "
            + COLUMN_DATE_TIME + " integer not null);";

    //
    private SQLiteDatabase mDb;

    @Override
    public boolean onCreate() {
        mDb = new DatabaseHelper(getContext()).getWritableDatabase();

        //
        return true;
    }

    /* */
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            throw new UnsupportedOperationException();
        }
    }
}
