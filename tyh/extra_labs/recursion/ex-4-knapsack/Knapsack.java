import java.util.*;

class Knapsack
{

	static int f(int pos, int len, int[] items, int space) {
		if(pos>=len || space<=0) return 1;
		if(items[pos]<=space) {
			return f(pos+1,len,items,space-items[pos])
				 + f(pos+1,len,items,space);
		}
		return f(pos+1,len,items,space);
	}

	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), k=sc.nextInt();
		int[] items = new int[n];
		for(int i=0;i<n;i++) {
			items[i] = sc.nextInt();
		}
		System.out.println(f(0,n,items,k));
	}
}
