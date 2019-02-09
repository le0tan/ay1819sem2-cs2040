import java.util.*;

class TestLib {
	public static void main (String [] args) {
		LinkedList <String> bl = new LinkedList <String> ( );
		bl.addFirst ("aaa");
		bl.addFirst ("bbb");
		bl.addFirst ("ccc");
		bl.addLast ("ddd");

		for (int i=0; i < bl.size(); i++)
			System.out.print(bl.get(i) + " ");
		System.out.println();

		System.out.println("testing removal");
		bl.removeFirst( );
		bl.removeLast ( );

		for (int i=0; i < bl.size(); i++)
			System.out.print(bl.get(i) + " ");
		System.out.println();
	}
}
