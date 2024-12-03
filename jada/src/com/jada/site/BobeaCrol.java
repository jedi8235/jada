package com.jada.site;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jada.util.Utils;

public class BobeaCrol {
	
	public void getBoardList() throws Exception {
		
		String url = "https://www.bobaedream.co.kr/list?code=freeb";
		Document doc = Utils.getDoc(url);
		
		ArrayList<String> titleList = new ArrayList<>();
		ArrayList<String> linkList = new ArrayList<>();
		
		Elements contents = doc.select(".bsubject"); // <a> 태그 중 href 속성이 있는 것
        for (Element data : contents) {
        	titleList.add(data.text());
        	linkList.add(data.attr("href"));
        }
		
	}
	
}
