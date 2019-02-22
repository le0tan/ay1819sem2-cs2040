/**
 * MergeSort
 */
public class MergeSort {

    private static void merge(int a[], int l, int mid, int r) {
        int[] t = new int[r-l+1];
        int ll = l, rr = mid+1, it=0;
        while(ll <= mid && rr <= r) {
            if(a[ll]<a[rr]) {
                t[it++] = a[ll++];
            } else {
                t[it++] = a[rr++];
            }
        }
        while(ll<=mid) {
            t[it++] = a[ll++];
        }
        while(rr<=r) {
            t[it++] = a[rr++];
        }
        for(int i=0;i<t.length;i++) {
            a[l+i] = t[i];
        }
    }

    private static void mergeSort(int a[], int l, int r) {
        if(l>=r) {
            return;
        } else {
            int mid = (l+r)/2;
            System.out.printf("%d %d %d\n", l,mid,r);
            mergeSort(a, l, mid);
            mergeSort(a, mid+1, r);
            merge(a, l, mid, r);
        }
    }

    public static void sort(int a[]) {
        mergeSort(a, 0, a.length-1);
    }
}