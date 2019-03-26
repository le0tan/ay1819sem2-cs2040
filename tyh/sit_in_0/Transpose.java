import java.util.*;
public class Transpose {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		char[][] g = new char[r][c];
		sc.nextLine();
		for(int i=0;i<r;i++) {
			String t = sc.nextLine();
			for(int j=0;j<c;j++) {
				g[i][j] = t.charAt(j);
			}
		}
		for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++) {
				System.out.print(g[j][i]);
			}
			System.out.println();
		}
	}
}
