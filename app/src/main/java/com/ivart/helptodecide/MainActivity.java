package com.ivart.helptodecide;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ivart.helptodecide.data.solution.SolutionTitleDialog;
import com.ivart.helptodecide.menu_items.About;
import com.ivart.helptodecide.menu_items.MyDecide;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mButton;
    private TextView mButton1;
    private TextView mButton2;

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onRestart(){
        super.onRestart();
        setContentView(R.layout.menu_layout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    public void onClick(View view) {

        mButton = (TextView) findViewById(R.id.Button_decide);
        if (mButton != null) {
            mButton.setEnabled(false);
        }

        Timer buttonTimer = new Timer();
        buttonTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mButton.setEnabled(true);
                        Intent intent = new Intent(MainActivity.this, SolutionTitleDialog.class);
                        startActivity(intent);
                    }
                });
            }
        }, 2200);
    }


    public void onClick1(View view) {
        mButton1 = (TextView) findViewById(R.id.Button_myDecide);
        if (mButton1 != null) {
            mButton1.setEnabled(false);
        }

        Timer buttonTimer = new Timer();
        buttonTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mButton1.setEnabled(true);
                        Intent intent = new Intent(MainActivity.this, MyDecide.class);
                        startActivity(intent);
                    }
                });
            }
        }, 2200);
    }

    public void onClick2(View view) {
        mButton2 = (TextView) findViewById(R.id.Button_about);
        if (mButton2 != null) {
            mButton2.setEnabled(false);
        }

        Timer buttonTimer = new Timer();
        buttonTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mButton2.setEnabled(true);
                        Intent intent = new Intent(MainActivity.this, About.class);
                        startActivity(intent);
                    }
                });
            }
        }, 2200);
    }
}
