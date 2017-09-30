package ch2_LinkedLists;

import java.util.HashMap;
import java.util.Scanner;

public class P2_2 {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			Node head = Node.getLinkedListFromInput(in);
			System.out.println(head);
			int k = Integer.parseInt(in.nextLine());
			System.out.println(returnKthToLast(head, k).answer);
		}
	}

	static class Rtn { 
		int iFromLast;
		String answer;
		
		public Rtn(int iFromLast, String answer) {
			this.iFromLast = iFromLast;
			this.answer = answer;
		}
	}
	
	public static Rtn returnKthToLast(Node head, int target) {
		if (head == null) {
			return new Rtn(0,null);
		} 
		Rtn rtn = returnKthToLast(head.next, target);
		rtn.iFromLast += 1;
		if (rtn.iFromLast == target) {
			rtn.answer = head.data;
		}
		return rtn;
	}

}
