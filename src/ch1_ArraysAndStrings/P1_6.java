package ch1_ArraysAndStrings;

import java.util.Scanner;

public class P1_6 {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println(compressString(in.nextLine()));
		}
	}

	private static String compressString(String s) {
		char cmp[] = new char[s.length()-1];
		int c =0, sc = 0;
		while (c<cmp.length-1) {
			char chr = s.charAt(sc);
			int count = 0;
			do  {
				sc++;
				count++;
			} while (sc<s.length() && chr == s.charAt(sc));
			cmp[c] = chr;
			cmp[c+1] = (char)('0'+count);
			if (sc == s.length()) {
				return new String(cmp);
			}
			c+=2;
		}
		return s;
	}

}
