import java.util.*;

class TestExtended {
	public static void main (String [] args) {

		ExtendedLinkedList <String> bl = new ExtendedLinkedList <String>  ();

		System.out.println("Part 1");
		bl.addFirst ("aaa" );
		bl.addFirst ( (new ComplexCart(2,3)).toString() );
		bl.addFirst ("ccc");
		bl.print();

		System.out.println();
		System.out.println("Part 2");
		ListNode <String> current = bl.getFirstPtr();
		bl.addAfter(current, "xxx");
		bl.addAfter(current, (new ComplexCart(6,6)).toString() );
		bl.print();

		System.out.println();
		System.out.println("Part 3");
		if ( bl.contains ((new ComplexCart(3,3)).toString()) )
			bl.remove(  (new ComplexCart(3,3)).toString() );
		else
			System.out.println("complex no. does not exist");
		bl.print();

		System.out.println();
		System.out.println("Part 4");
		bl.removeAfter( current );
		bl.print();
	}
}
