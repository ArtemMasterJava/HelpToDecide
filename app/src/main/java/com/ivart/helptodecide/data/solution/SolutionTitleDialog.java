package com.ivart.helptodecide.data.solution;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ivart.helptodecide.R;
import com.ivart.helptodecide.data.DbHelper;
import com.ivart.helptodecide.menu_items.Decide;

public class SolutionTitleDialog extends Activity {

    Button createSolution;
    EditText solutionName;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution_title_dialog);
        solutionName = (EditText) findViewById(R.id.solution_title);
        createSolution = (Button) findViewById(R.id.create_solution);
        dbHelper = new DbHelper(this);

        createSolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SolutionTitleDialog.this, Decide.class);
                String name = solutionName.getText().toString();
                long id = dbHelper.createSolution(new Solution(name));
                intent.putExtra("solutionId",id);
                startActivity(intent);
            }
        });
    }

}
