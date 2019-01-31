import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] g = new int[n][n];
    int x = 0;
    int y = (n-1)/2;
    for(int i=1;i<=n*n;i++) {
      g[x][y] = i;
      if(i==n*n) break;
      int nx = (x-1+n)%n;
      int ny = (y+1)%n;
      if(g[nx][ny]!=0) {
        nx = (x+1)%n;
        ny = y;
      }
      x = nx; y = ny;
    }
    for(int i=0;i<n;i++) {
      for(int j=0;j<n;j++) {
        if(j==n-1) System.out.println(g[i][j]);
        else System.out.printf("%d ",g[i][j]);
      }
    }
  }
}
