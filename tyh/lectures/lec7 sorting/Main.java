import java.util.*;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {1,5,2,3,4,5,134,123,345,1345,3567};
        QuickSort.sort(a);
        for(int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }
    }
}