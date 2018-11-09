package com.example.jimmy.sideproject1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo {
    public static void main(String[] args) throws Exception {
        /**
         * The test to getCourseInfo
         */
//        String url = "http://coursefinder.utoronto.ca/course-search/search/courseInquiry?methodToCall=start&viewId=CourseDetails-InquiryView&courseId=CSC148H1S20191";
//        Document document = Jsoup.connect(url).get();
//        Elements colspan = document.getElementsByAttributeValue("colspan", "1");
//        Elements uif = document.getElementsByAttributeValue("class", "uif-field");
//        Elements total = new Elements();
//        List<String> text = new ArrayList<>();
//        for (Element e : colspan) {
//            for (Element j : uif) {
//                if (e.hasSameValue(j)) {
//                    total.add(e);
//                    text.add(e.text());
//                }
//            }
//        }
//        System.out.println(text);

        /**
         * The test for breakUpDateTime. - works nov 7, 2018
         */
        //System.out.println(infoSlicer.breakUpDateTime("MONDAY 10:00-12:00 MONDAY 10:00-12:00"));

        /**
         * The test to groupBrokenString - works nov 7, 2018
         */
        //System.out.println(infoSlicer.groupBrokenString(infoSlicer.breakUpDateTime("MONDAY 10:00-12:00 MONDAY 10:00-12:00"), 3));
        //[[MONDAY, 10, 12], [MONDAY, 10, 12]]

        /**
         * Test the mappedDateTime
         */
//        Map h = (HashMap)(infoSlicer.mapDateTime(textScraper.getCourseInfo("ACT230H1F")).get(0).get(1));
//        int[] stuff = (int[])h.get("MONDAY");
//        System.out.println(stuff[0]);
//        System.out.println(stuff[1]);
//        10
//        12

        /**
         * Test the instantiateLectures.
         */
        //System.out.println(infoSlicer.instantiateLectures(textScraper.getCourseInfo("ACT230H1F")));

        /**
         * Test the DailyClass
         */
//        System.out.println(infoSlicer.instantiateDailyClasses("CSC148H1F"));

        /**
         * Test the overlap, screw with start and end values, and all edge cases - works
         */
//        DailyClass d1 = new DailyClass("MONDAY", "CSC108H1F", "LEC101", 10, 11);
//        DailyClass d2 = new DailyClass("MONDAY", "CSC109H1F", "LEC102", 11, 14);
//        System.out.println(Lecture.overLap(d1, d2));

        /**
         * Test hasOverlap on CSC207 and CSC404 lectures 5101,5101 respectively.
         */
//        List<DailyClass> d = new ArrayList<>();
//        DailyClass d1 = new DailyClass("WEDNESDAY", "CSC207H1F", "LEC5101", 17, 18);
//        DailyClass d2 = new DailyClass("WEDNESDAY", "CSC207H1F", "LEC5101", 18, 19);
//        d.add(d1);
//        d.add(d2);
//        Lecture csc207 = new Lecture("CSC207H1F", "LEC5101", d);
//
//        List<DailyClass> g = new ArrayList<>();
//        DailyClass d3 = new DailyClass("WEDNESDAY", "CSC404H1F", "LEC5101", 20, 21);
//        DailyClass d4 = new DailyClass("WEDNESDAY", "CSC404H1F", "LEC5101", 18, 20);
//        g.add(d3);
//        g.add(d4);
//        Lecture CSC404 = new Lecture("CSC404H1F", "LEC5101", g);
//
//        System.out.println(csc207.hasOverlap(CSC404));

        /**
         * Test instantiateDailyClasses
         */
        //System.out.println(textScraper.getCourseInfo("CSC104H1F"));
        //System.out.println(infoSlicer.instantiateDailyClasses("CSC104H1F"));

        /**
         * Test timetable creation.
         */
//        List<DailyClass> forDaily = infoSlicer.instantiateDailyClasses("FOR200H1F");
//        Lecture tempLec = new Lecture("FOR200H1F", "LEC 5101", forDaily);
//        TimeTable t = new TimeTable(tempLec);
//        System.out.println(t);
        /**
         * Test main CourseManager
         */
        List<String> course = new ArrayList<>();
        course.add("FOR200H1F");
        course.add("STA247H1F");
        course.add("NEW101H1F");
        course.add("CSC104H1F");
        course.add("CSC404H1F");
        CourseManager m1 = new CourseManager(course);
        List<TimeTable> t = new ArrayList<>();

        System.out.println(m1.generate_timetable().size());
    }
}
