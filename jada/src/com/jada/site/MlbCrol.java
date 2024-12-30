package com.jada.site;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jada.constants.CrolUrls;
import com.jada.util.Utils;

public class MlbCrol {
public HashMap<String, ArrayList<String>> getBoardList() throws Exception {
		
		Document doc = Utils.getDoc(CrolUrls.MLB_PARK);
		
		ArrayList<String> titleList = new ArrayList<>();
		ArrayList<String> linkList = new ArrayList<>();
		HashMap<String, ArrayList<String>> dataMap = new HashMap<>();
		
        Elements posts = doc.select("td.t_left");
		
        for (Element post : posts) {
        	
        	// 카테고리와 제목 링크 추출
            Element categoryElement = post.selectFirst("a.list_word"); // 카테고리
            Element titleElement = post.selectFirst("a.txt"); // 제목 링크
        	
            if (categoryElement != null && titleElement != null) {
            	
            	String category = categoryElement.text(); // 카테고리
                String title = titleElement.text(); // 게시글 제목
                String href = titleElement.attr("href"); // 게시글 링크
                if(contentsFilter(title)) {
                	titleList.add(title);
                	linkList.add(href);
                }
        	}
        }
        
        dataMap.put("titles", titleList);
        dataMap.put("lists", linkList);
        
        return dataMap;
		
	}
	
	public boolean contentsFilter(String content) {
		
//		if(content.indexOf("회원님들께 당부의 말씀 올립니다") >= 0) return false;
//		if(content.indexOf("뉴스기사 등 무단 게재 관련 공지입니다") >= 0) return false;
//		if(content.indexOf("자유게시판은....") >= 0) return false;
		
		return true;
	}
}
