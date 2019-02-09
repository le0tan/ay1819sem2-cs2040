import java.util.*;

class TestBasic1 {
	public static void main (String [] args) {
		BasicLinkedList <String> bl = new BasicLinkedList <String> ( );
		bl.addFirst ("aaa");
		bl.addFirst ("bbb");
		bl.addFirst ("ccc");
		bl.print();

		System.out.println("testing removal");
		bl.removeFirst( );
		bl.print( );

		System.out.println("testing removal");
		bl.removeFirst( );
		if ( bl.contains("aaa") ) bl.addFirst ("xxxx");
		bl.print( );
	}
}
