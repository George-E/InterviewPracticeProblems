package ch1_ArraysAndStrings;

import java.util.Scanner;

public class P1_9 {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println(stringRotation(in.nextLine(), in.nextLine()));
		}
	}

	private static boolean stringRotation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		return isSubstring(s1 + s1, s2);
	}
	
	private static boolean isSubstring(String ss1, String ss2) {
		return ss1.indexOf(ss2) > -1 | ss2.indexOf(ss1) > -1;
	}


}
