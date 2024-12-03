package com.jada.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class InvenCrol {
	public static void main(String[] args) {
		try {
            // 1. URL로부터 Document 객체 가져오기
			// 이토랜드 자유게시판
            String url = "https://www.inven.co.kr/board/webzine/2097";
            Document document = Jsoup.connect(url).get();

            // 게시글 제목과 기타 정보가 들어 있는 "td.tit" 태그 선택
            Elements posts = document.select("td.tit");

            // 게시글 정보 순회
            for (Element post : posts) {
                // 제목과 링크
                Element titleLink = post.selectFirst("a.subject-link");
                if (titleLink != null) {
                    String category = post.selectFirst("span.category").text(); // 카테고리
                    String title = titleLink.text().trim(); // 제목
                    String link = titleLink.attr("href"); // 링크

                    // 작성자 정보
                    Element userElement = post.parent().selectFirst("td.user span.layerNickName");
                    String author = userElement != null ? userElement.text() : "Unknown";

                    // 작성 시간
                    Element dateElement = post.parent().selectFirst("td.date");
                    String date = dateElement != null ? dateElement.text() : "Unknown";

                    // 조회수
                    Element viewElement = post.parent().selectFirst("td.view");
                    String views = viewElement != null ? viewElement.text() : "0";

                    // 추천 수
                    Element recoElement = post.parent().selectFirst("td.reco");
                    String reco = recoElement != null ? recoElement.text() : "0";

                    // 출력
                    System.out.println("Category: " + category);
                    System.out.println("Title: " + title);
                    System.out.println("Link: " + link);
                    System.out.println("Author: " + author);
                    System.out.println("Date: " + date);
                    System.out.println("Views: " + views);
                    System.out.println("Recommendations: " + reco);
                    System.out.println();
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
