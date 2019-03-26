import java.util.*;

public class HelloWorld {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(sc.nextLine().equals("Hello World")) {
			System.out.println("Correct");
		} else {
			System.out.println("Incorrect");
		}
	}
}
