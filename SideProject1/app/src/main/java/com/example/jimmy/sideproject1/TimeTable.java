package com.example.jimmy.sideproject1;

import java.util.ArrayList;
import java.util.List;

/**
 * The timetable class. This is the timetable that will be displayed.
 */
public class TimeTable {
    /**
     * The Arraylist contains classes on each day of the week.
     */
    private ArrayList<DailyClass> dailyClasses = new ArrayList<>();


    /**
     * Putting each DailyClass object into corresponding list according to its date.
     *
     * @param lecture the lecture object with a list contains DailyClass objects.
     */
    TimeTable(Lecture lecture) {
        for (DailyClass d : lecture.getTimeLst()) {
            dailyClasses.add(d);
        }
    }

    /**
     * Return Monday class list.
     *
     * @return the list contains all Monday class.
     */
    public List<DailyClass> getDailyClasses() {
        return dailyClasses;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "dailyClasses=" + dailyClasses +
                '}';
    }
}
