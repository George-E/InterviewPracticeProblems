package ch1_ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1_4 {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println(isPalindrmePermuation(in.nextLine()));
		}
	}

	
	/*looping through a map
	 
		If you're only interested in the keys, you can iterate through the keySet() of the map:
		
		Map<String, Object> map = ...;
		
		for (String key : map.keySet()) {
		    // ...
		}
		If you only need the values, use values():
		
		for (Object value : map.values()) {
		    // ...
		}
		Finally, if you want both the key and value, use entrySet():
		
		for (Map.Entry<String, Object> entry : map.entrySet()) {
		    String key = entry.getKey();
		    Object value = entry.getValue();
		    // ...
		}

	 */
	
	public static boolean isPalindrmePermuation(String s) {
		Map<Character, Integer> chars =  new HashMap<>();
		s = s.replace(" ", "");
		for (int c=0; c<s.length();c++) {
			Integer count = chars.get(s.charAt(c));
			chars.put(s.charAt(c), ((count==null)? 1 : count + 1) );
		}
		boolean oddFound = false;
		for (Integer value : chars.values()) {
		    if (value%2!=0) {
		    	if (oddFound) {
		    		return false;
		    	}
		    	oddFound = true;
		    }
		}
		
		return true;
	}
}
