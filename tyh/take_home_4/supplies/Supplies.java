/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class Supplies {
    private void run() {
        //implement your "main" method here
				Scanner sc = new Scanner(System.in);
				int n = sc.nextInt();
				int e = sc.nextInt();
				int h = sc.nextInt();
				int t = sc.nextInt();
				List<List<Edge>> g = new ArrayList<>();
				for(int i=0;i<n;i++) {
					g.add(new ArrayList<>());
				}
				for(int i=0;i<e;i++) {
					int a = sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
					g.get(a).add(new Edge(b,c));
				}
				int resA = dijkstra(g,h,t);
				int resB = dijkstra(g,t,h);
				if(resA==Integer.MAX_VALUE || resB==Integer.MAX_VALUE) {
					System.out.println(-1);
				} else {
					System.out.println(resA+resB);
				}
    }

		private int min_index(int[] dist, boolean[] vis) {
			int idx = -1;
			int val = Integer.MAX_VALUE;
			for(int i=0;i<dist.length;i++) {
				if(!vis[i] && dist[i]<val) {
					idx = i;
					val = dist[i];
				}
			}
			return idx;
		}

		private int dijkstra(List<List<Edge>> g, int src, int tar) {
			int[] dist = new int[g.size()];
			boolean[] vis = new boolean[g.size()];
			for(int i=0;i<g.size();i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			dist[src] = 0;
			for(int i=0;i<g.size()-1;i++) {
				int u = min_index(dist, vis);
				if(u==-1) break;
				vis[u] = true;
				for(Edge k: g.get(u)) {
					if(!vis[k.to]) dist[k.to] = Math.min(dist[k.to], dist[u]+k.weight);
				}
			}
			return dist[tar];
		}

    public static void main(String[] args) {
        Supplies newSupplies = new Supplies();
        newSupplies.run();
    }
}

class Edge {
	int to, weight;
	public Edge(int a, int b) {
		to = a; weight = b;
	}
}
