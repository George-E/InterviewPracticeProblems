package ch1_ArraysAndStrings;

import java.util.Scanner;

public class P1_3 {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println(URLify(in.nextLine(), Integer.parseInt(in.nextLine())));
		}
	}

	public static String URLify(String s, int length) {
		char sc[] = new char[s.length()];
		int stringPos = 0, charPos = 0;
		while (charPos < sc.length) {
			if(s.charAt(stringPos) == ' ') {
				sc[charPos] = '%';
				sc[charPos+1] = '2';
				sc[charPos+2] = '0';
				charPos += 3;
			} else {
				sc[charPos] = s.charAt(stringPos);
				charPos ++;
			}
			stringPos++;
		}
		return new String(sc);
	}
}
