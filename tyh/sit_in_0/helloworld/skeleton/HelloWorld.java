/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class HelloWorld {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		if(sc.nextLine().equals("Hello World")) {
			System.out.println("Correct");
		} else {
			System.out.println("Incorrect");
		}
	}

	public static void main(String[] args) {
		HelloWorld newHelloWorld = new HelloWorld();
		newHelloWorld.run();
	}
}
