package ch1_ArraysAndStrings;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class P1_2 {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println(isPermuationHash(in.next(), in.next()));
		}
	}
	
	/*sorting solution is O(nlogn)[slower than O(n)] time and O(1) space
	 * Actually its O(n) space by the nature I implemented it in Java
	 */
	public static boolean isPermuationSort (String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] chars1 = s1.toCharArray();
		Arrays.sort(chars1);
		char[] chars2 = s2.toCharArray();
		Arrays.sort(chars2);
		for (int c=0; c<chars1.length;c++) {
			if (chars1[c] != chars2[c] ) {
				return false;
			}
		}
		//or (new String(chars1).equals(new String(chars2));
		return true;
		
	}

	//hash table is O(n) space but O(n) time
	public static boolean isPermuationHash (String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		Hashtable chars = new Hashtable();
		for (int c=0; c<s1.length();c++) {
			/*if (chars.containsKey(s1.charAt(c))) {
				chars.put(s1.charAt(c), (int)chars.get(s1.charAt(c)) + 1 );//dont forget to cast value to int
			}else{
				chars.put(s1.charAt(c), 1);
			}
			/* OR
			*/
			
			/*int count = chars.containsKey(s1.charAt(c)) ? (int) chars.get(s1.charAt(c)) : 0;//dont forget to cast value to int
			chars.put(s1.charAt(c), count + 1);
			
			*OR EVEN FASTER
			*The following is fastest because get is only called once. Since containsKey implemented as .get90 != null,
			*the above methods are calling .get twice which is redundant
			*/
			
			Integer count = (Integer) chars.get(s1.charAt(c));//dont forget to cast value to Integer
			if (count == null) { //cant do this if casted to int instead
				chars.put(s1.charAt(c), 1);
			}
			else {
				chars.put(s1.charAt(c), count + 1);
			}
		}
		for (int c=0; c<s2.length();c++) {
			Integer count = (Integer) chars.get(s2.charAt(c));
			if (count == null || count == 0) {
				return false;
			} else {
				chars.put(s2.charAt(c), count - 1);
			}
		}
		return true;
	}
	
	/* What I missed:
	 * For the hash solution, dont have to cast to int or Integer if declared as Hashtable<Character, Integer> chars = new Hashtable<>() instead
	 * It also helps catch bugs because compiler checks type safety
	 * also read into Hashtable vs Hashmap, it think hashtable is legacy code
	 * 
	 * Should have asked if comparison is case sensitive and if whitespace matters
	 * Like in the last q, if we can assume ascii or extended ascii, can make a constant size int array instead of hash table
	 */
}
