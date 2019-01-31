import java.util.*;

public class Main {
	private static void shiftLeft(int[] arr) {
//		boolean changed = false;
		for(int i=0;i<4;i++) {
			if(arr[i]==0) {
				for(int j=i+1;j<4;j++) {
					if(arr[j]!=0) {
						arr[i] = arr[j];
						arr[j] = 0;
//						changed = true;
						break;
					}
				}
			}
		}
		for(int i=0;i<3;i++) {
			if(arr[i]!=0 && arr[i]==arr[i+1]) {
				arr[i] += arr[i];
				arr[i+1] = 0;
//				changed = true;
			}
		}
//		if(changed) shiftLeft(arr);
		for(int i=0;i<4;i++) {
			if(arr[i]==0) {
				for(int j=i+1;j<4;j++) {
					if(arr[j]!=0) {
						arr[i] = arr[j];
						arr[j] = 0;
//						changed = true;
						break;
					}
				}
			}
		}
	}
	private static void turn_cw(int[][] arr) {
		int[][] g = new int[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				g[j][3-i] = arr[i][j];
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				arr[i][j] = g[i][j];
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] g = new int[4][4];
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				g[i][j] = sc.nextInt();
			}
		}
		int mode = sc.nextInt();
		switch(mode) {
			case 0: {
				for(int i=0;i<4;i++)
					shiftLeft(g[i]);
				break;
			}
			case 1: {
				for(int i=0;i<3;i++)
					turn_cw(g);
				for(int i=0;i<4;i++)
					shiftLeft(g[i]);
				turn_cw(g);
				break;
			}
			case 2:{ 
				for(int i=0;i<2;i++)
					turn_cw(g);
				for(int i=0;i<4;i++)
					shiftLeft(g[i]);
				for(int i=0;i<2;i++)
					turn_cw(g);
				break;
			}
			default:
				for(int i=0;i<1;i++)
					turn_cw(g);
				for(int i=0;i<4;i++)
					shiftLeft(g[i]);
				for(int i=0;i<3;i++)
					turn_cw(g);
				break;
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.printf("%d", g[i][j]);
				if(j==3) System.out.println();
				else System.out.print(" ");
			}
		}
	}
}
