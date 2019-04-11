/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class PandaIslands {
	int count_one;
	int count_zero;
	int[] area;
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		List<List<Integer>> g = new ArrayList<>();
		area = new int[n];
		int[] color = new int[n];
		for(int i=0;i<n;i++) {
			color[i] = -1;
			g.add(new ArrayList<>());
			area[i] = sc.nextInt();
		}
		for(int i=0;i<e;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			g.get(a-1).add(b-1);
			g.get(b-1).add(a-1);
		}
		int count = 0;
		for(int i=0;i<n;i++) {
			if(color[i]==-1) {
				count_one = 0;
				count_zero = 0;
				dfs(i, g, color, 0);
				count += Math.min(count_one, count_zero);
			}
		}
		System.out.println(count);
	}

	private void dfs(int n, List<List<Integer>> g, int[] color, int c) {
		color[n] = c;
		if(c==1) count_one += area[n];
		else count_zero += area[n];
		for(Integer i: g.get(n)) {
			if(color[i]==-1)
				dfs(i,g,color,c==1 ? 0 : 1);
		}
	}
	public static void main(String[] args) {
		PandaIslands newPandaIslands = new PandaIslands();
		newPandaIslands.run();
	}
}
