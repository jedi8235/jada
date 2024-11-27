package com.jada;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CookCrol {
	public static void main(String[] args) {
		try {
            // 1. URL로부터 Document 객체 가져오기
			// 82쿡
            String url = "https://www.82cook.com/entiz/enti.php?bn=15";
            Document document = Jsoup.connect(url).get();

            // 2. 웹 페이지 제목 출력
//            System.out.println("Title: " + document.title());

            // 3. 특정 태그 내용 가져오기
            // <td class="title"><a href="read.php?bn=15&amp;num=3920358&amp;page=1">들깨는 어떻게 해야 하나요? </a> </td>
            
            // 각 행 (<tr>) 선택
            Elements rows = document.select("tr");

            // 각 행 처리
            for (Element row : rows) {
                // 글 번호
                String number = row.select("td.numbers a.photolink").text();
                // 제목 및 링크
                Element titleElement = row.select("td.title a").first();
                if(titleElement != null) {
                	String title = titleElement.text();
                	String href = titleElement.attr("href");
                	// 작성자
                	String author = row.select("td.user_function").text();
                	// 등록 시간
                	String time = row.select("td.regdate.numbers").text();
                	// 조회수
                	String views = row.select("td.numbers").last().text();
                	
                	// 출력
                	System.out.println("Number: " + number);
                	System.out.println("Title: " + title);
                	System.out.println("Link: " + href);
                	System.out.println("Author: " + author);
                	System.out.println("Time: " + time);
                	System.out.println("Views: " + views);
                	System.out.println();
                	
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
