package com.jada.site;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jada.constants.CrolUrls;
import com.jada.util.Utils;

public class InvenCrol {
	
	public HashMap<String, ArrayList<String>> getBoardList() throws Exception {
		
		Document doc = Utils.getDoc(CrolUrls.INVEN);
		
		ArrayList<String> titleList = new ArrayList<>();
		ArrayList<String> linkList = new ArrayList<>();
		HashMap<String, ArrayList<String>> dataMap = new HashMap<>();
		
		 // 각 행 (<tr>) 선택
        Elements contents = doc.select("td.tit");
		
        for (Element data : contents) {
        	
        	Element titleElement = data.selectFirst("a.subject-link");
        	
        	if(titleElement != null) {
        		
        		String category = data.selectFirst("span.category").text();
        		String title = titleElement.text().trim().substring(category.length()+1);
        		
        		if(contentsFilter(title)) {
        			titleList.add(title);
        			linkList.add(titleElement.attr("href"));
        		}
        		
        	}
        }
        
        dataMap.put("titles", titleList);
        dataMap.put("lists", linkList);
        
        return dataMap;
		
	}
	
	public boolean contentsFilter(String content) {
		
		if(content.indexOf("개편된 오픈 이슈 갤러리 규정 안내") >= 0) return false;
		if(content.indexOf("카테고리 개편 및 제외 기능 안내") >= 0) return false;
		if(content.indexOf("매주 3000 이니! 오이갤 특별 이벤트를 진행합니다") >= 0) return false;
		if(content.indexOf("인벤 커뮤니티 이용 안내") >= 0) return false;
		
		return true;
	}
}
