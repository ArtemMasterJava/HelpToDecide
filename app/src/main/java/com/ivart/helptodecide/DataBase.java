package com.ivart.helptodecide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ivan on 8/1/2016.
 */
public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context) {
        super(context, "DescisionDB", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Squares(id integer primary key autoincrement, " +
                                            "question text)");
        db.execSQL("create table Descision(id integer primary key autoincrement, " +
                                            "descicionTitle text)");
        db.execSQL("create table Description(id integer primary key autoincrement, " +
                                            "descision integer, square integer," +
                                            "FOREIGN KEY(descision) REFERENCES Descision(id)," +
                                            "FOREIGN KEY(square) REFERNCES Squares(id))");

        //didn't try to start, just for remember schema
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
