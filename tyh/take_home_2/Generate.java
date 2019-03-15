/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Generate {
	private List<String> perm(String s) {
		List<String> res = new ArrayList<>();
		if(s.length() <=1) {
			res.add(s);
		} else {
			List<String> temp = null;
			for(int i=0;i<s.length();i++) {
				temp = perm(s.substring(0,i)+s.substring(i+1,s.length()));
				for(int j=0;j<temp.size();j++) {
					temp.set(j,s.substring(i,i+1)+temp.get(j));
				}
				res.addAll(temp);
			}
		}
		return res;
	}
	private List<String> subseq(String s) {
		List<String> res = new ArrayList<>();
		if(s.length() <= 0) {
			res.add("");
		} else {
			List<String> temp = subseq(s.substring(1, s.length()));
			res.addAll(temp);
			for(String ss: temp) {
				res.add(s.substring(0, 1)+ss);
			}
		}
		return res;
	}

	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char[] arr = input.toCharArray();
		Arrays.sort(arr);
		String sorted = new String(arr);
		List<String> ans1 = perm(sorted);
		Collections.sort(ans1);
		List<String> ans2 = subseq(input);
		Collections.sort(ans2);
		for(String s: ans1) 
			System.out.println(s);
		for(String s: ans2) 
			if(!s.equals("")) System.out.println(s);
	}

	public static void main(String[] args) {
		Generate newGenerate = new Generate();
		newGenerate.run();
	}
}
