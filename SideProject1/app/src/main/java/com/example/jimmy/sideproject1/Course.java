package com.example.jimmy.sideproject1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The course class with some properties of object Course
 */
public class Course {
    private HashMap<String, Lecture> sectionLst;
    private String courseCode;

    public Course(ArrayList<Lecture> sectionlst, String courseCode) {
        this.courseCode = courseCode;
        for (Lecture l: sectionlst){
            this.sectionLst.put(l.getSectionCode(), l);
        }
    }

    public HashMap getSectionLst() {
        return sectionLst;
    }

    public String getCourseCode() {
        return courseCode;
    }

}
