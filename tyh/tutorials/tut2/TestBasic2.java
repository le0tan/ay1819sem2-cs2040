import java.util.*;

class TestBasic2 {
	public static void main (String [] args) {
		BasicLinkedList <Integer> bl = new BasicLinkedList <Integer> ( );

		bl.addFirst (34);
		bl.addFirst (12);
		bl.addFirst (9);
		bl.print();

		System.out.println("testing removal");
		bl.removeFirst( );
		bl.print( );
	}
}
