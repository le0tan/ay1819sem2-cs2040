import java.util.*;

public class Main {
  private static class Pair {
    public int x;
    public int y;
    Pair(int x, int y) {
      this.x = x; this.y = y;
    }
  }
  public static long max(long x, long y) {
    return x>y?x:y;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    long[][] map = new long[r][c];
    List<Pair> colored = new ArrayList<>();
    Dictionary<Long, Long> d = new Hashtable<>();
    for(int i=0;i<r;i++) {
      for(int j=0;j<c;j++) {
        map[i][j] = sc.nextLong();
        if(map[i][j] == -1) {
          colored.add(new Pair(i,j));
          continue;
        }
        Long temp = d.get(map[i][j]);
        if(temp==null) {
          d.put(map[i][j], (long)1);
        } else {
          d.put(map[i][j], temp+1);
        }
      }
    }
    long ans = 0;
    int[] xx = {-1,1,0,0};
    int[] yy = {0,0,1,-1};
    for(int i=0;i<colored.size();i++) {
      int x = colored.get(i).x;
      int y = colored.get(i).y;
      for(int j=0;j<4;j++) {
        if(x+xx[j]>=r || y+yy[j]>=c || x+xx[j]<0 || y+yy[j]<0 || map[x+xx[j]][y+yy[j]]==-1) continue;
        long t = d.get(map[x+xx[j]][y+yy[j]])+1;
        if(t>ans) ans = t;
      }
    }
    System.out.println(ans);
  }
}
