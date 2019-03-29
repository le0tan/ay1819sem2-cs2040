/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class Brackets {
		private boolean ispar(char c) {
			String s = "{}[]()";
			for(int i=0;i<s.length();i++) {
				if(c==s.charAt(i)) return true;
			}
			return false;
		}
		private boolean isLeft(char c) {
			String s = "{[(";
			for(int i=0;i<s.length();i++) {
				if(c==s.charAt(i)) return true;
			}
			return false;
		}
		private boolean isRight(char c) {
			String s = "}])";
			for(int i=0;i<s.length();i++) {
				if(c==s.charAt(i)) return true;
			}
			return false;
		}
		private boolean isMatch(char right, char t) {
			if(right==']') return t=='[';
			if(right==')') return t=='(';
			if(right=='}') return t=='{';
			return false;
		}
    private void run() {
        //implement your "main" method here
				Scanner sc = new Scanner(System.in);
				int n = sc.nextInt();
				for(int i=0;i<n;i++) {
					int l = sc.nextInt();
					String s = sc.next();
					Stack<Character> stack = new Stack<>();
					boolean ok = true;
					for(int j=0;j<l && ok;j++) {
						char cur = s.charAt(j);
						if(isRight(cur)) {
							boolean matched = false;
							while(!stack.isEmpty()) {
								char a = stack.pop();
								if(!ispar(a)) continue;
								if(isMatch(cur, a)) { matched = true; break; }
								else { ok = false; break; }
							}
							if(!matched) { ok = false; }
						} else {
							stack.push(cur);
						}
					}
					if(!stack.isEmpty()) ok = false;
					if(ok) System.out.println("Valid");
					else System.out.println("Invalid");
				}
    }
    public static void main(String[] args) {
        Brackets newBrackets = new Brackets();
        newBrackets.run();
    }
}
