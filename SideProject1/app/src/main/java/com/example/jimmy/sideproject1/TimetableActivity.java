package com.example.jimmy.sideproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TimetableActivity extends AppCompatActivity {

    private static String[] courseCodes = new String[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
    }
}
