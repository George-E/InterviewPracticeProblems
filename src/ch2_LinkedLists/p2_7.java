package ch2_LinkedLists;

import java.util.Stack;
import java.util.List;
import java.util.Scanner;

public class p2_7 {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			Node head = Node.getLinkedListFromInput(in);
			System.out.println(isPalindrome(head));
		}
	}
	
	public static boolean isPalindrome(Node head) {
		Node slow = head;
		Node fast = head;
		Stack<String> stack = new Stack<>();
		boolean isOdd = false;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				stack.push(slow.data);
				slow = slow.next;
				fast = fast.next;
			} else {
				isOdd = true;
			}
		}
		
		slow = slow.next;
		if (isOdd) {
			slow = slow.next;
		}
		
		while (slow != null) {
			String val = stack.pop();
			if (val.equals(slow.data)) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

}
