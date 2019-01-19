import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Ep5
 */
public class Ep5 {
    static boolean greaterThan(Integer a, Integer b) {
        String as = a.toString();
        String bs = b.toString();
        int[] ar = new int[as.length()];
        int[] br = new int[bs.length()];
        for(int i=0;i<as.length();i++) ar[i] = Character.getNumericValue(as.charAt(i));
        for(int i=0;i<bs.length();i++) br[i] = Character.getNumericValue(bs.charAt(i));
        // boolean ok = false;
        if(ar[0] == br[0]) {
            int len = ar.length < br.length ? ar.length : br.length;
            for(int i=0;i<len;i++) {
                if(ar[i] > br[i]) return true;
                else if(ar[i] == br[i]) continue;
                else return false;
            }
            return ar.length < br.length;
        } else {
            // System.out.print(br[0]);
            return ar[0] > br[0];
        }
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