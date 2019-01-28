

import java.util.*;

public class Ballpassing {

     private ListIterator<String> process(String event, ListIterator<String> iterator, LinkedList<String> names) {
        if(event.equals("NEXT")) {
            if(iterator.hasNext()) {
                System.out.println(iterator.next());
            } else {
                iterator = names.listIterator();
                System.out.println(iterator.next());
            }
        }else if(event.equals("LEAVE")) {
            iterator.remove();
            if(iterator.hasNext()) {
                System.out.println(iterator.next());
            } else {
                iterator = names.listIterator();
                System.out.println(iterator.next());
            }
        }else {
            String newName = event.substring(5);
            iterator.add(newName);
            System.out.println(iterator.previous());
            iterator.next();
        }    
        return iterator;
    }
    private void run() {
        Scanner in = new Scanner(System.in);
        LinkedList<String> names = new LinkedList<> ();
        int n = in.nextInt();
        String name;
        for(int i = 0; i < n; i++) {
            name = in.next();
            names.add(name);
        }
        int queries = in.nextInt();
        String event;
        ListIterator<String> iterator = names.listIterator();
        iterator.next();
        in.nextLine();
        while(queries > 0) {
            event = in.nextLine();
            iterator = process(event, iterator, names);
            queries--;
        }
    }
	public static void main(String[] args) {
		Ballpassing newBallpassing = new Ballpassing();
		newBallpassing.run();
	}
}
