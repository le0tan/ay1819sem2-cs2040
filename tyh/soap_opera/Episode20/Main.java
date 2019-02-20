import java.util.*;
import java.io.*;

/**
 * Main
 */
public class Main {

    // −9 −7 −2 2 −3 −2 −1 1 2 3 7 9
    // −9 −7 −2 2 −3 −1 −2 2 1 3 7 9
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lines = null;
        while((lines=br.readLine())!=null) {
            String[] strs = lines.trim().split("\\s+");
            int[] sum = new int[120];
            Stack<Integer> s = new Stack<Integer>();
            boolean ok = true;
            for (int i = 0; i < strs.length; i++) {
                int cur = Integer.parseInt(strs[i]);
                if(cur < 0) {
                    if(s.isEmpty()) {
                        s.push(cur);
                    } else {
                        sum[-s.peek()] += (-cur);
                        if(sum[-s.peek()] >= -s.peek()) {
                            ok = false;
                            break;
                        } else {
                            s.push(cur);
                        }
                    }
                } else {
                    if(s.isEmpty()) {
                        ok = false;
                        break;
                    } else {
                        if(s.peek() != -cur) {
                            ok = false;
                            break;
                        } else {
                            s.pop();
                        }
                    }
                }
            }
            if(ok && s.isEmpty()) {
                System.out.println(":-) Matrioshka!");
            } else {
                System.out.println(":-( Try again.");
            }
        }
    }
}