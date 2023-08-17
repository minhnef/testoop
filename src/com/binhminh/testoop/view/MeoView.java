package com.binhminh.testoop.view;
import com.binhminh.controller.MeoController;

public class MeoView {
	private  MeoController meoCTL;

	public MeoView() {
		// TODO Auto-generated constructor stub
		meoCTL = new MeoController();
	}
	
	public static void menu() {
		System.out.println("1. Them meo");
		System.out.println("2. Xoa meo theo ID");
		System.out.println("3. Hien thi toan bo meo");
		System.out.println("4. Hien thi theo ID meo");
		System.out.println("5. Thay doi tieng keu theo ID");
		System.out.println("6. Thoat");
	}
	public void thucHienYC() {
		while(true) {
			menu();
			meoCTL.thucThi();
		}
	}
}
