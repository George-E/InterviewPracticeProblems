package ch2_LinkedLists;

import java.util.HashMap;
import java.util.Scanner;

public class P2_1 {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			Node head = Node.getLinkedListFromInput(in);
			System.out.println(head);
			System.out.println(removeDups(head));
		}
	}
	
	public static Node removeDups(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		HashMap<String, Boolean> map = new HashMap<>();
		map.put(head.data, true);
		Node c = head;
		while (c != null && c.next != null) {
			if (map.put(c.next.data, true) == Boolean.TRUE) { //.put return prev value. This is faster than .get and .put
				//delete node
				c.next = c.next.next;
			} else {
				c = c.next;
			}
		}
		/*for (String s: map.keySet()) {
			System.out.println(s);
		} debugging */
		return head;
	}
}

/*What I missed
 * Should have used HashSet not HashMap since only care about keys 
 */
