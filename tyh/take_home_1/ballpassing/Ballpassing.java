/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Ballpassing {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); sc.nextLine();
		String[] names = sc.nextLine().split(" ");
		int q = sc.nextInt(); sc.nextLine();
		List<String> ls = new LinkedList<>();
		for(int i=0;i<n;i++) {
			ls.add(names[i]);
		}
		int pos = 0;
		for(int i=0;i<q;i++) {
			String[] cmd = sc.nextLine().split(" ");
			if(cmd[0].equals("NEXT")) {
				System.out.println(ls.get((pos+1)%n));
				pos = (pos+1)%n;
			} else if(cmd[0].equals("JOIN")) {
				if(pos+1<n) ls.add(pos+1, cmd[1]);
				else ls.add(cmd[1]);
				n++;
				System.out.println(ls.get((pos+1)%n));
				pos = (pos+1)%n;
			} else {
				// LEAVE
				ls.remove(pos);
				n--;
				System.out.println(ls.get(pos%n));
				pos = pos%n;
			}
		}
	}

	public static void main(String[] args) {
		Ballpassing newBallpassing = new Ballpassing();
		newBallpassing.run();
	}
}
