package com.jada.site;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jada.constants.CrolUrls;
import com.jada.util.Utils;

public class HumorUniCrol {
	
	public HashMap<String, ArrayList<String>> getBoardList() throws Exception {
		
		Document doc = Utils.getDoc(CrolUrls.HUMOR_UNIV);
		
		ArrayList<String> titleList = new ArrayList<>();
		ArrayList<String> linkList = new ArrayList<>();
		HashMap<String, ArrayList<String>> dataMap = new HashMap<>();
		
		 // 각 행 (<tr>) 선택
        Elements contents = doc.select("tr");
		
        for (Element data : contents) {
        	
        	Element titleElement = data.select("td.li_sbj a").first();
        	
        	if(titleElement != null && contentsFilter(data.selectFirst("span[id^=title_chk_pds]").text())) {
        		titleList.add(data.selectFirst("span[id^=title_chk_pds]").text());
        		linkList.add(titleElement.attr("href"));
        	}
        }
        
        dataMap.put("titles", titleList);
        dataMap.put("lists", linkList);
        
        return dataMap;
		
	}
	
	public boolean contentsFilter(String content) {
		
		if(content.indexOf("회원님들께 당부의 말씀 올립니다") >= 0) return false;
		if(content.indexOf("뉴스기사 등 무단 게재 관련 공지입니다") >= 0) return false;
		if(content.indexOf("자유게시판은....") >= 0) return false;
		
		return true;
	}
}
