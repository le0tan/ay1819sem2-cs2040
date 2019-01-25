import java.util.Scanner;

public class Hello {
	private static int boolToInt(boolean b) {
		if(b) return 1;
		else return 0;
	}
	private static int f(String[] t) {
		if(t[0].equals("AND")) {
			return boolToInt(t[1].equals("1") && t[2].equals("1"));
		} else {
			return boolToInt(t[1].equals("1") || t[2].equals("1"));
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt(); sc.nextLine();
		switch(mode) {
			case 1: {
				int s = sc.nextInt(); sc.nextLine();
				for(int i=0;i<s;i++) {
					String[] t = sc.nextLine().split(" ");
					System.out.println(f(t));
				}
				break;
			}
			case 2: {
				boolean ok = true;
				while(ok) {
					String[] t = sc.nextLine().split(" ");
					if(t[0].equals("0")) {
						ok = false;
						break;
					} else {
						System.out.println(f(t));
					}
				}
				break;
			}
			case 3: {
				while(sc.hasNext()) {
					String[] t = sc.nextLine().split(" ");
					System.out.println(f(t));
				}
				break;
			}
		}
	}
}
