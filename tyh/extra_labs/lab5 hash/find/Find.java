/**
 *	name	  :
 *	matric no.:
 */

import java.util.*;

class Find {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), k=sc.nextInt();
		String a=sc.next(),b=sc.next();
		HashSet<String> subsA = new HashSet<>();
		HashSet<String> subsB = new HashSet<>();
		for(int i=0;i<=n-k;i++) {
			subsA.add(a.substring(i,i+k));
			subsB.add(b.substring(i,i+k));
		}
		int q=sc.nextInt();
		for(int i=0;i<q;i++) {
			int res = 0;
			String cur = sc.next();
			if(subsA.contains(cur)) res+=1;
			if(subsB.contains(cur)) res+=2;
			System.out.println(res);
		}
	}
}
