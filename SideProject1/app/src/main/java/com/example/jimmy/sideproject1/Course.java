package com.example.jimmy.sideproject1;

import java.util.ArrayList;

/**
 * The course class with some properties of object Course
 */
public class Course {
    /**
     * The hashmap contains all section information
     * The format: {'Lec 0501': Lecture object #1, 'Lec 0201': Lecture object #2}
     */
    private ArrayList<Lecture> sectionLst;

    /**
     * The course code i.e. 'CSC148'.
     */
    private String courseCode;

    /**
     * Initialize the section list and set course code
     *
     * @param sectionlst the list contains all section information (lecture objects)
     * @param courseCode the course code as a string
     */
    public Course(String courseCode, ArrayList<Lecture> sectionlst) {
        this.courseCode = courseCode;
        this.sectionLst = sectionlst;
    }

    /**
     * Return the list contains all sction information
     *
     * @return the arraylist with key section code and value section information.
     */
    public ArrayList<Lecture> getSectionLst() {
        return sectionLst;
    }

    @Override
    public String toString() {
        return "Course{" +
                "sectionLst=" + sectionLst +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }

    /**
     * Return the course code
     *
     * @return the course code as a string i.e. 'CSC148'
     */
    public String getCourseCode() {
        return courseCode;
    }

}
