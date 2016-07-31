package com.ivart.helptodecide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ivart.helptodecide.menu_items.About;
import com.ivart.helptodecide.menu_items.Decide;
import com.ivart.helptodecide.menu_items.MyDecide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, Decide.class);
        startActivity(intent);
    }

    public void onClick1(View view) {
        Intent intent = new Intent(MainActivity.this, MyDecide.class);
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(MainActivity.this, About.class);
        startActivity(intent);
    }
}
