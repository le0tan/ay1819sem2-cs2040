
import java.util.*;

public class Censorship {
    private String construct(int length) {
        StringBuilder builder = new StringBuilder(); 
        for(int i = 0; i < length;i++)
            builder.append("*");
        return builder.toString();
    }
	private boolean test(String word, String[] badWords) {
        for(String badWord : badWords) 
            if(word.equals(badWord)) return false;
        return true;
    }

    private void run() {
	    Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] badWords = new String[n];
        for(int i = 0; i < n;i++)
            badWords[i] = in.next().toLowerCase();
        String word;
        boolean first = true;
        while(in.hasNext()) {
            word = in.next();
            if(!first) System.out.print(" ");
            else first = false;
            if(test(word.toLowerCase(), badWords)) System.out.print(word);
            else System.out.print(construct(word.length()));
        }
        System.out.println();
    }

	public static void main(String[] args) {
		Censorship newCensorship = new Censorship();
		newCensorship.run();
	}
}
