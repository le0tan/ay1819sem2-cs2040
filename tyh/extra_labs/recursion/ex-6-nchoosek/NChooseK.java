import java.util.*;

class NChooseK
{

	static List<String> f(int k, String src) {
		List<String> res = new ArrayList<>();
		System.out.printf("%d %s\n",k,src);
		if(k==0) {
			res.add("");
			return res;
		} else sif(src.length()==k) {
			res.add(src);
			return res;
		} else {
			List<String> temp;
			String cur = src.substring(0,1);
			temp = f(k-1,src.substring(1,src.length()));
			for(String i: temp)
				res.add(cur+i);
			res.addAll(f(k,src.substring(1,src.length())));
			return res;
		}
	}

	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		List<String> res = f(k, sc.next());
		for(String i: res) {
			System.out.println(i);
		}
	}
}
