package com.ivart.helptodecide;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class Description extends AppCompatActivity implements View.OnClickListener {

    DbHelper dbHelper;
    private int squareNumber;
    EditText solutionDescription;
    RatingBar raitingBar;
    Button addDescription;
    String solutionTitle;
    int solutionId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            solutionId = savedInstanceState.getInt("id_solution");
        }
        dbHelper = new DbHelper(this);
        setContentView(R.layout.activity_description);
        Intent intent = getIntent();
        squareNumber = intent.getIntExtra("Square_0",0);
        solutionTitle = intent.getStringExtra("DescTitle");

        solutionDescription = (EditText)findViewById(R.id.solution_description);
        raitingBar = (RatingBar)findViewById(R.id.raiting_bar);
        addDescription = (Button)findViewById(R.id.addDescription);
        addDescription.setOnClickListener(this);

        Toast.makeText(this,"" + squareNumber,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addDescription:
                String text = solutionDescription.getText().toString();
                float rating = raitingBar.getRating();
                addOneDescription(solutionTitle,text,rating);
                Description.this.finish();
                break;
        }
    }

    public void addOneDescription(String title, String text, float rait){
        SQLiteDatabase dataBase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.KEY_SOLUTION_NAME, title);
        dataBase.insert(DbHelper.TABLE_SOLUTION,null,contentValues);
        contentValues.clear();
        contentValues.put(DbHelper.KEY_SOLUTION_TEXT,text);
        contentValues.put(DbHelper.KEY_SOLUTION_PRIORITY,rait);
        dataBase.insert(DbHelper.TABLE_SOLUTION_DESCRIPTION,null,contentValues);
        Cursor cursor = dataBase.query(dbHelper.TABLE_SOLUTION,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            int idIndex = cursor.getColumnIndex(dbHelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(dbHelper.KEY_SOLUTION_NAME);
//            int idIndex = cursor.getColumnIndex(dbHelper.KEY_ID);
//            int solutionDescIndex = cursor.getColumnIndex(dbHelper.KEY_SOLUTION_TEXT);
//            int solutionPriorityIndex = cursor.getColumnIndex(dbHelper.KEY_SOLUTION_PRIORITY);
            do{
                Log.d("mLog ", "ID = " + cursor.getInt(idIndex) +
                        ", Description = " + cursor.getString(nameIndex));
//                Log.d("mLog ", "ID = " + cursor.getInt(idIndex) +
//                        ", Description = " + cursor.getString(solutionDescIndex)+
//                        ", Priority = " + cursor.getString(solutionPriorityIndex));
            }while(cursor.moveToNext());
        }
        else Log.d("m.Log","0 rows");
        cursor.close();
        dbHelper.close();
        dataBase.close();

    }

}
