/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Boxes {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		Set<Pair> set = new HashSet<>();
		Set<Integer> row = new HashSet<>();
		Set<Integer> col = new HashSet<>();
		int q=sc.nextInt(),r=sc.nextInt(),c=sc.nextInt();
		for(int i=0;i<q;i++) {
			String cmd = sc.next();
			switch(cmd) {
				case "SIT":
					int cr=sc.nextInt(), cc=sc.nextInt();
					Pair p = new Pair(cr,cc);
					if(!set.contains(p)) {
						set.add(p);
						row.add(cr);
						col.add(cc);
					}
					break;
				case "BOX":
					Pair pp = new Pair(sc.nextInt(),sc.nextInt());
					if(set.contains(pp))
						System.out.println("Y");
					else
						System.out.println("N");
					break;
				case "ROW":
					if(row.contains(sc.nextInt()))
						System.out.println("Y");
					else 
						System.out.println("N");
					break;
				case "COL":
					if(col.contains(sc.nextInt()))
						System.out.println("Y");
					else 
						System.out.println("N");
					break;
				default:
					break;
			}
		}
	}

	public static void main(String[] args) {
		Boxes newBoxes = new Boxes();
		newBoxes.run();
	}
}

class Pair {
	int x;
	int y;
	public Pair(int a, int b) {
		x=a;
		y=b;
	}
	@Override
	public String toString() {
		return String.format("(%d,%d)", x,y);
	}
	@Override
	public int hashCode() {
		return 23*x-29*y;
	}
	@Override
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(!(o instanceof Pair))
			return false;
		Pair p = (Pair) o;
		return this.x==p.x && this.y==p.y;
	}
}
