/**
 * Name         : Chen Yongyan	
 * Matric. No   : A0177871N
 * PLab Acct.   :
 */

import java.util.*;

public class Sequences {

	/**
	 * a basic problem.
	 * How can I submitted it 7 times. 
	 * Such a shame
	 * OMG.
	 */
	private void run() {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int  t = sc.nextInt();
		long a = sc.nextLong(), b = sc.nextLong();
		// the sequence of the input;
		// My brain was not working again.
		long tmp;
		switch (t){
			case 1:
				tmp = a;
				for (int i = 0; i< n - 1; i++){
					System.out.print(tmp+" ");
					tmp += b;
				}
				System.out.println(tmp);
				//No space after the last integer. I noticed it but i dont know why i still added " " after it. XD
				// My brain was not working. I was too sleepy.
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
