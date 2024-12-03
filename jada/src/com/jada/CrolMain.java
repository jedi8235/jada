package com.jada;

import com.jada.site.BobeaCrol;

public class CrolMain {
	
	public static void main(String[] args) {
		try {
			BobeaCrol bc = new BobeaCrol();
			bc.getBoardList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
