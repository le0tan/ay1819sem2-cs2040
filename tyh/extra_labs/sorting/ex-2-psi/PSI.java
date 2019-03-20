import java.util.*;

class PSI {
	static int count=0;

	static void merge(int[] arr, int left, int mid, int right) {
		int[] C = new int[right-left+1];
		int a=left, b=mid, c=0;
		while(a<mid && b<=right) {
			if(arr[a] < arr[b]) {
				C[c++] = arr[a++];
			} else {
				count += mid-a;
				C[c++] = arr[b++];
			}
		}
		if(a==mid) {
			while(b<=right) {
				C[c++] = arr[b++];
			}
		} else {
			while(a<mid) {
				C[c++] = arr[a++];
			}
		}
		for(int i=0;i<C.length;i++) {
			arr[left+i] = C[i];
		}
	}

	static void mergesort(int[] arr, int left, int right) {
		if(left>=right) return;
		mergesort(arr, left, (left+right)/2);
		mergesort(arr, (left+right)/2 + 1, right);
		merge(arr, left, (left+right)/2+1, right);
	}

	static void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] sum = new int[n+1];
		sum[0] = 0;
		int neg = 0;
		for(int i=0;i<n;i++) {
			int cur = sc.nextInt();
			if(cur<=0) neg++;
			if(i==0) sum[i+1] = cur;
			else {
				sum[i+1] = sum[i] + cur;
			}
		}
		mergesort(sum,0,sum.length-1);
		System.out.println(n*(n+1)/2-count);
	}

	public static void main(String[] args) {
		run();
	}
}