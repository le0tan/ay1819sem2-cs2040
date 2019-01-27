/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Balls {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); sc.nextLine();
		int[] next = new int[400100];
		int[] last = new int[400100];
		String[] list = new String[400100];
		int ptr = 0;
		for(int i=0;i<n;i++) {
			list[ptr] = sc.next();
			next[ptr] = ptr+1;
			last[ptr] = ptr-1;
			ptr++;
		}
		last[0] = n-1;
		next[n-1] = 0;
		int q = sc.nextInt(); sc.nextLine();
		int pos = 0;
		for(int i=0;i<q;i++) {
			String cmd = sc.next();
			if(cmd.equals("NEXT")) {
				System.out.println(list[next[pos]]);
				pos = next[pos];
			} else if(cmd.equals("JOIN")) {
				list[ptr] = sc.next();
				last[ptr] = pos;
				next[ptr] = next[pos];
				last[next[pos]] = ptr;
				next[pos] = ptr;
				ptr++;
				System.out.println(list[next[pos]]);
				pos = next[pos];
			} else {
				next[last[pos]] = next[pos];
				last[next[pos]] = last[pos];
				System.out.println(list[next[pos]]);
				pos = next[pos];
			}
		}
	}

	public static void main(String[] args) {
		Balls newBallpassing = new Balls();
		newBallpassing.run();
	}
}
