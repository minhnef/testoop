package com.binhminh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.binhminh.inputhelper.InputHelper;
import com.binhminh.model.Meo;
import com.binhminh.testoop.view.MeoView;

public class MeoController {
	public static List<Meo> listMeo;

	public MeoController() {
		// TODO Auto-generated constructor stub
		listMeo = new ArrayList<Meo>();
	}

	public void xoaTheoID(int id) {
		for (Meo meo : listMeo) {
			if (meo.getId() == id) {
				listMeo.remove(meo);
			}
		}
	}

	public void hienThiToanBo() {
		for (Meo meo : listMeo) {
			meo.InThongTin();
		}
	}

	public void hienThiTheoID(int id) {
		for (Meo meo : listMeo) {
			if (meo.getId() == id) {
				meo.InThongTin();
			}
		}
	}

	public void thayDoiTiengKeuTheoID(int id) {
		for (Meo meo : listMeo) {
			if (meo.getId() == id) {
				meo.setTiengKeu(InputHelper.inputString("Tieng keu moi", "Nhap ngan di ty", 1, 30));
			}
		}
	}

	private int nhapID() { // Nhap ID Meo
		int dem = 0;
		int id = InputHelper.inputInteger("Nhap id", "Nhap lai");
		for (Meo meo : listMeo) {
			if (meo.getId() == id) {
				break;
			} else {
				dem++;
			}
		}
		if (dem == listMeo.size()) {
			System.out.println("ID khong ton tai");
			return nhapID();
		}
		return id;
	}

	private int taoID() { // tao ID giong meo moi
		int i = InputHelper.inputInteger("Nhap ID moi", "Nhap lai");
		if (hmapGiongMeo.containsKey(i)) {
			return taoID();
		}
		return i;
	}

	HashMap<Integer, String> hmapGiongMeo = new HashMap<>();
	HashMap<Integer, String> hmapTiengKeu = new HashMap<>();

	public void danhSachMeo() {
		hmapGiongMeo.put(1, " Meo Anh long dai");
		hmapGiongMeo.put(2, " Meo Anh long ngan");
		hmapGiongMeo.put(3, " Meo Ba Tu");
		hmapGiongMeo.put(4, " Meo Nga");
	}

	public void danhSachTiengKeu() {
		hmapTiengKeu.put(1, "meo");
		hmapTiengKeu.put(2, "meo meo");
		hmapTiengKeu.put(3, "meo meo meo");
		hmapTiengKeu.put(4, "meo meo meo meo");
	}

	public void themMeo() {
		danhSachMeo();
		danhSachTiengKeu();
		System.out.println("1. Chon tu giong da co");
		System.out.println("2. Chon giong moi");
		System.out.println("3. Quay lai");
		int chon = InputHelper.inputLuaChon("Nhap lua chon", "khong co lua chon", 1, 3);
		switch (chon) {
		case 1:
			System.out.println(hmapGiongMeo);
			int idMeo = InputHelper.inputInteger("Nhap ID", "Nhap lai");
			if (hmapGiongMeo.containsKey(idMeo)) {
				Meo conMeo = new Meo() {

					@Override
					public void tiengkeu() {
						// TODO Auto-generated method stub
						setTiengKeu(hmapTiengKeu.get(idMeo));
					}

				};
				conMeo.tiengkeu();
				if (listMeo.isEmpty()) {
					listMeo.add(conMeo);
				} else {
					for (Meo meo : listMeo) {
						if (conMeo.getId() == meo.getId()) {
							System.out.println("ID da ton tai. Nhap lai");
							themMeo();
						}
					}
					listMeo.add(conMeo);
				}
			} else {
				System.out.println("Khong co giong meo vua nhap");
				themMeo();
			}
			break;
		case 2:
			int i = taoID();
			hmapGiongMeo.put(i, InputHelper.inputString("Nhap ten giong", "Nhap ngan thoi", 1, 30));
			hmapTiengKeu.put(i, InputHelper.inputString1("Nhap tieng keu", "Nhap ngan di ty", 1, 30));
			break;
		case 3:
			MeoView.menu();
			thucThi();
		default:
			break;
		}
	}

	public void thucThi() {
		int i = InputHelper.inputLuaChon("Nhap lua chon", "Khong co lua chon ", 1, 6);
		switch (i) {
		case 1:
			themMeo();
			break;
		case 2:
			xoaTheoID(nhapID());
			break;
		case 3:
			hienThiToanBo();
			break;
		case 4:
			hienThiTheoID(nhapID());
			break;
		case 5:
			thayDoiTiengKeuTheoID(nhapID());
			break;
		case 6:
			System.exit(0);
		default:
			break;
		}
	}
}
