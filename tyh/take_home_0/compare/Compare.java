import java.util.Scanner;

public class Compare {
	private static int greaterThan(String a, String b) {
		int len = Math.min(a.length(), b.length());
		for(int i=0;i<len;i++) {
			if(Character.toLowerCase(a.charAt(i)) != Character.toLowerCase(b.charAt(i))) {
				 if(Character.toLowerCase(a.charAt(i)) > Character.toLowerCase(b.charAt(i)))
					 return 2;
				 else return 1;
			}
		}
		if(a.length()==b.length()) return 0;
		else if(a.length()>b.length()) return 2;
		else return 1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		System.out.println(greaterThan(a, b));
	}
}
