/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Censorship {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); sc.nextLine();
		String[] words = sc.nextLine().split(" ");
		while(sc.hasNext()) {
			String t = sc.next();
			boolean ok = true;
			for(int i=0;i<n;i++) {
				if(t.toLowerCase().equals(words[i].toLowerCase())) {
					String out = "";
					for(int j=0;j<words[i].length();j++) {
						out += "*";
					}
					System.out.print(out);
					ok = false;
					break;
				}
			}
			if(ok) System.out.print(t);
			if(sc.hasNext()) System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Censorship newCensorship = new Censorship();
		newCensorship.run();
	}
}
