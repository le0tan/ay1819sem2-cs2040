/**
 *
 * author	: [Fan Wenjing]
 * matric no: [A0177912X]
 * 
 */

import java.util.*;

public class HelloWorld {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String i;
		boolean a,b;
		while(sc.hasNext()){
			i=sc.next();
			switch(i) {
				case "AND":{
						   a=sc.nextInt()==1;
						   b=sc.nextInt()==1;
						   if (a&&b) System.out.println(1);
						   else System.out.println(0); 
						   break;}
				case "OR":{
						  a=sc.nextInt()==1;
						  b=sc.nextInt()==1;
						  if (a||b) System.out.println(1);
						  else System.out.println(0); 
						  break;}				
				default: sc.nextLine();

			}
		}
	}
}
