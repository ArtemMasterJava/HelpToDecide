package com.ivart.helptodecide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Description extends AppCompatActivity {

    private int squareNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Intent intent = getIntent();
        squareNumber = intent.getIntExtra("Square_0",0);

        Toast.makeText(this,"" + squareNumber,Toast.LENGTH_SHORT).show();

    }
}
