import java.util.*;

public class StringComparison {
	
	public static void main(String[] args) {
		// declare the necessary variables
        String str1, str2;
		// declare a Scanner object to read input
         Scanner scanner = new Scanner(System.in);
		// read input and process them accordingly
        str1 = scanner.next().toLowerCase();
        str2 = scanner.next().toLowerCase();
        int comp = str1.compareTo(str2);
        if(comp < 0) System.out.println(1);
        else if(comp > 0) System.out.println(2);
        else System.out.println(0);
	}
}
