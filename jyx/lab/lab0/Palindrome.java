/*
 * author		: Jiang Yuxin
 * matric no.	: A0177868A
 */

import java.util.*;

public class Palindrome {
	/* use this method to check whether the string is palindrome word or not
	 * 		PRE-Condition  : get a string whose length <=200
	 * 		POST-Condition : return true if the string is palindrome otherwise return false

	 */
	public static boolean isPalindrome(String word) {
        int length = word.length();
        for(int i = 0; i < length / 2; i++) {
            if(word.charAt(i) != word.charAt(length - i - 1)) return false;
        }
        return true;
	}
	
	public static void main(String[] args) {
		// declare the necessary variables
		// declare a Scanner object to read input
        Scanner in = new Scanner(System.in);
        // read input and process them accordingly
		// simulate the problem
		// output the result
        String str1 = in.next();
        String str2 = in.next();
        if(isPalindrome(str1 + str2)) System.out.println("YES");
        else System.out.println("NO");
	}
}
