/**
 *
 * author	: Jiang Yuxin
 * matric no: A0177868A
 * 
 */

import java.util.*;

public class HelloWorld {
	public static void query(Scanner scanner) {
        String operation = scanner.next();
        int operand1 = scanner.nextInt();
        int operand2 = scanner.nextInt();
        if(operation.equals("AND")) System.out.println(operand1 & operand2);
        else System.out.println(operand1 | operand2);
    }

    public static void readMethod1(Scanner scanner) {
        int n = scanner.nextInt();
        while(n > 0) {
            query(scanner);
            n--;
        }
    }
    public static void readMethod2(Scanner scanner) {
        while(!scanner.hasNext("0")) {
            query(scanner);
        }
    }
    public static void readMethod3(Scanner scanner) {
        while(scanner.hasNext()) {
            query(scanner);
        }
    }

	public static void main(String[] args) {
		// declare the necessary variables
        // declare a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        // read input and process them accordingly
        int type = scanner.nextInt();
        switch (type) {
            case 1: readMethod1(scanner);break;
            case 2: readMethod2(scanner);break;
            case 3: readMethod3(scanner);break;
        }
	}
}
