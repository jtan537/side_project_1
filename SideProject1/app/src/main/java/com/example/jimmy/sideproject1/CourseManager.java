package com.example.jimmy.sideproject1;

import java.io.IOException;
import java.util.ArrayList;

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
    public CourseManager(ArrayList<String> courseCodeLst) throws IOException {
        for (String s : courseCodeLst) {
            this.courseLst.add(infoSlicer.instantiateCourse(s));
        }
    }

    /**
     * Generate the timetable by following steps:
     * 1. check if first two section of the first two courses have any overlap, if not
     * merge these two into temp
     * 2. make a copy of temp and check if temp and first section of third course have any
     * overlap, if not merge these into temp1
     * 3. make a copy of temp1 and repeat the steps above till the first section of last course
     * and if all five courses have no overlap make it a TimeTable object and add to the
     * list to return
     *
     * @return the list contains all valid TimeTable objects
     */
    public ArrayList<TimeTable> generate_timetable() {
        ArrayList<Lecture> timetable = new ArrayList<>();
        for (Lecture k : courseLst.get(0).getSectionLst()) {
            for (Lecture l : courseLst.get(1).getSectionLst()) {
                if (!(k.hasOverlap(l))) {
                    Lecture temp = merge(k, l);
                    for (Lecture x : courseLst.get(2).getSectionLst()) {
                        if (!(temp.hasOverlap(x))) {
                            Lecture temp1 = new Lecture(temp.getCourseCode(), temp.getSectionCode(), temp.getTimeLst());
                            temp1 = merge(temp1, x);
                            for (Lecture y : courseLst.get(3).getSectionLst()) {
                                if (!(temp1.hasOverlap(y))) {
                                    Lecture temp2 = new Lecture(temp1.getCourseCode(), temp1.getSectionCode(), temp1.getTimeLst());
                                    temp2 = merge(temp2, y);
                                    for (Lecture z : courseLst.get(4).getSectionLst()) {
                                        if (!(temp2.hasOverlap(z))) {
                                            Lecture temp3 = new Lecture(temp2.getCourseCode(), temp2.getSectionCode(), temp2.getTimeLst());
                                            temp3 = merge(temp3, z);
                                            timetable.add(temp3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return decoder(timetable);
    }

    /**
     * A helper to change the list of final merged products into a list of valid TimeTable object
     *
     * @param timetable list of merged lecture objects.
     * @return list of TimeTable object.
     */
    private ArrayList<TimeTable> decoder(ArrayList<Lecture> timetable) {
        ArrayList<TimeTable> timeTable = new ArrayList<>();
        for (Lecture l : timetable) {
            timeTable.add(new TimeTable(l));
        }
        return timeTable;
    }

    /**
     * A helper to merge two lecture objects by concatenate all properties of these two.
     *
     * @param lec1 the first Lecture object to merge
     * @param lec2 the second Lecture object to merge
     * @return the merged Lecture object
     */
    private Lecture merge(Lecture lec1, Lecture lec2) {
        ArrayList<DailyClass> temp = new ArrayList<>();
        temp.addAll(lec1.getTimeLst());
        temp.addAll(lec2.getTimeLst());
        return new Lecture(lec1.getCourseCode() + lec2.getCourseCode(), lec1.getSectionCode() + lec2.getSectionCode(), temp);
    }
}
