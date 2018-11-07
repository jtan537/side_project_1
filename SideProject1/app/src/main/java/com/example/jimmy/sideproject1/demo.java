package com.example.jimmy.sideproject1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class demo {
    public static void main(String[] args) throws Exception {
        String url = "http://coursefinder.utoronto.ca/course-search/search/courseInquiry?methodToCall=start&viewId=CourseDetails-InquiryView&courseId=CSC148H1S20191";
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
        System.out.println(text);
    }
}
