package ch1_ArraysAndStrings;

import java.util.Hashtable;
import java.util.Scanner;

public class P1_1 {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println(uniqueCharsBitVector(in.next()));
		}
	}
	
	public static boolean uniqueCharsBruteForce(String s) {
		for (int i=0; i< s.length()-1; i++) {
			for (int c=i+1; c<s.length();c++) {//this is still O(n^2)  [n-1,n-2,...3,2,1 => n(n-1)/2 => O(n^2)]
				if (s.charAt(i) == s.charAt(c)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/*creating a arraylist of found chars would still be O(n^2) because .contains is O(n) (its implemented as .indexof(o) >= 0)
	 * 
	 *could create a bool array of size 256 [extended ascii] (or 128) if we know characters must be those ASCII values, but this is
	 *highly space inefficient and requires the assumption
	 *
	 *
	 *So if we want to do the data structure approach a hash lookup table is prob our best bet is to use a hash table
	 *Java's implementation "provides constant-time performance for the basic operations (get and put), 
	 *assuming the hash function disperses the elements properly among the buckets."
	 *Since containsKey() is just a get() that throws away the retrieved value, it's O(1)
	 *Therefore O(n)
	 * */
	
	public static boolean uniqueCharsHash(String s) {
		Hashtable chars = new Hashtable();
		for (int i=0; i<s.length();i++) {
			if (chars.containsKey(s.charAt(i))) {
				return false;
			} else {
				chars.put(s.charAt(i), true);
			}
			//shoudve done 
			/*
			 if (chars.put(s.charAt(i), true) != null) { since put returns value key was last mapped to
				return false;
			}
			 
			 also shouldve used a HashSet instead since were only using one dimension
			 */
				
					
		}
		return true;
	}
	
	
	/*What I missed:
	 * For the bool array, technically its still O(1) space if we know 128 and 256 alphabet (ask!)
	 * Also runtime is capped at 128/256 if we initially check if s.length>256, meaning not unique b/c length>alphabet size
	 * Even better than a bool array is a BIT VECTOR, which would be 8 times more space efficient because bools are 8 bits
	 * What is meant by a BIT VECTOR is just using bits of a single int using bit manipulation
	 * Actually, if chars just a-z, a single int is big enough because its 32 bit (4 bytes)
	 * would need to use a long (64 bit) if more, such as capital and lowercase
	 * */
	
	public static boolean uniqueCharsBitVector(String s) {
		int checker =0;
		for (int i=0; i<s.length();i++) {
			int val = s.charAt(i) - 'a';
			if ((checker & (1<<val)) > 0) {
				return false;
			}
			checker |= (1<<val);
		}
		return true;
	}
}
