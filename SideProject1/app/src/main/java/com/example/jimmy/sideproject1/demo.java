package com.example.jimmy.sideproject1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.reflect.Array;
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
    }
}
