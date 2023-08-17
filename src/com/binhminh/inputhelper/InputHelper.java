package com.binhminh.inputhelper;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class InputHelper {
	static Scanner sc = new Scanner(System.in);
	static Calendar cal = Calendar.getInstance();

	public static int inputInteger(String mes, String err) {
		int value = 0;
		while (true) {
			try {
				System.out.println(mes);
				value = sc.nextInt();
				return value;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(err);
				sc.nextLine();
			}
		}
	}

	public static char inputChar(String mess, char a, char b) {
		while (true) {
			System.out.println(mess);
			char c = sc.next().charAt(0);
			if (c == a || c == b) {
				return c;
			} else {
				return inputChar(mess, a, b);
			}
		}

	}

	public static int inputLuaChon(String mes, String err, int min, int max) {
		int value = 0;
		while (true) {
			try {
				System.out.println(mes);
				value = sc.nextInt();
				if (value < min || value > max) {
					System.out.println(err + value);
					return inputLuaChon(mes, err, min, max);
				}
				return value;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(err+value);
				sc.nextLine();
			}
		}
	}

	public static String inputString(String mes, String err, int min, int max) {
		String str = "";
		System.out.print(mes);
		sc.nextLine();
		str = sc.nextLine();
		while (str.length() < min || str.length() > max) {
			System.out.println(err);
			return inputString1(mes, err, min, max);
		}
		return str;
	} 
	
	public static String inputString1(String mes, String err, int min, int max) {
		String str = "";
		System.out.println(mes+" ");
		str = sc.nextLine();
		while (str.length() < min || str.length() > max) {
			System.out.println(err);
			return inputString1(mes, err, min, max);
		}
		return str;
	}

	public static double inputDouble(String mes, String err, int min, int max) {
		System.out.println(mes);
		double a = sc.nextDouble();
		if (a < min || a > max) {
			System.out.println(err);
			return inputDouble(mes, err, min, max);
		}
		if (a / 0.25 != (int) (a * 4)) {
			return inputDouble(mes, err, min, max);
		}
		return a;
	}

	public static float inputFloat(String mes, String err) {
		while (true) {
			System.out.println(mes);
			try {
				float a = sc.nextFloat();
				return a;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(err);
				sc.nextLine();
			}

		}
	}

	public static LocalDate inputNgaySinh() {
		int y = NhapNamSinh();
		int m = NhapThangSinh();
		int d = NhapNgaySinh(y, m);
		LocalDate date = LocalDate.of(y, m, d);
		return date;

	}

	public static int NhapNamSinh() {
		while (true) {
			try {
				System.out.println("Nhap nam:");
				int y = sc.nextInt();
				if (y < 1900 || y > cal.get(Calendar.YEAR)) {
					return NhapNamSinh();
				}
				return y;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Sai kieu du lieu. Nhap lai");
				sc.nextLine();
			}
		}
	}

	public static int NhapThangSinh() {
		while (true) {
			try {
				System.out.println("Nhap thang:");
				int m = sc.nextInt();
				if (m < 1 || m > 12) {
					return NhapThangSinh();
				}
				return m;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Sai kieu du lieu. Nhap lai");
			}
		}
	}

	public static int NhapNgaySinh(int y, int m) {
		while (true) {
			try {
				System.out.println("Nhap ngay:");
				int d = sc.nextInt();
				if (d < 0) {
					return NhapNgaySinh(y, m);
				}
				switch (m) {
				case 2:
					if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
						if (d > 29) {
							return NhapNgaySinh(y, m);
						}
					} else if (d > 28) {
						return NhapNgaySinh(y, m);
					}
					break;
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if (d > 31)
						return NhapNgaySinh(y, m);
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if (d > 30)
						return NhapNgaySinh(y, m);
					break;
				default:
					break;
				}
				return d;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Sai kieu du lieu. Nhap lai");
				sc.nextLine();
			}
		}
	}
}
