package com.example.jimmy.sideproject1;

import java.util.HashMap;

/**
 * The lecture class with some properties.
 */
public class Lecture {

    /**
     * The hashmap contains all sections of this course, te keys are the section number and the
     * values are the time
     * The format: {'Monday': [18, 21], 'Wednesday': [17, 20]}
     */
    private HashMap<String, Time> timeLst;

    /**
     * The section code for this course, i.e. 'Lec 0501'
     */
    private String sectionCode;

    /**
     * Initialize the lecture object but set the hashmap and section code
     *
     * @param sectionCode section code as a string, i.e. 'Lec 0501'
     * @param time        the list with starting time and end time, i.e. [18, 21]
     */
    public Lecture(String sectionCode, HashMap<String, Time> time) {
        this.sectionCode = sectionCode;
        this.timeLst = time;
    }

    /**
     * Return the hashmap contains all time information about this section.
     * Format: {'Monday': [18, 21], 'Friday': [14, 16]}
     *
     * @return The time hashmao
     */
    public HashMap<String, Time> getTimeLst() {
        return timeLst;
    }

    /**
     * Return the section code
     *
     * @return section code as a string, i.e. 'Lec0501'.
     */
    public String getSectionCode() {
        return sectionCode;
    }

    /**
     * Check if other lecture has any time overlap with this lecture.
     *
     * @param o other lecture object to check
     * @return true if two lecture has any time overlap, false otherwise.
     */
    public boolean hasOverlap(Lecture o) {
        for (String key : o.getTimeLst().keySet()) {
            if (timeLst.containsKey(key) && (overLap(timeLst.get(key), o.getTimeLst().get(key)))) {
                return true;
            }
        }
        return false;
    }

    /**
     * A helper to check if two list have any time overlap
     *
     * @param lst1 the first list with two integers, first is starting time and second is end time.
     * @param lst2 second list in the format same as above
     * @return true if two list have overlap false otherwise.
     */
    private boolean overLap(Time lst1, Time lst2) {
        return (lst1.getEnd() > lst2.getStart() || lst1.getEnd() < lst2.getEnd()) ||
                (lst1.getStart() > lst2.getStart() || lst1.getStart() < lst2.getEnd()) ||
                lst1 == lst2;
    }
}
