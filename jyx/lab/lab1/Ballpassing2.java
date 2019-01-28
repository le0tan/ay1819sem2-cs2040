
import java.util.*;

public class Ballpassing {
     private ArrayList<String> names = new ArrayList<>();
     private ArrayList<Integer> next = new ArrayList<>();
     private ArrayList<Integer> prev = new ArrayList<>();

     private void remove(int index) {
         next.set(prev.get(index), next.get(index));
         prev.set(next.get(index), prev.get(index));
     }
     private void insertAfter(int index, String name) {
         names.add(name);
         int newIndex = names.size() - 1;
         prev.add(index);
         next.add(next.get(index));
         next.set(index, newIndex);
         prev.set(next.get(newIndex), newIndex);
     }

     private int process(String event, int current) {
        if(event.equals("NEXT")) {
            current = next.get(current);
        }else if(event.equals("LEAVE")) {
            int temp = current;
            current = next.get(current);
            remove(temp);
        }else {
            String newName = event.substring(5);
            insertAfter(current, newName);
            current = next.get(current);
        }     
        System.out.println(names.get(current));
        return current;
    }
    private void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String name;
        for(int i = 0; i < n; i++) {
            name = in.next();
            names.add(name);
            next.add((i + 1) % n);
            prev.add((i - 1 + n) % n);
        }
        int queries = in.nextInt();
        String event;
        int current = 0;
        in.nextLine();
        while(queries > 0) {
            event = in.nextLine();
            current = process(event, current);
            queries--;
        }
    }
	public static void main(String[] args) {
		Ballpassing newBallpassing = new Ballpassing();
		newBallpassing.run();
	}
}

