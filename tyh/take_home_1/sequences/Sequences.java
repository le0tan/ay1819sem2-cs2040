/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Sequences {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int t=sc.nextInt();
		long a=sc.nextLong();
		long b=sc.nextLong();
		long temp=a;
		System.out.print(Long.toString(temp));
		for(int i=1;i<n;i++){
			if(t==1){
				temp = temp + b;
			} else {
				temp = temp * b;
			}
			System.out.print(" ");
			System.out.print(Long.toString(temp));
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		Sequences newSequences = new Sequences();
		newSequences.run();
	}
}
