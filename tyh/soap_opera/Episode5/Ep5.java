import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Ep5
 */
public class Ep5 {
    public static int concatInt(int a, int b) {
        int t = b;
        while(t != 0) {
            a *= 10;
            t /= 10;
        }
        return a + b;
    }

    private static boolean greaterThan(int a, int b) {
        return concatInt(a,b) > concatInt(b,a);
    }

    static List<Integer> sort(List<Integer> l) {
        int len = l.size();
        for(int i=len-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                if(!greaterThan(l.get(j), l.get(j+1))) {
                    int temp = l.get(j+1);
                    l.set(j+1, l.get(j));
                    l.set(j, temp);
                }
            }
        }
        return l;
    }
    public static void main(String[] args) {
        // System.out.println(greaterThan(50, 51));
        int[] arr = {5,50,56};
        List<Integer> ls = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++)  {
            ls.add(arr[i]);
        }
        ls = sort(ls);
        for(int i=0;i<arr.length;i++)  {
            System.out.print(ls.get(i));
        }
    }
}