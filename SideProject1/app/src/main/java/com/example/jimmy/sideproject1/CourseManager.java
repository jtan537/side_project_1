package com.example.jimmy.sideproject1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The manager class where manage the user input and change it into a timetable
 */
public class CourseManager {
    /**
     * The list contains all course object
     */
    private ArrayList<Course> courseLst = new ArrayList<>();

    /**
     * Initialize the course list by get information for each course code and change it into a
     * course object
     *
     * @param courseCodeLst the list contains all the course object.
     */
    public CourseManager(ArrayList<String> courseCodeLst) {
        for (String s : courseCodeLst) {
            this.courseLst.add(getCourse(s));
        }
    }

    public ArrayList<Lecture> generate_timetable() {
        ArrayList<Lecture> timetable = new ArrayList<>();
        for (String k : courseLst.get(0).getSectionLst().keySet()) {
            for (String l : courseLst.get(1).getSectionLst().keySet()) {
                if (!courseLst.get(0).getSectionLst().get(k).hasOverlap(courseLst.get(1).getSectionLst().get(l))) {
                    Lecture temp = merge(courseLst.get(0).getSectionLst().get(k), courseLst.get(1).getSectionLst().get(l));
                    for (String x : courseLst.get(2).getSectionLst().keySet()) {
                        if (!temp.hasOverlap(courseLst.get(2).getSectionLst().get(x))) {
                            temp = merge(temp, courseLst.get(2).getSectionLst().get(x));
                            for (String y : courseLst.get(3).getSectionLst().keySet()) {
                                if (!temp.hasOverlap(courseLst.get(3).getSectionLst().get(y))) {
                                    temp = merge(temp, courseLst.get(3).getSectionLst().get(y));
                                    for (String z : courseLst.get(4).getSectionLst().keySet()) {
                                        if (!temp.hasOverlap(courseLst.get(4).getSectionLst().get(z))) {
                                            temp = merge(temp, courseLst.get(4).getSectionLst().get(z));
                                            timetable.add(temp);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return timetable;
    }

    private Lecture merge(Lecture lec1, Lecture lec2) {
        HashMap<String, int[]> temp = new HashMap<>();
        temp.putAll(lec1.getTimeLst());
        temp.putAll(lec2.getTimeLst());
        return new Lecture(lec1.getSectionCode() + lec2.getSectionCode(), temp);
    }
}
