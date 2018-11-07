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
    private HashMap<String, int[]> timeLst;

    /**
     * The section code for this course
     */
    private String sectionCode;

    public Lecture (String sectionCode, HashMap<String, int[]> time){
        this.sectionCode = sectionCode;
        this.timeLst = time;
    }

    public HashMap<String, int[]> getTimeLst() {
        return timeLst;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public boolean hasOverlap(Lecture o) {
        for (String key : o.getTimeLst().keySet()) {
            if (timeLst.containsKey(key) && (overLap(timeLst.get(key), o.getTimeLst().get(key)))) {
                return true;
            }
        }
        return false;
    }

    private boolean overLap(int[] lst1, int[] lst2){
        return (lst1[1] > lst2[0] || lst1[1] < lst2[1]) ||
                (lst1[0] > lst2[0] || lst1[0] < lst2[1]) ||
                lst1 == lst2;
    }
}
