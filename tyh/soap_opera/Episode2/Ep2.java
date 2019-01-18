import java.util.*;

import javax.management.Query;

/**
 * Ep2
 */
public class Ep2 {
    private static class PartialSum {
        List<Integer> arr = new ArrayList<Integer>();
        public void push(int n) {
            if(arr.isEmpty()) {
                arr.add(n);
            } else {
                arr.add(arr.get(arr.size()-1)+n);
            }
        }
        public int query(int l, int r) {
            if(l<=0) return arr.get(r);
            else return arr.get(r) - arr.get(l-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PartialSum ps = new PartialSum();
        System.out.println("How many numbers?");
        int n = sc.nextInt();
        for(int i=0;i<n;i++) {
            int k = sc.nextInt();
            ps.push(k);
        }
        // for(int i=0;i<n;i++) {
        //     System.out.printf("%d ", ps.arr.get(i));
        // }
        System.out.println(ps.query(1, 1));
    }
}