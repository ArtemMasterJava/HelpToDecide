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
    long solutionId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DbHelper(this);
        setContentView(R.layout.activity_description);
        Intent intent = getIntent();
        solutionId = intent.getLongExtra("solutionId",0);
        squareNumber = intent.getIntExtra("SquareNumber",0);

        solutionDescription = (EditText)findViewById(R.id.solution_description);
        raitingBar = (RatingBar)findViewById(R.id.raiting_bar);

        addDescription = (Button)findViewById(R.id.addDescription);
        addDescription.setOnClickListener(this);

        Toast.makeText(this,"" + solutionId,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        String description = solutionDescription.getText().toString();
        float rait = raitingBar.getRating();
        switch (v.getId()){
            case R.id.addDescription:
                dbHelper.createSolutionDescription(new SolutionDescription(solutionId,description,squareNumber,rait));
                Description.this.finish();
                break;
        }
    }

}
