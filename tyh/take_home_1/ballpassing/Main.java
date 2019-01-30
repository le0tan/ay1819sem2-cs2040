import java.util.*;

public class Main {

	public static void main(String[] args) {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); sc.nextLine();
		LinkedList<String> names = new LinkedList<>();
		for(int i=0;i<n;i++) {
			names.add(sc.next());
		}
		ListIterator<String> it = names.listIterator(1);
		int q = sc.nextInt(); sc.nextLine();
		for(int i=0;i<q;i++) {
			String cmd = sc.next();
			if(cmd.equals("NEXT")) {
				if(it.hasNext())
					System.out.println(it.next());
				else {
					it = names.listIterator(0);
					System.out.println(it.next());
				}
			} else if(cmd.equals("JOIN")) {
				it.add(sc.next());
				it.previous();
				System.out.println(it.next());
			} else {
				// LEAVE
				it.previous();
				it.remove();
				if(!it.hasNext()) it=names.listIterator();
				System.out.println(it.next());
			}
		}
	}
}
