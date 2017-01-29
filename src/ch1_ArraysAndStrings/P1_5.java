package ch1_ArraysAndStrings;

import java.util.Scanner;

public class P1_5 {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println(isOneAway(in.nextLine(), in.nextLine()));
		}
	}

	private static boolean isOneAway(String s1, String s2) {
		int cmp = s1.length()-s2.length();
		boolean rpl = false;
		if (cmp == 0) {
			if (s1.equals(s2)) {
				return true;
			}
			rpl = true;
		}else if (cmp == -1) {
			String temp = s2;
			s2 = s1;
			s1 = temp;
		} else if (cmp != 1) {
			return false;
		}
		
		boolean opDone = false;
		for (int c=0; c<s2.length();c++) {
			if (s1.charAt(c + ((opDone && !rpl)?1:0)) != s2.charAt(c)) {
				if (opDone) {
					return false;
				}
				opDone = true;
			}
		}
		return true;
	}

}
