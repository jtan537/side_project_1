package com.example.jimmy.sideproject1;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * A textScraper that scrapes the U of T course finder site for information of a particular course.
 */
public final class textScraper {


    private static String generateCurYearSuffix(String courseCode) {
        // If it's a winter course the end year suffix of URL changes.
        if (courseCode.charAt(courseCode.length() - 1) == 'S') {
            return "20191";
        } else {
            return "20189";
        }
    }

    /**
     * Returns a list of all the course info, given a course code from the U Of T coursefinder site.
     * @param courseCode The course to get information for.
     * @return           The list of all course info.
     * @throws IOException
     */
    public static List<String> getCourseInfo(String courseCode) throws IOException {
        String currentYear = generateCurYearSuffix(courseCode);
        String url = "http://coursefinder.utoronto.ca/course-search/search/courseInquiry?methodToCall=start&viewId=CourseDetails-InquiryView&courseId=" + courseCode + currentYear;
        Document document = Jsoup.connect(url).get();
        Elements colspan = document.getElementsByAttributeValue("colspan", "1");
        Elements uif = document.getElementsByAttributeValue("class", "uif-field");
        Elements total = new Elements();
        List<String> text = new ArrayList<>();
        for (Element e : colspan) {
            for (Element j : uif) {
                if (e.hasSameValue(j)) {
                    total.add(e);
                    text.add(e.text());
                }
            }
        }
        return text;
    }

    /**
     * Return a parsed list of a list of course info.
     *
     * PRECONDITION: The courseInfo list is a list returned by the getCourseInfo method.
     * @param courseInfo
     * @return
     */
//    private List parseCourseInfo(List courseInfo){
//
//    }
    // First slice times information into a hashmap of day, [starttime, endtime], then construct
    // a lecture object with the particular lecture time, and hasmap

    // Finally create a course object with a course code, and all the lecture objects.


}
