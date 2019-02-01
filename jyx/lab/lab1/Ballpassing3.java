import java.util.*;

public class Ballpassing {

     private String process(String event, LinkedList<String> names) {
        if(event.equals("NEXT")) {
            names.addLast(names.poll());
            return names.getFirst();
        }else if(event.equals("LEAVE")) {
            names.removeFirst();
            return names.getFirst();
        }else {
            names.addLast(names.poll());
            String newName = event.substring(5);
            names.addFirst(newName);
            return newName;
        }    
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
        in.nextLine();
        while(queries > 0) {
            event = in.nextLine();
            System.out.println(process(event, names));
            queries--;
        }
    }
	public static void main(String[] args) {
		Ballpassing newBallpassing = new Ballpassing();
		newBallpassing.run();
	}
}

