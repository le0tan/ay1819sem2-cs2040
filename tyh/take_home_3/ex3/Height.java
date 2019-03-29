/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class Height {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Edge>[] adjList = new ArrayList[n];
		for(int i=0;i<n;i++) adjList[i] = new ArrayList<Edge>();
		for(int i=0;i<n-1;i++) {
			int from=sc.nextInt()-1;
			int to=sc.nextInt()-1;
			int w=sc.nextInt();
			adjList[from].add(new Edge(to, w));
			adjList[to].add(new Edge(from, -w));
		}
		long[] height = new long[n];
		boolean[] vis = new boolean[n];
		Queue<Integer> Q = new LinkedList<>();
		Q.add(0);
		height[0] = 0;
		vis[0] = true;
		int prevHeight = 0;
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(Edge e: adjList[cur]) {
				if(!vis[e.to]) {
					vis[e.to] = true;
					Q.add(e.to);
					height[e.to] = height[cur] + e.weight;
				}
			}
		}
		int q = sc.nextInt();
		for(int i=0;i<q;i++) {
			int from=sc.nextInt()-1;
			int to=sc.nextInt()-1;
			System.out.println(height[to]-height[from]);
		}

	}
	public static void main(String[] args) {
		Height newHeight = new Height();
		newHeight.run();
	}
}

class Edge {
	int to;
	long weight;
	public Edge(int a, long b) {
		to = a; weight = b;
	}
}
