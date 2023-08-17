package com.binhminh.model;

import java.util.List;

import com.binhminh.controller.MeoController;
import com.binhminh.inputhelper.InputHelper;

public abstract class Meo implements ITiengKeu {
	private int id;
	private String tenMeo;
	private int tuoi;
	private char gioiTinh;
	private String tiengKeu;

	public int getId() {
		return id;
	}

	public String getTenMeo() {
		return tenMeo;
	}

	public void setTenMeo(String tenMeo) {
		this.tenMeo = tenMeo;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public char getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(char gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getTiengKeu() {
		return tiengKeu;
	}

	public void setTiengKeu(String tiengKeu) {
		this.tiengKeu = tiengKeu;
	}

	public int ID(List<Meo> list) {
		return id = list.size();
	}

	public Meo() {
		// TODO Auto-generated constructor stub
		id = ID(MeoController.listMeo);
		tenMeo = InputHelper.inputString1("Nhap ten meo", "Nhap lai", 1, 100);
		tuoi = InputHelper.inputInteger("Nhap tuoi", "Nhap lai");
		gioiTinh = InputHelper.inputChar("Nhap gioi tinh(M/F)", 'M', 'F');
	}

	public void InThongTin() {
		// TODO Auto-generated method stub
		System.out.println("ID:" + id + " -ten meo: " + tenMeo + "-" + tuoi + " tuoi, " + "gioi tinh:" + gioiTinh);
		System.out.println("Tieng keu: " + tiengKeu);
	}
}