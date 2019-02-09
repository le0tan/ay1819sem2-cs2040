import java.util.*;

class TestTailed {
	public static void main (String [] args) {

		TailedLinkedList <String> bl = new TailedLinkedList <String>  ();

		System.out.println("Part 1");
		bl.addLast ("aaa" );
		bl.addLast ( (new ComplexCart(2,3)).toString() );
		bl.addLast ("ccc");
		bl.addFirst ("ddd");
		bl.print();

		System.out.println();
		System.out.println("Part 2");
		ListNode <String> current = bl.getFirstPtr();
		bl.addAfter(current, "xxx");
		bl.addAfter(current, (new ComplexCart(6,6)).toString() );
		bl.print();

		System.out.println();
		System.out.println("Part 3");
		if ( bl.contains ( (new ComplexCart(2,3)).toString()) )
			bl.remove(  (new ComplexCart(2,3)).toString() );
		else
			System.out.println("complex no. does not exist");
		bl.print();

		System.out.println();
		System.out.println("Part 4");
		bl.removeAfter( current );
		bl.print();
	}
}
