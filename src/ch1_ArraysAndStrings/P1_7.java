package ch1_ArraysAndStrings;

import java.util.Scanner;

public class P1_7 {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			String line = in.nextLine();
			int n = line.length();
			char N[][] = new char[n][n];
			N[0] = line.toCharArray();
			for (int i = 1; i < n; i++) {
				N[i] = in.nextLine().toCharArray();
			}
			rotateMatrix(N, 0);
			for (int i = 0; i < n; i++) {
				System.out.println(new String(N[i]));
			}
		}
	}

	private static void rotateMatrix(char[][] N, int depth) {
		if (depth >= N.length / 2) {
			return;
		}
		int swaps = N.length - 1 - depth*2;
		int end = N.length -1;
		for (int i = 0; i < swaps; i++) {
			char temp 						= N[depth][depth+i];
			N[depth][depth+i] 				= N[end-(depth+i)][depth];
			N[end-(depth+i)][depth] 		= N[end-depth][end-(depth+i)];
			N[end-depth][end-(depth+i)] 	= N[depth+i][end-depth];
			N[depth+i][end-depth] 			= temp;		
		}
		rotateMatrix(N, depth + 1);
	}


}
