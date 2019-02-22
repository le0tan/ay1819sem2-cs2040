import java.util.*;

public class SX {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i=6;i>=1;i--)
			s1.push(i);
		boolean okk = true;
		for(int i=0;i<6;i++) {
			int n = sc.nextInt();
			if(!s2.isEmpty()) {
				if(s2.peek() == n) {
					s2.pop();
					sb.append("X");
					continue;
				}
			}
			boolean ok = false;
			while(!s1.isEmpty()) {
				if(s1.peek() == n) {
					s1.pop();
					sb.append("SX");
					ok = true;
					break;
				} else {
					s2.push(s1.pop());
					sb.append("S");
				}
			}
			if(ok) continue;
			else {
				okk = false;
				break;
			}
		}
		if(okk) System.out.println(sb);
		else System.out.println("No solution");
	}
}
