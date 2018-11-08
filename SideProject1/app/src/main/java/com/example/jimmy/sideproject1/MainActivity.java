package com.example.jimmy.sideproject1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String[] courseCodes = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void addGenerateListener(){
        Button generateButton = findViewById(R.id.generate);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText courseText1 = findViewById(R.id.courseCode1);
                EditText courseText2 = findViewById(R.id.courseCode2);
                EditText courseText3 = findViewById(R.id.courseCode3);
                EditText courseText4 = findViewById(R.id.courseCode4);
                EditText courseText5 = findViewById(R.id.courseCode5);

                courseCodes[0] = courseText1.getText().toString();
                courseCodes[1] = courseText2.getText().toString();
                courseCodes[2] = courseText3.getText().toString();
                courseCodes[3] = courseText4.getText().toString();
                courseCodes[4] = courseText5.getText().toString();

                switchToTimetable();
            }
        });
    }

    private void switchToTimetable(){
        Intent tmp = new Intent(this, TimetableActivity.class);
        tmp.putExtra("courseCodes", courseCodes);
        startActivity(tmp);
    }
}
