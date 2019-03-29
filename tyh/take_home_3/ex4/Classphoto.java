/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class Classphoto {

	TreeSet<Person> set = new TreeSet<>((x,y) -> {
		if(x.height==y.height) {
			return y.index-x.index;
		} else {
			return x.height - y.height;
		}
	});
	
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		set.add(new Person("Rar", 0, 0));
		for(int i=1;i<=n;i++) {
			Person t = new Person(sc.next(), sc.nextInt(), i);
			System.out.println(set.floor(t).name);
			set.add(t);
		}
		String[] res = new String[n+1];
		int count = 0;
		for(Person p: set) {
			res[count++] = p.name;
		}
		for(int i=0;i<res.length-1;i++)
			System.out.print(res[i]+ " ");
		System.out.println(res[res.length-1]);
	}
	public static void main(String[] args) {
		Classphoto newClassphoto = new Classphoto();
		newClassphoto.run();
	}
}

class Person {
	String name;
	int height;
	int index;

	public Person(String a, int b, int c) {
		name=a; height=b; index=c;
	}
}
