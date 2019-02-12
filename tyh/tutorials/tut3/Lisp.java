import java.util.*;
public class Lisp {
	private static boolean isOp(String a) {
		return a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/");
	}
	private static boolean isPar(String a) {
		return a.equals("(") || a.equals(")");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean ok = true;
		Stack<String> ops = new Stack<String>();
		while(ok && sc.hasNext()) {
			String t = sc.next();
			if(t.equals(")")) {
				if(ops.isEmpty()) {ok=false;break;}
				Stack<String> nums = new Stack<String>();
				while(!ops.isEmpty() && !isOp(ops.peek()) && !isPar(ops.peek())) {
					nums.push(ops.pop());
				}
				if(ops.isEmpty()) {ok=false;break;}
				if(isPar(ops.peek())) {
					ok = false;
					break;
				} else {
					String op = ops.pop();
					if(ops.isEmpty()) {ok=false;break;}
					else {
						if(!ops.pop().equals("(")) {ok=false;break;}
					}
					if(nums.isEmpty() && (op.equals("-") || op.equals("/"))) {
						ok = false;
						break;
					} else {
						if(nums.isEmpty()) {
							switch(op) {
								case "+":
									ops.push("0");
									break;
								case "*":
									ops.push("1");
									break;
								default:
									ok = false;
									break;
							}
						} else if(nums.size() == 1) {
							String nn = nums.pop();
							boolean neg = nn.charAt(0)=='-' ? true : false;
							switch(op) {
								case "+":
									ops.push(nums.pop());
									break;
								case "-":
									ops.push(neg?nn.substring(1,nn.length()):"-"+nn);
									break;
								case "*":
									ok = false;
									break;
								case "/":
									ops.push(Double.toString((double)1/Double.valueOf(nn)));
									break;
								default:
									ok = false;
									break;
							}
						} else {
							double tres = Double.valueOf(nums.pop());
							while(!nums.isEmpty()) {
								double cur = Double.valueOf(nums.pop());
								switch(op) {
									case "+":
										tres += cur;
										break;
									case "-":
										tres -= cur;
										break;
									case "*":
										tres *= cur;
										break;
									case "/":
										tres /= cur;
										break;
									default:
										ok = false;
										break;
								}
							}
							ops.push(Double.toString(tres));
						}
					}
				}
			} else {
				ops.push(t);
			}
		}
		double k = 0.0;
		if(ok && !ops.isEmpty()) {
			String res = ops.pop();
			try {
				k = Double.valueOf(res);
			} catch (Exception e) {
				ok = false;
			}
		}
		if(!ok || !ops.isEmpty()) {
			System.out.println("Illegal expression!");
		} else {
			System.out.println(k);
		}
	}
}
