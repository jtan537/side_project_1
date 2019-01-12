package com.example.jimmy.sideproject1;

import java.util.ArrayList;
import java.util.List;

/**
 * The lecture class with some properties.
 */
public class Lecture {

    /**
     * The hashmap contains all sections of this course, te keys are the section number and the
     * values are the time
     */
    private List<DailyClass> timeLst;

    /**
     * The section code for this course, i.e. 'Lec 0501'
     */
    private String sectionCode;

    /**
     * The course code for this section, i.e. 'CSC148'.
     */
    private String courseCode;

    /**
     * Initialize the lecture object but set the hashmap and section code
     *
     * @param sectionCode section code as a string, i.e. 'Lec 0501'
     * @param time        the list with starting time and end time, i.e. [18, 21]
     */
    Lecture(String course, String sectionCode, List<DailyClass> time) {
        this.sectionCode = sectionCode;
        this.timeLst = time;
        this.courseCode = course;
    }

    /**
     * Add a new class to the time list
     *
     * @param class_ the new DailyClass object to add.
     */
    void addClass(DailyClass class_) {
        this.timeLst.add(class_);
    }

    /**
     * Return the hashmap contains all time information about this section.
     * Format: {'Monday': [18, 21], 'Friday': [14, 16]}
     *
     * @return The time hashmao
     */
    List<DailyClass> getTimeLst() {
        return timeLst;
    }

    /**
     * Return the section code
     *
     * @return section code as a string, i.e. 'Lec0501'.
     */
    String getSectionCode() {
        return sectionCode;
    }

    /**
     * Return the course code.
     *
     * @return course code as a string, i.e. 'CSC207'.
     */
    String getCourseCode() {
        return courseCode;
    }

    /**
     * Check if other lecture has any time overlap with this lecture.
     *
     * @param o other lecture object to check
     * @return true if two lecture has any time overlap, false otherwise.
     */
    boolean hasOverlap(Lecture o) {
        for (DailyClass c : timeLst) {
            if (findDate(c.getDate(), o.getTimeLst()).size() > 0) {
                for (DailyClass d : findDate(c.getDate(), o.getTimeLst())) {
                    if (overLap(c, d)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Helper to find the DailyClass object with the given date
     *
     * @param date the date to find.
     * @param lst  the arraylist contains DailyClass object to check.
     * @return the object has the same date, null otherwise.
     */
    private ArrayList<DailyClass> findDate(String date, List<DailyClass> lst) {
        ArrayList<DailyClass> return_list = new ArrayList<>();
        for (DailyClass d : lst) {
            if (d.getDate().equals(date)) {
                return_list.add(d);
            }
        }
        return return_list;
    }

    /**
     * A helper to check if two list have any time overlap
     *
     * @param lst1 the first list with two integers, first is starting time and second is end time.
     * @param lst2 second list in the format same as above
     * @return true if two list have overlap false otherwise.
     */

    //
    private static boolean overLap(DailyClass lst1, DailyClass lst2) {
        return ((lst1.getEnd() > lst2.getStart() && lst1.getEnd() < lst2.getEnd())) ||
                ((lst1.getStart() > lst2.getStart() && lst1.getStart() < lst2.getEnd())) ||
                (lst2.getEnd() > lst1.getStart() && lst2.getEnd() < lst1.getEnd()) ||
                ((lst2.getStart() > lst1.getStart() && lst2.getStart() < lst1.getEnd())) ||
                (lst1.getStart() == lst2.getStart() && lst1.getEnd() == lst2.getEnd());
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "timeLst=" + timeLst +
                ", sectionCode='" + sectionCode + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
