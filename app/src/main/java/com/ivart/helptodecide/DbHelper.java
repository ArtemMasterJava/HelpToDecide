package com.ivart.helptodecide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Ivan on 8/1/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String LOG = "DatabaseHelper";

    private static final String DB_NAME = "helpToDecideDb";
    private static final int DB_VERSION = 1;

    private static final String TABLE_SOLUTION = "MySolutions";
    private static final String TABLE_SOLUTION_DESCRIPTION = "MySolutionDescription";

    private static final String KEY_ID = "_id";
    private static final String KEY_SOLUTION_NAME = "solution_name";
    private static final String KEY_SOLUTION_TEXT = "solution_text";
    private static final String KEY_SOLUTION_PRIORITY = "solution_priority";
    private static final String KEY_SOLUTION_SQUARE = "solution_square";

    private static final String CREATE_TABLE_SOLUTION = "CREATE TABLE "+TABLE_SOLUTION+"("+
           KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
           KEY_SOLUTION_NAME+" TEXT NOT NULL);";
    private static final String CREATE_TABLE_SOLUTION_DESCRIPTION = "CREATE TABLE "+TABLE_SOLUTION_DESCRIPTION+"("+
            KEY_ID+" INTEGER NOT NULL, "+
            KEY_SOLUTION_SQUARE+" INTEGER NOT NULL, "+
            KEY_SOLUTION_TEXT+" TEXT NOT NULL,"+
            KEY_SOLUTION_PRIORITY+" REAL NOT NULL, "+
            "FOREIGN KEY ("+KEY_ID+") REFERENCES "+TABLE_SOLUTION+"("+KEY_ID+"));";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SOLUTION);
        db.execSQL(CREATE_TABLE_SOLUTION_DESCRIPTION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long createSolution(Solution solution){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_SOLUTION_NAME,solution.getSolutionName());
        long id = database.insert(TABLE_SOLUTION,null,contentValues);
        Cursor cursor = database.query(TABLE_SOLUTION_DESCRIPTION,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            int idIndex = cursor.getColumnIndex(KEY_ID);
            int idSolutionSquare = cursor.getColumnIndex(KEY_SOLUTION_SQUARE);
            int idSolutionText = cursor.getColumnIndex(KEY_SOLUTION_TEXT);
            int idSolutionPriority = cursor.getColumnIndex(KEY_SOLUTION_PRIORITY);
            do{
                Log.d(LOG, "id = "+ cursor.getLong(idIndex)+
                        "; square = "+cursor.getInt(idSolutionSquare)+
                        "; text = "+cursor.getString(idSolutionText)+
                        "; rait = "+cursor.getFloat(idSolutionPriority));
            }while (cursor.moveToNext());
        }
        else Log.d(LOG,"0 rows");
        return id;
    }

    public long createSolutionDescription(SolutionDescription solutionDescription){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, solutionDescription.getId());
        contentValues.put(KEY_SOLUTION_SQUARE,solutionDescription.getSquare());
        contentValues.put(KEY_SOLUTION_TEXT,solutionDescription.getSolutionDescription());
        contentValues.put(KEY_SOLUTION_PRIORITY,solutionDescription.getPriority());
        long solutionDesc = database.insert(TABLE_SOLUTION_DESCRIPTION,null,contentValues);

        Cursor cursor = database.query(TABLE_SOLUTION_DESCRIPTION,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            int idIndex = cursor.getColumnIndex(KEY_ID);
            int idSolutionSquare = cursor.getColumnIndex(KEY_SOLUTION_SQUARE);
            int idSolutionText = cursor.getColumnIndex(KEY_SOLUTION_TEXT);
            int idSolutionPriority = cursor.getColumnIndex(KEY_SOLUTION_PRIORITY);
            do{
                Log.d(LOG, "id = "+ cursor.getLong(idIndex)+
                "; square = "+cursor.getInt(idSolutionSquare)+
                "; text = "+cursor.getString(idSolutionText)+
                "; rait = "+cursor.getFloat(idSolutionPriority));
            }while (cursor.moveToNext());
        }
        else Log.d(LOG,"0 rows");

        return solutionDesc;
    }
}
