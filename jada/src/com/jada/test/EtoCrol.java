package com.jada.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EtoCrol {
	public static void main(String[] args) {
		try {
            // 1. URL로부터 Document 객체 가져오기
			// 이토랜드 자유게시판
            String url = "https://etoland.co.kr/bbs/board.php?bo_table=freebbs";
            Document document = Jsoup.connect(url).get();

            // 2. 웹 페이지 제목 출력
//            System.out.println("Title: " + document.title());

            // 3. 특정 태그 내용 가져오기
            Elements links = document.select(".mw_basic_list_subject a[href]:not(.mw_basic_list_category)");
            for (Element link : links) {
            	if(contentsFilter(link.attr("href"))) {
            		System.out.println("Link : " + link.attr("href"));
            		System.out.println("Text : " + link.select("span").text());
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static boolean contentsFilter(String content) {
		
		if(content.indexOf("cocoment_main") > 0) return false;
		
		return true;
	}
}
