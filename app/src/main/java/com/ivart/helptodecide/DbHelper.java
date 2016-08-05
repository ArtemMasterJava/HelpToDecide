package com.ivart.helptodecide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ivan on 8/1/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "helpToDecideDb";
    private static final int DB_VERSION = 1;

    public static final String TABLE_SOLUTION = "MySolutions";
    public static final String TABLE_SOLUTION_DESCRIPTION = "MySolutionDescription";

    public static final String KEY_ID = "_id";
    public static final String KEY_SOLUTION_NAME = "_solution_name";
    public String KEY_SOLUTION_TEXT = "_solution_text";
    public String KEY_SOLUTION_PRIORITY = "_solution_priority";


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_SOLUTION+"("+
                    KEY_ID+" integer primary key autoincrement, "+
                    KEY_SOLUTION_NAME+" text);");
        db.execSQL("create table "+TABLE_SOLUTION_DESCRIPTION+"("+
                    KEY_ID+" integer, "+
                    KEY_SOLUTION_TEXT+" text, "+
                    KEY_SOLUTION_PRIORITY+" real, "+
                    "FOREIGN KEY ("+KEY_ID+") REFERENCES "+TABLE_SOLUTION+"("+KEY_ID+"));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
