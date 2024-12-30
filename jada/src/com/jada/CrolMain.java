package com.jada;

import java.util.ArrayList;
import java.util.HashMap;

import com.jada.site.BobeaCrol;
import com.jada.site.ClienCrol;
import com.jada.site.EtoCrol;
import com.jada.site.OuCrol;
import com.jada.site.RuriCrol;
import com.jada.site.SLRCrol;

public class CrolMain {
	
	public static void main(String[] args) {
		try {
			BobeaCrol bc = new BobeaCrol();
			SLRCrol sc = new SLRCrol();
			RuriCrol rc = new RuriCrol();
			EtoCrol ec = new EtoCrol();
			OuCrol oc = new OuCrol();
			ClienCrol cl = new ClienCrol();
			
//			printContents(bc.getBoardList(), "보배드림");
//			printContents(sc.getBoardList(), "에쎄랄");
//			printContents(rc.getBoardList(), "루리웹");
//			printContents(ec.getBoardList(), "이토");
//			printContents(oc.getBoardList(), "오유");
			printContents(cl.getBoardList(), "클리앙");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printContents(HashMap contents, String comm) {
		ArrayList<String> titles = (ArrayList<String>)contents.get("titles");
		ArrayList<String> lists = (ArrayList<String>)contents.get("lists");
		System.out.println("======================= "+ comm +" ===================================");
		for(int i=0 ; i < titles.size() ; i++) {
			System.out.println(titles.get(i));
			System.out.println(lists.get(i));
		}
		System.out.println("======================= "+ comm +" ===================================");
			
	}

}
