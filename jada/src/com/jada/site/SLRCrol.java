package com.jada.site;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jada.constants.CrolUrls;
import com.jada.util.Utils;

public class SLRCrol {
	
	public HashMap<String, ArrayList<String>> getBoardList() throws Exception {
		
		Document doc = Utils.getDoc(CrolUrls.SLR_CLUB);
		
		ArrayList<String> titleList = new ArrayList<>();
		ArrayList<String> linkList = new ArrayList<>();
		HashMap<String, ArrayList<String>> dataMap = new HashMap<>();
		
		Elements contents = doc.select(".sbj a"); // <a> 태그 중 href 속성이 있는 것
        for (Element data : contents) {
        	if(contentsFilter(data.text())) {
        		titleList.add(data.text());
        		linkList.add(data.attr("href"));
        	}
        }
        
        dataMap.put("titles", titleList);
        dataMap.put("lists", linkList);
        
        return dataMap;
		
	}
	
	public boolean contentsFilter(String content) {
		
		if(content.indexOf("SLRCLUB 게시판 관리규정") >= 0) return false;
		
		return true;
	}
}
