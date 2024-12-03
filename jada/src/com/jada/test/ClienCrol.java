package com.jada.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ClienCrol {
	public static void main(String[] args) {
		try {
            // 1. URL로부터 Document 객체 가져오기
            String url = "https://www.clien.net/service/board/park";
            Document document = Jsoup.connect(url).get();

            // 2. 웹 페이지 제목 출력
//            System.out.println("Title: " + document.title());

            // 3. 특정 태그 내용 가져오기
            Elements links = document.select(".list_subject"); // <a> 태그 중 href 속성이 있는 것
            for (Element link : links) {
//                System.out.println("Link: " +"https://www.slrclub.com" +link.attr("href"));
                System.out.println("Link: " +link.attr("href"));
                System.out.println("Text: " + link.select(".subject_fixed").attr("title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
