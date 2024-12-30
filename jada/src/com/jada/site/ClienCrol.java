package com.jada.site;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jada.constants.CrolUrls;
import com.jada.util.Utils;

public class ClienCrol {
	public HashMap<String, ArrayList<String>> getBoardList() throws Exception {
        Document doc = Utils.getDoc(CrolUrls.CLIEN);
        
        ArrayList<String> titleList = new ArrayList<>();
		ArrayList<String> linkList = new ArrayList<>();
		HashMap<String, ArrayList<String>> dataMap = new HashMap<>();
		
		Elements contents = doc.select(".list_subject"); // <a> 태그 중 href 속성이 있는 것
        for (Element data : contents) {
        	if(contentsFilter(data.select(".subject_fixed").attr("title"))) {
        		titleList.add(data.select(".subject_fixed").attr("title"));
        		linkList.add(data.attr("href"));
        	}
        }
        
        dataMap.put("titles", titleList);
        dataMap.put("lists", linkList);
        
        return dataMap;
	}
	
	
	public boolean contentsFilter(String content) {
		if(content.length() == 0) return false;
		return true;
	}
	
}
