package com.example.jimmy.sideproject1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The manager class where manage the user input and change it into a timetable
 */
public class CourseManager {
    public List<Course> getCourseLst() {
        return courseLst;
    }

    /**
     * The list contains all course object
     */
    private List<Course> courseLst = new ArrayList<>();

    /**
     * Initialize the course list by get information for each course code and change it into a
     * course object
     *
     * @param courseCodeLst the list contains all the course object.
     */
    public CourseManager(List<String> courseCodeLst) throws IOException {
        for (String s : courseCodeLst) {
            this.courseLst.add(createCourse(infoSlicer.instantiateDailyClasses(s)));
        }
    }

    /**
     * A helper to create a Lecture object based on a section code and a list of DailyClass objects.
     *
     * @param all_class   the list contains all the DailyClass object
     * @param sectionCode the section code as a string
     * @return Lecture object with section code given.
     */
    private Lecture createLecture(List<DailyClass> all_class, String sectionCode) {
        Lecture return_lecture = new Lecture(all_class.get(0).getCourseCode(), sectionCode, new ArrayList<DailyClass>());
        for (DailyClass c : all_class) {
            if (c.getSectionCode().equals(sectionCode)) {
                return_lecture.addClass(c);
            }
        }
        return return_lecture;
    }

    /**
     * A helper to create a Course object based on the list contains all DailyClass objects this course has
     * @param all_class the list contains all classes this course has

     * @return a Course object.
     */
    private Course createCourse(List<DailyClass> all_class) {
        HashMap<String, ArrayList<DailyClass>> temp = new HashMap<>();
        for (DailyClass c : all_class) {
            if (temp.containsKey(c.getSectionCode())) {
                temp.get(c.getSectionCode()).add(c);
            } else {
                ArrayList<DailyClass> temp_list = new ArrayList<>();
                temp_list.add(c);
                temp.put(c.getSectionCode(), temp_list);
            }
        }
        Course return_course = new Course(all_class.get(0).getCourseCode(), new ArrayList<Lecture>());
        for (String key : temp.keySet()) {
            return_course.addLecture(createLecture(temp.get(key), key));
        }
        return return_course;
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
        for (Lecture l: timetable){
            System.out.println(l+"\n");
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
        for (Lecture lec : timetable) {
            timeTable.add(new TimeTable(lec));
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
        return new Lecture("temp", "temp", temp);
    }
}
