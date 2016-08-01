package com.ivart.helptodecide.menu_items;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ivart.helptodecide.R;

/**
 * Created by Artem on 08.07.2016.
 */
public class Decide extends Activity implements View.OnClickListener {

    public Button willIfItHappens;
    public Button willIfItDoesnt;
    public Button wontIfItHappens;
    public Button wontIfItDoesnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.go_to_decide_layout);

        willIfItHappens = (Button)findViewById(R.id.btn_will_if_it_happens);
        willIfItDoesnt = (Button)findViewById(R.id.btn_will_if_it_doesnt);
        wontIfItHappens = (Button)findViewById(R.id.btn_wont_if_it_happens);
        wontIfItDoesnt = (Button)findViewById(R.id.btn_wont_if_it_doesnt);
    }

    @Override
    public void onClick(View v) {
    }
}
