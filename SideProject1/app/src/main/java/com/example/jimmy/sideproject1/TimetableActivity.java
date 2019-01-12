package com.example.jimmy.sideproject1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The class responsible to generate and show the time tables to the user.
 */
public class TimetableActivity extends AppCompatActivity {

    private int NUM_COLUMNS = 6;

    private int NUM_ROWS = 17;
    /**
     * The GridView to display all time table elements.
     */
    private GridView grid;

    /**
     * Each TextView representing each item to display in the GridView, 2D Array, col then row.
     */
    private List<TextView> timeSlots = new ArrayList<>();

    /**
     * The potential time tables based on the user's course selection.
     */
    private List<TimeTable> timeTables;

    /**
     * The current time table index from the list of available timeTables.
     */
    private int curTableInd = 0;

    /**
     * The current time table, dependent on curTableInd.
     */
    private TimeTable curTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] courseCodes;
        // Fetches the course codes.
        courseCodes = (String[]) getIntent().getSerializableExtra("courseCodes");
        // Convert to list.
        List<String> courses = new ArrayList<>(Arrays.asList(courseCodes));
        CourseManager courseManager = null;
        try {
            courseManager = new CourseManager(courses);
        } catch (IOException e) {
            e.printStackTrace();
        }
        timeTables= courseManager.generate_timetable();
        // Fetches the default time table, i.e the first table in the list if able.
        if (timeTables.size() != 0) {
            curTable = timeTables.get(curTableInd);
        }

        if (curTable != null){
            initializeTimes(this);
            grid = findViewById(R.id.TimetableGridView);
            grid.setNumColumns(NUM_COLUMNS);
        }
        setContentView(R.layout.activity_timetable);
    }

    /**
     * Displays the timetable to the activity's GridView.
     */
    public void display() {
        grid.setAdapter(new TimetableAdapter(timeSlots, NUM_COLUMNS, NUM_ROWS));
    }

    public List<Integer> convertDateWithTimeRangeToGrid(String day, int startTime, int endTime) {
        List<Integer> indicesOfElements = new ArrayList<>();
        int col;
        switch (day) {
            case "Monday":
                col = 1;
                break;
            case "Tuesday":
                col = 2;
                break;
            case "Wednesday":
                col = 3;
                break;
            case "Thursday":
                col = 4;
                break;
            case "Friday":
                col = 5;
                break;
            default:
                col = 1;
        }
        // Convert times to corresponding row coordinate, convert to index value.
        for (int i = startTime - 8 + col; i != endTime - 8 + col; i++) {
            indicesOfElements.add(NUM_COLUMNS * i);
        }
        return indicesOfElements;
    }

    public void fillGridWithClasses(List<DailyClass> dailyClasses) {
        for (DailyClass d : dailyClasses) {
            List<Integer> indicesOfElements = convertDateWithTimeRangeToGrid(d.getDate(), d.getStart(), d.getEnd());
            for (Integer index : indicesOfElements) {
                updateItemText(index, d.getCourseCode());
            }
        }
    }

    /**
     * Updates the elements of the timetable when the user swipes left or right.
     */
    public void updateTimes() {
        // Gets the classes from the current time table.
        List<DailyClass> dailyClasses = curTable.getDailyClasses();

        // Initial header of weekdays.
        updateItemText(1, "Monday");
        updateItemText(2, "Friday");
        updateItemText(3, "Score");
        updateItemText(4, "Rank");
        updateItemText(5, "User");

        // Initial row header of times. (17) items.
        for (int i = 0; i != 16; i++) {
            updateItemText(i % 5, String.valueOf(i + 8) + ": 00");
        }

        // Fill inner grid position with daily classes from current time table.
        fillGridWithClasses(dailyClasses);
    }

    /**
     * Helper method that updates the time item for the grid
     * with new values at the given position.
     *
     * @param index: The position of the item to update.
     * @param text:  The new text the item will get.
     */
    private void updateItemText(int index, String text) {
        TextView temp;
        temp = timeSlots.get(index);
        temp.setText(text);
        timeSlots.set(index, temp);
    }

    /**
     * Creates and sets all the times in timeSlots as null-strings.
     *
     * @param context: The given context of the class activity.
     */
    public void initializeTimes(Context context) {
        this.timeSlots.clear();
        for (int i = 0; i != NUM_ROWS * NUM_COLUMNS - 1; i++) {
            TextView temp = new TextView(context);
            temp.setText("");
            this.timeSlots.add(temp);
        }
    }

    /**
     * Generate the actual time table, based on the current timetable in view.
     */
    private void generateTimeTable() {
        // Clears, updates, and displays the timetable.
        initializeTimes(this);
        updateTimes();
        display();
    }
}
