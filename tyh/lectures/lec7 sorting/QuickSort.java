/**
 * QuickSort
 */
public class QuickSort {
    private static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private static int partition(int a[], int l, int r) {
        int ll=l+1, rr=r;
        while(ll<=rr) { // why ll < rr doesn't work on two numbers?
            if(a[ll] > a[l]) {
                swap(a,ll,rr);
                rr--;
            } else {
                ll++;
            }
        }
        swap(a,l,ll-1);
        return ll-1;
    }

    private static void quickSort(int a[], int l, int r) {
        if(l>=r) {
            return;
        } else {
            int mid = partition(a, l, r);
            quickSort(a, l, mid-1);
            quickSort(a, mid+1, r);
        }
    }

    public static void sort(int a[]) {
        quickSort(a, 0, a.length-1);
    }
}