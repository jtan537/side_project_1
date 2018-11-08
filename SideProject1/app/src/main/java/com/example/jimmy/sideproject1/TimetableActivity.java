package com.example.jimmy.sideproject1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TimetableActivity extends AppCompatActivity {

    private static String[] courseCodes = new String[6];

    private static List<TextView> timeSlots = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
    }

    private void initializeTimeSlots(Context context) {
        this.timeSlots.clear();

    }
}
