/*
 * author		: [Fan Wenjing]
 * matric no.	: [A0177912X]
 */

import java.util.*;

public class Palindrome {

	public static boolean isPalindrome(String word) {
		int n = word.length();
		for(int i=0;i<n/2;i++){
			if (word.charAt(i)!=word.charAt(n-i-1)) return false;
		}
		return true;

	}

	public static void main(String[] args) {
		Scanner st = new Scanner(System.in);
		String a = st.nextLine();
		String b = st.nextLine();
		String c = a.concat(b);
		if (isPalindrome(c)) System.out.println("YES");
		else System.out.println("NO");}
}
