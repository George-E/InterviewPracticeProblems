package ch1_ArraysAndStrings;

import java.util.Arrays;
import java.util.Scanner;

public class P1_8 {

	//O(N) space by creating first col and row for markers of what to zero
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			int N = Integer.parseInt(in.nextLine());
			int grid[][] = new int[N+1][N+1];
			for (int i=0; i<N;i++) {
				String line = in.nextLine();
				for (int c=0; c<N;c++) {
					grid[i+1][c+1] = line.charAt(c)-'0';
				}
			}
			zeroMatrix(grid, N);
			for (int i=0; i<N;i++) {
				for (int c=0; c<N;c++) {
					System.out.print(grid[i+1][c+1]);
				}
				System.out.println();
			}
		}
	}

	private static void zeroMatrix(int[][] grid, int N) {
		for (int c=0; c<N;c++) {
			for (int i=0; i<N;i++) {
				if (grid[i+1][c+1]==0) {
					grid[i+1][0] = 1;
					grid[0][c+1] = 1;
				}
			}
		}
		for (int i=0; i<N;i++) {
			if (grid[i+1][0]==1) {
				zeroRow(grid, N, i);
			}
		}
		for (int i=0; i<N;i++) {
			if (grid[0][i+1]==1) {
				zeroCol(grid, N, i);
			}
		}
	}
	
	private static void zeroRow(int[][] grid, int N, int row) {
		for (int i=0; i<N; i++) {
			grid[row+1][i+1] = 0;
		}
	}
		
	private static void zeroCol(int[][] grid, int N, int col) {
		for (int i=0; i<N; i++) {
			grid[i+1][col+1] = 0;
		}
	}
	
	/*What I missed
	 * Was supposed to by a M by N matrix, not N by N. Pay attention
	 * Could reduce space usage by using a bit vector but it will still be 
	 * 
	 * Theyre final O(1) space solution is similar to mine but gets rid of the fake first row/col
	 * and uses the real first row/col by initially checking if that row and col should be zeroed 
	 * before altering its values
	 */


}
