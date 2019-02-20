import java.util.*;
/**
 * RecStack
 */
public class RecStack {
    public int sum(Stack<Integer> s) {
        if(s.isEmpty()){
            return 0;
        } else {
            return s.pop() + sum(s);
        }
    }
    public void insert(Stack<Integer> s, Integer val) {
        if(s.peek()<=val) {
            s.push(val);
        } else {
            int temp = s.pop();
            insert(s, val);
            s.push(temp);
        }
    }
    public void delete(Stack<Integer> s, Integer val) {
        if(s.peek().equals(val)) {
            s.pop();
        } else {
            int temp = s.pop();
            delete(s, val);
            s.push(temp);
        }
    }
    public void sort(Stack<Integer> s) {
        if(s.size() <= 1) {
            return;
        } else {
            int temp = s.pop();
            sort(s);
            insert(s, temp);
        }
    }
    public static void main(String[] args) {
        
    }
}