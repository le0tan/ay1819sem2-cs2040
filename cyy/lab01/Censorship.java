/**
 * Name         : Chen Yongyan	
 * Matric. No   : A0177871N
 * PLab Acct.   :
 */

import java.util.*;

public class Censorship {
	String[] dict = new String[10];
	int n;

	private boolean match(String tmp){
		for (int i = 0; i < n; i++)
			if (tmp.compareTo(dict[i]) == 0)
				return true;

		return false;
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		String tmp;

		for (int i = 0; i < n; i++)
			dict[i] = sc.next().toUpperCase();

		
		while (sc.hasNext()){
			tmp = sc.next();
			if (match(tmp.toUpperCase()))
				for (int i = 0; i < tmp.length(); i++) System.out.print("*");
			else
				System.out.print(tmp);
			if (sc.hasNext()) System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Censorship newCensorship = new Censorship();
		newCensorship.run();
	}
}
