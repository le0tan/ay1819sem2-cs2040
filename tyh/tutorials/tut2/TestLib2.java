import java.util.*;

class TestLib2 {
	static void printList (LinkedList <?> alist) {
		System.out.print ("List is: ");
		for (int i = 0; i < alist.size (); i++)
			System.out.print (alist.get (i) + "\t");
		System.out.println ();
	}

	static void printList1 (LinkedList <?> alist) {
		System.out.print ("List is: ");
		while (alist.size () != 0) {    
			System.out.print (alist.element () + "\t");
			alist.removeFirst ();
		}
		System.out.println ();
	}

	public static void main (String [] args) {
		LinkedList <Integer> alist = new LinkedList <Integer> ();
		for (int i = 1; i <= 5; i++)
			alist.add (new Integer (i));

		printList (alist);

		LinkedList <Integer> cloneList = (LinkedList <Integer>) alist.clone ();
		// return type is Object for clone method, need cast
		printList1 (cloneList);  			
		System.out.println ("First element - " + alist.getFirst());		
		System.out.println ("Last element - "  + alist.getLast ());		
		alist.addFirst (888);
		alist.addLast (999);
		printList (alist);
		printList (cloneList);
	}  
}
