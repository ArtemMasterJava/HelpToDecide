package com.ivart.helptodecide.menu_items;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.ivart.helptodecide.data.DbHelper;
import com.ivart.helptodecide.R;
import com.ivart.helptodecide.data.solution.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem on 08.07.2016.
 */
public class MyDecide extends Activity{

    DbHelper dbHelper;
    List<Solution> mySolutions;
    ListView listView;
    Button clearSolutions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_decide);
        clearSolutions = (Button)findViewById(R.id.clearDb);
        dbHelper = new DbHelper(this);
        mySolutions = dbHelper.getAllSolutions();
        List<String> solutionTitles = new ArrayList<>();
        if(mySolutions !=null) {
            for (Solution solution : mySolutions) {
                String name = solution.getSolutionName();
                solutionTitles.add(name);
            }
            listView = (ListView) findViewById(R.id.listView);
            ArrayAdapter<String> solutionArrayAdapter =
                    new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, solutionTitles);
            listView.setAdapter(solutionArrayAdapter);
        }
        clearSolutions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteDb();
            }
        });
        }
    }
