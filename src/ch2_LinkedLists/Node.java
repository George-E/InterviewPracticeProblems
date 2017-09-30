package ch2_LinkedLists;

import java.util.Scanner;

public class Node {
	Node next;
	String data;
	
	public Node(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		Node c = this;
		StringBuilder str = new StringBuilder();
		while (c != null) {
			str.append(c.data);
			str.append(c.data + "\t");
			c = c.next;
		}
		return str.toString();
	}
	
	public static Node getLinkedListFromInput(Scanner in) {
		int N = Integer.parseInt(in.nextLine());
		Node head = null;
		if (N > 0) {
			head = new Node(in.nextLine());
			Node r = head;
			for (int i = 1; i< N; i++) {
				r.next = new Node(in.nextLine());
				r = r.next;
			}
		}
		return head;
	}
}
