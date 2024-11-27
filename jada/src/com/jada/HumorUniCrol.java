package com.jada;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HumorUniCrol {
	public static void main(String[] args) {
		try {
            // 1. URL로부터 Document 객체 가져오기
            String url = "https://web.humoruniv.com/board/humor/list.html?table=pds";
            Document document = Jsoup.connect(url).get();

            // 게시글 정보가 들어 있는 <tr> 태그 선택
            Elements posts = document.select("tr");

            // 게시글 정보 순회
            for (Element post : posts) {
                // 제목과 링크
                Element titleLink = post.selectFirst("td.li_sbj a");
                if (titleLink != null) {
                    String title = post.selectFirst("span[id^=title_chk_pds]").text(); // 제목
                    String link = titleLink.attr("href"); // 링크

                    // 작성자 정보
                    Element authorElement = post.selectFirst("td.g6 span.hu_nick_txt");
                    String author = authorElement != null ? authorElement.text() : "Unknown";

                    // 작성 날짜 및 시간
                    Element dateElement = post.selectFirst("td.li_date span.w_date");
                    Element timeElement = post.selectFirst("td.li_date span.w_time");
                    String date = dateElement != null ? dateElement.text() : "Unknown";
                    String time = timeElement != null ? timeElement.text() : "Unknown";

                    // 조회수
                    Element viewElement = post.selectFirst("td.li_und");
                    String views = viewElement != null ? viewElement.text().trim() : "0";

                    // 추천수
                    Element recoElement = post.selectFirst("td.li_und span.o");
                    String reco = recoElement != null ? recoElement.text() : "0";

                    // 출력
                    System.out.println("Title: " + title);
                    System.out.println("Link: " + link);
                    System.out.println("Author: " + author);
                    System.out.println("Date: " + date);
                    System.out.println("Time: " + time);
                    System.out.println("Views: " + views);
                    System.out.println("Recommendations: " + reco);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
