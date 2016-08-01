package com.ivart.helptodecide.menu_items;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import com.ivart.helptodecide.Description;
import com.ivart.helptodecide.R;

/**
 * Created by Artem on 08.07.2016.
 */
public class Decide extends Activity {

    public EditText descriptionTitile;
    public Button willIfItHappens;
    public Button willIfItDoesnt;
    public Button wontIfItHappens;
    public Button wontIfItDoesnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.go_to_decide_layout);

        descriptionTitile = (EditText)findViewById(R.id.descisionTitle);
        willIfItHappens = (Button)findViewById(R.id.btn_will_if_it_happens);
        willIfItDoesnt = (Button)findViewById(R.id.btn_will_if_it_doesnt);
        wontIfItHappens = (Button)findViewById(R.id.btn_wont_if_it_happens);
        wontIfItDoesnt = (Button)findViewById(R.id.btn_wont_if_it_doesnt);

        willIfItHappens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Decide.this, Description.class);
                intent.putExtra("Square_0",0);
                startActivity(intent);
            }
        });

        willIfItDoesnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Decide.this, Description.class);
                intent.putExtra("Square_0",1);
                startActivity(intent);
            }
        });

        wontIfItHappens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Decide.this, Description.class);
                intent.putExtra("Square_0",2);
                startActivity(intent);
            }
        });

        wontIfItDoesnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Decide.this, Description.class);
                intent.putExtra("Square_0",3);
                startActivity(intent);
            }
        });
    }


}
