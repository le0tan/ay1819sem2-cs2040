import java.util.*;

class Stick
{

	static int f(int pos, int len, int[] sticks, int tar) {
		if(pos >= len) return -1;
		if(tar == sticks[pos]) return 1;
		if(tar > sticks[pos]) {
			int a = f(pos+1,len,sticks,tar-sticks[pos]);
			int b = f(pos+1,len,sticks,tar);
			if(a!=-1) return b==-1?a+1:Math.min(a+1,b);
			return b;
		} else {
			return f(pos+1,len,sticks,tar);
		}
	}

	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(),b=sc.nextInt();
		int[] sticks = new int[a];
		for(int i=0;i<a;i++)
			sticks[i] = sc.nextInt();
		System.out.println(f(0,a,sticks,b));
	}
}
