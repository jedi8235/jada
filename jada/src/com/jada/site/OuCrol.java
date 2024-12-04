package com.jada.site;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jada.constants.CrolUrls;
import com.jada.util.Utils;

public class OuCrol {
	
	public HashMap<String, ArrayList<String>> getBoardList() throws Exception {
		
		Document doc = Utils.getDoc(CrolUrls.TODAYHUMOR);
		
		ArrayList<String> titleList = new ArrayList<>();
		ArrayList<String> linkList = new ArrayList<>();
		HashMap<String, ArrayList<String>> dataMap = new HashMap<>();
		
		Elements contents = doc.select(".li_sbj a"); // <a> 태그 중 href 속성이 있는 것
        for (Element data : contents) {
        	titleList.add(data.select("span[id^=title_chk_pds]").text());
        	linkList.add(data.attr("href"));
        }
        
        dataMap.put("titles", titleList);
        dataMap.put("lists", linkList);
        
        return dataMap;
		
	}
	
	public boolean contentsFilter(String content) {
		
		if(content.indexOf("[공지]") >= 0) return false;
		
		return true;
	}
	
//	public static void main(String[] args) {
//		try {
//            // 1. URL로부터 Document 객체 가져오기
//            String url = "https://web.humoruniv.com/board/humor/list.html?table=pds";
//            Document document = Jsoup.connect(url).get();
//
//            // 2. 웹 페이지 제목 출력
////            System.out.println("Title: " + document.title());
//
//            // 3. 특정 태그 내용 가져오기
//            Elements links = document.select(".li_sbj a"); // <a> 태그 중 href 속성이 있는 것
//            for (Element link : links) {
////                System.out.println("Link: " +"https://www.slrclub.com" +link.attr("href"));
//                System.out.println("Link: " +link.attr("href"));
//                System.out.println(link.select("span[id^=title_chk_pds]").text()); // 제목 추출
////                System.out.println("Text: " + link.text());
//                
//                //link url
//                //https://web.humoruniv.com/board/humor/read.html?table=pds&number=1339152
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	}
}
