/**
 * Name			:
 * Matric No.	:
 */
import java.util.*;

public class Love {

	public void run() {
		// treat this as your "main" method
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		HashSet<String> set = new HashSet<>();
		ArrayList<String> input = new ArrayList<>();
		for(int i=0;i<n;i++) {
			String t = sc.next();
			set.add(t);
			input.add(t);
			ans += t.length();
		}
		int left=0,right=0;
		HashMap<String,Integer> cur = new HashMap<>();
		boolean ok = true;
		int curlen = 0;
		while(ok) {
			ok = false;
			while(right<input.size()) {
				String t = input.get(right);
				if(cur.get(t) != null) {
					cur.put(t, cur.get(t)+1);
				} else {
					cur.put(t, 1);
				}
				curlen += input.get(right).length();
				right++;
				if(cur.size() == set.size()) { ok = true; break; }
			} // found consecutive strings that meet the req
			if(ok) ans = Math.min(ans, curlen);
			else break;
			while(left<input.size()) {
				String t = input.get(left);
				if(cur.get(t) == 1) {
					cur.remove(t);
          curlen -= input.get(left).length();
					left++;
					break;
				} else {
					cur.put(t,cur.get(t)-1);
					curlen -= input.get(left).length();
					ans=Math.min(ans,curlen);
					left++;
				}
			}
			if(right>input.size()) break;
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		Love myLove = new Love();
		myLove.run();
	}

}
