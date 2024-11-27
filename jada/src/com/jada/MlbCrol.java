package com.jada;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MlbCrol {
	public static void main(String[] args) {
		try {
            // 1. URL로부터 Document 객체 가져오기
            String url = "https://mlbpark.donga.com/mp/b.php?b=bullpen";
            Document document = Jsoup.connect(url).get();

            // 게시글 목록을 포함하는 <td class='t_left'> 찾기
            Elements posts = document.select("td.t_left");

            // 각 게시글 처리
            for (Element post : posts) {
                // 카테고리와 제목 링크 추출
                Element categoryElement = post.selectFirst("a.list_word"); // 카테고리
                Element titleElement = post.selectFirst("a.txt"); // 제목 링크

                if (categoryElement != null && titleElement != null) {
                    String category = categoryElement.text(); // 카테고리
                    String title = titleElement.text(); // 게시글 제목
                    String href = titleElement.attr("href"); // 게시글 링크

                    // 출력
                    System.out.println("Category: " + category);
                    System.out.println("Title: " + title);
                    System.out.println("Link: " + href);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
