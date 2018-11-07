package com.example.jimmy.sideproject1;

        import java.io.IOException;
        import java.util.List;
        import java.util.ArrayList;
        import org.jsoup.Jsoup;
        import org.jsoup.nodes.Document;
        import org.jsoup.nodes.Element;
        import org.jsoup.select.Elements;

public final class textScraper {

    private static String generateCurYearSuffix(String courseCode) {
        // If it's a winter course the end year suffix of URL changes.
        if (courseCode.charAt(courseCode.length() - 1) == 'S') {
            return "20191";
        } else {
            return "20189";
        }
    }

    public List getCourseInfo(String courseCode) throws IOException {
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
}
