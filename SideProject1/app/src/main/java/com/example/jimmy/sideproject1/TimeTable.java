package com.example.jimmy.sideproject1;

import java.util.ArrayList;

/**
 * The timetable class. This is the timetable that will be displayed.
 */
public class TimeTable {
    /**
     * The Arraylist contains classes on each day of the week.
     */
    //NEEDED TO INITIALIZE THE ARRAYS U FUCKING RETARD.
    private ArrayList<DailyClass> MonClass = new ArrayList<>();
    private ArrayList<DailyClass> TueClass = new ArrayList<>();
    private ArrayList<DailyClass> WedClass = new ArrayList<>();
    private ArrayList<DailyClass> ThuClass = new ArrayList<>();
    private ArrayList<DailyClass> FriClass = new ArrayList<>();

    /**
     * Putting each DailyClass object into corresponding list according to its date.
     *
     * @param lecture the lecture object with a list contains DailyClass objects.
     */
    TimeTable(Lecture lecture) {
        for (DailyClass d : lecture.getTimeLst()) {
            switch (d.getDate()) {
                case "MONDAY":
                    MonClass.add(d);
                    break;
                case "TUESDAY":
                    TueClass.add(d);
                    break;
                case "WEDNESDAY":
                    WedClass.add(d);
                    break;
                case "THURSDAY":
                    ThuClass.add(d);
                    break;
                default:
                    FriClass.add(d);
                    break;
            }
        }
    }

    /**
     * Return Monday class list.
     *
     * @return the list contains all Monday class.
     */
    public ArrayList<DailyClass> getMonClass() {
        return MonClass;
    }

    /**
     * Return Tuesday class list.
     *
     * @return the list contains all Tuesday class.
     */
    public ArrayList<DailyClass> getTueClass() {
        return TueClass;
    }

    /**
     * Return Wednesday class list.
     *
     * @return the list contains all Wednesday class.
     */
    public ArrayList<DailyClass> getWedClass() {
        return WedClass;
    }

    /**
     * Return Thursday class list.
     *
     * @return the list contains all Thursday class.
     */
    public ArrayList<DailyClass> getThuClass() {
        return ThuClass;
    }

    /**
     * Return Friday class list.
     *
     * @return the list contains all Friday class.
     */
    public ArrayList<DailyClass> getFriClass() {
        return FriClass;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "MonClass=" + MonClass +
                ", TueClass=" + TueClass +
                ", WedClass=" + WedClass +
                ", ThuClass=" + ThuClass +
                ", FriClass=" + FriClass +
                '}';
    }
}
