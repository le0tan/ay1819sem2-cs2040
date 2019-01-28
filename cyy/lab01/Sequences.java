/**
 * Name         : Chen Yongyan	
 * Matric. No   : A0177871N
 * PLab Acct.   :
 */

import java.util.*;

public class Sequences {


	private void run() {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int  t = sc.nextInt();
		long a = sc.nextLong(), b = sc.nextLong();
		long tmp;
		switch (t){
			case 1:
				tmp = a;
				for (int i = 0; i< n - 1; i++){
					System.out.print(tmp+" ");
					tmp += b;
				}
				System.out.println(tmp);
				break;
			case 2:
				tmp = a;
				for (int i = 0; i< n - 1; i++){
					System.out.print(tmp+" ");
					tmp *= b;
				}
				System.out.println(tmp);
				break;
		}
		sc.close();
	}

	public static void main(String[] args) {
		Sequences newSequences = new Sequences();
		newSequences.run();
	}
}
