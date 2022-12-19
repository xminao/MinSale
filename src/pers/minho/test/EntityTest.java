package pers.minho.test;

import pers.minho.entity.GoodsPage;

public class EntityTest {
	
	public static void paramTest(GoodsPage page) {
		page.setCategorize(1);
	}
	
	public static void main(String args[]) {
		GoodsPage page = new GoodsPage();
		paramTest(page);
		System.out.println(page.getCategorize());
	}

}
