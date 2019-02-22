import java.util.*;

public class Useless {
	private static void useless(Queue<Integer> q) {
		Stack<Integer> temp = new Stack<Integer>();
		while(!q.isEmpty()) {
			if(temp.isEmpty()) {
				temp.push(q.poll());
			} else {
				int t = q.poll();
				if(t > temp.peek()) {
					while(!temp.isEmpty()) {
						System.out.println(temp.pop());
					}
					temp.push(t);
				} else {
					temp.push(t);
				}
			}
		}
		while(!temp.isEmpty()) {
			System.out.println(temp.pop());
		}
	}
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			q.add(sc.nextInt());
		}
		useless(q);
	}
}
