package com.jada.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OuCrol {
	public static void main(String[] args) {
		try {
            // 1. URL로부터 Document 객체 가져오기
            String url = "https://web.humoruniv.com/board/humor/list.html?table=pds";
            Document document = Jsoup.connect(url).get();

            // 2. 웹 페이지 제목 출력
//            System.out.println("Title: " + document.title());

            // 3. 특정 태그 내용 가져오기
            Elements links = document.select(".li_sbj a"); // <a> 태그 중 href 속성이 있는 것
            for (Element link : links) {
//                System.out.println("Link: " +"https://www.slrclub.com" +link.attr("href"));
                System.out.println("Link: " +link.attr("href"));
                System.out.println(link.select("span[id^=title_chk_pds]").text()); // 제목 추출
//                System.out.println("Text: " + link.text());
                
                //link url
                //https://web.humoruniv.com/board/humor/read.html?table=pds&number=1339152
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}