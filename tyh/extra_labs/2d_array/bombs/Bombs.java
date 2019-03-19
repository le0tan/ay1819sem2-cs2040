/*
 * Name		:
 * Matric No.	:
 * Plab Account	:
 */

import java.util.*;

public class Bombs {
	private static class Point {
		public int x;
		public int y;
		Point(int x, int y) { this.x=x; this.y=y; }
	}
	private static class Pair<E> {
		public E a;
		public E b;
		Pair(E a, E b) { this.a = a; this.b = b; }
	}
	private static int numOfTargets(int[][] grid, Point lu, Point rb) {
		int count = 0;
		for(int i=lu.x;i<=rb.x;i++) {
			for(int j=lu,y;j<=rb.y;j++) {
				if(grid[i][j] == 1) count++;
			}
		}
		return count;
	}
	private static int min
	private static Pair<Point> range(int n, Point center, int size) {
		int lux = 
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

	}
	
}
