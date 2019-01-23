import java.lang.*;     //optional
import java.util.*;

class TestScanner {

	public static void main( String[] args ) {
		Scanner input = new Scanner(System.in);
				int type = input.nextInt();
				if (type == 1)
		  			readProcess1();
				else 
					readProcess2();
		 
	}

	public static void readProcess1() {
		Scanner read1 = new Scanner(System.in);
		double sum = 0.0;
		int NumOfInput = read1.nextInt();
		for (int i = 0; i < NumOfInput; i++) 
			sum += read1.nextInt();
		System.out.println("Average is " + sum/NumOfInput);
	}

	public static void readProcess2() {
		Scanner read2 = new Scanner(System.in);
		double sum = 0.0;
		int count = 0;
		while (read2.hasNext()) {
			sum += read2.nextInt();
			count++;
		}
		System.out.println("Average is " + sum/count);
	}
}
