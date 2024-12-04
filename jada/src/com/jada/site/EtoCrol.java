package com.jada.site;

import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jada.constants.CrolUrls;
import com.jada.util.Utils;

public class EtoCrol {
	
	public HashMap<String, ArrayList<String>> getBoardList() throws Exception {
		
		Document doc = Utils.getDoc(CrolUrls.ETOLAND);
		
		ArrayList<String> titleList = new ArrayList<>();
		ArrayList<String> linkList = new ArrayList<>();
		HashMap<String, ArrayList<String>> dataMap = new HashMap<>();
		
		Elements contents = doc.select(".mw_basic_list_subject a[href]:not(.mw_basic_list_category)");
        for (Element data : contents) {
        	if(contentsFilter(data.attr("href"))) {
        		if(contentsFilter(data.select("span").text())) {
        			titleList.add(data.select("span").text());
        			linkList.add(data.attr("href"));
        		}
        	}
        }
        
        dataMap.put("titles", titleList);
        dataMap.put("lists", linkList);
        
        return dataMap;
		
	}
	
	public boolean contentsFilter(String content) {
		
		if(content.indexOf("cocoment_main") >= 0) return false;
		
		if(content.indexOf("정치관련 게시물은 시사게시판 이용바랍니다") >= 0) return false;
		if(content.indexOf("[공지]") >= 0) return false;
		if(content.indexOf("[혜택]") >= 0) return false;
		if(content.indexOf("[필독]") >= 0) return false;
		if(content.indexOf("[이토인스토리]") >= 0) return false;
		if(content.indexOf("게시판 내 카테고리 설정에 유의해주시기 바랍니다.") >= 0) return false;
		if(content.indexOf("의견이 다른 회원을 비하하는 게시글 작성은 제재됩니다.") >= 0) return false;
		
		return true;
	}
}
