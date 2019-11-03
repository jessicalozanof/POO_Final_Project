package Util;

import java.util.Scanner;

public class Util {
	
	public static String scanString() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	public static int scanInt() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
}
