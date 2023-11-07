package mru.application;


import mru.controller.StoreManager;

public class Main {

	public static void main(String[] args) {
		StoreManager store = new StoreManager();
		try {
			store.loadData();
			store.lauch();
			store.Save();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
