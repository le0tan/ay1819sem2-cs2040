/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class PandaChess {
	
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Set<Integer>> g = new ArrayList<>();
		for(int i=0;i<=n;i++) {
			g.add(new HashSet<>());
		}
		int[] in = new int[n+1];
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(!g.get(a).contains(b)) {
				g.get(a).add(b);
				in[b]++;
			}
		}
		List<Integer> start = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			if(in[i]==0) start.add(i);
		}
		if(start.isEmpty()) {
			System.out.println("No possible ranking.");
			return;
		}
		Queue<Integer> q = new ArrayDeque<>();
		List<Integer> res = new ArrayList<>();
		boolean[] vis = new boolean[n+1];
		boolean flag = false;
		if(start.size()>1) flag = true;
		q.addAll(start);
		while(!q.isEmpty()) {
			int cur = q.poll();
			vis[cur] = true;
			res.add(cur);
			for(Integer i: g.get(cur)) in[i]--;
			start = new ArrayList<>();
			for(Integer i: g.get(cur)) {
				if(vis[i]) continue;
				if(in[i]==0) start.add(i);
			}
			if(start.size()>1) {
				flag = true;
			}				
			q.addAll(start);
		}
		if(res.size()!=n) {
			System.out.println("No possible ranking.");
			return;
		}
		if(flag) {
			System.out.println("Ranking is not unique.");
			return;
		}
		for(Integer i: res) {
			System.out.println(i);
		}
	}


	public static void main(String[] args) {
		PandaChess newPandaChess = new PandaChess();
		newPandaChess.run();
	}
}
