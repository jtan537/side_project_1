package com.example.jimmy.sideproject1;

/**
 * The DailyClass class contains the basic function of this program.
 */
public class DailyClass {
    /**
     * Starting time of the class as an integer.
     */
    private int start;

    /**
     * End time of the class as an integer.
     */
    private int end;

    /**
     * The course code for this class as a string.
     */
    private String courseCode;

    /**
     * The section code for this class as a string.
     */
    private String sectionCode;

    /**
     * The date of this class as a string.
     */
    private String date;

    /**
     * Initialize all the parameters.
     *
     * @param date    the date of the class
     * @param course  the course code
     * @param section the section code
     * @param start   the starting time of the class
     * @param end     the end time of the class
     */
    public DailyClass(String date, String course, String section, int start, int end) {
        this.start = start;
        this.end = end;
        this.courseCode = course;
        this.sectionCode = section;
        this.date = date;
    }

    /**
     * Return the starting time
     *
     * @return the starting time as an integer.
     */
    public int getStart() {
        return start;
    }

    /**
     * Return the end time
     *
     * @return the end time as an integer.
     */
    public int getEnd() {
        return end;
    }

    /**
     * Return the course code
     *
     * @return the course code as a string.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Return the section code.
     *
     * @return the section code as a string,
     */
    public String getSectionCode() {
        return sectionCode;
    }

    /**
     * Return the date of the class
     *
     * @return the date as a string.
     */
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "(" + start +
                ", " + end + ")" + courseCode + '\'' + sectionCode + '\'' + date + '\'' +
                '}';
    }
}
