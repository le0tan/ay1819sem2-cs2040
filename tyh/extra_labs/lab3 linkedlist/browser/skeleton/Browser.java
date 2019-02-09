
/**
*	Name		:
*	Matric No.	:
*/

import java.util.*;

public class Browser {
	private LinkedList<String> tabs;
	private ListIterator<String> iter;
	Browser() {
		tabs = new LinkedList<String>();
		iter = tabs.listIterator();
		newTab();
	}
	private void newTab() {
		// tabs.add("http://www.comp.nus.edu.sg");
		iter.add("http://www.comp.nus.edu.sg");
	}
	private void closeTab() {
		if(iter.hasPrevious()) {
			iter.previous();
			iter.next();
		}
		iter.remove();
	}
	private void nextTab() {
		if(iter.hasNext()) {
			iter.next();
		} else {
			iter = tabs.listIterator();
		}
	}
	private void prevTab() {
		if(iter.hasPrevious()) {
			iter.previous();
		} else {
			iter = tabs.listIterator(tabs.size()-1);
		}
	}
	private void openHere(String url) {
		if(iter.hasPrevious()) {
			iter.previous();
			iter.next();
		} else {
			iter = tabs.listIterator(1);
			iter.previous();
		}
		iter.set(url);
	}
	private void openNew(String url) {
		if(iter.hasPrevious()) {
			iter.previous();
			iter.next();
		}
		iter.add(url);
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			String cmd = sc.next();
			if(cmd.equals("NEWTAB")) {
				newTab();
			} else if(cmd.equals("CLOSETAB")) {
				closeTab();
			} else if(cmd.equals("NEXTTAB")) {
				nextTab();
			} else if(cmd.equals("PREVTAB")) {
				prevTab();
			} else if(cmd.equals("OPENHERE")) {
				String url = sc.next();
				openHere(url);
			} else {
				String url = sc.next();
				openNew(url);
			}
		}
		for(String s: tabs) {
			System.out.println(s);
		}
	}
	public static void main(String[] args) {
		Browser bs = new Browser();
		bs.run();
	}
}

// class LinkedList<E> {
// 	protected ListNode head = null;

// 	public void addAfter(E item, E after) {

// 	}

// 	public int findIndex(E item) {
// 		return 0;
// 	}
// }

// class ListNode<E> {
// 	protected E element;
// 	protected ListNode<E> next;

// 	/* constructors */
// 	public ListNode(E item) {
// 		element = item;
// 		next = null;
// 	}

// 	public ListNode(E item, ListNode<E> n) {
// 		element = item;
// 		next = n;
// 	}

// 	/* get the next ListNode */
// 	public ListNode<E> getNext() {
// 		return this.next;
// 	}

// 	/* get the element of the ListNode */
// 	public E getElement() {
// 		return this.element;
// 	}

// 	public void setNext(ListNode<E> item) {
// 		this.next = item;
// 	}

// 	public void setElement(E item) {
// 		this.element = item;
// 	}
// }
