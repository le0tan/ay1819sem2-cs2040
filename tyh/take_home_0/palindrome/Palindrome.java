/*
 * author		: []
 * matric no.	: []
 */

import java.util.*;

public class Palindrome {
	/* use this method to check whether the string is palindrome word or not
	 * 		PRE-Condition  :
	 * 		POST-Condition :
	 */
	public static boolean isPalindrome(String word) {
		boolean ok = true;
		int l = 0, r = word.length()-1;
		while(ok && l < r) {
			if(word.charAt(l) != word.charAt(r)) {
				ok = false;
				break;
			} else {
				l++; r--;
			}
		}
		if(ok) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		// declare the necessary variables

		// declare a Scanner object to read input
		Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
		String a = sc.nextLine(), b = sc.nextLine();
		if(isPalindrome(a.concat(b))) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

		// simulate the problem


		// output the result

	}
}
