package com.jada.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Utils {
	
	public static Document getDoc(String url) throws Exception{
		return Jsoup.connect(url).get();
	}

}
