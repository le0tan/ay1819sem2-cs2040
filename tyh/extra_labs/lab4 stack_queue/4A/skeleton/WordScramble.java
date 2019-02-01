/*
 * CS1020 (AY2014/5 Sem2)
 * Sit-in Lab 04 A
 * Author      : 
 * Matric no.  : 
 * Lab group   : 
 * Description :
 *      ???
 *      ???
 */

import java.util.Scanner;

public class WordScramble {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		WordScramble ws = new WordScramble();
		ws.play(sc);
	}


	/**
	 * Reads the input and calls the appropriate method to search the word
	 * @param sc : Scanner object to be used for reading
	 */
	public void play(Scanner sc) {
		int part = Integer.parseInt(sc.nextLine());
		char[] array = sc.next().toCharArray();

		if (part == 1) {
			char[] word = sc.next().toCharArray();
			findWordInArray(array, word, part);
		} else if (part == 2) {
			int numberOfWords = sc.nextInt();
			for (int i =0;i < numberOfWords; i++) {
				char[] word = sc.next().toCharArray();
				findWordInArray(array, word, part);
			}
		}
	}

}
