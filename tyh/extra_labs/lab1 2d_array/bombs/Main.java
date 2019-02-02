import java.util.*;

/**
 * Main
 */
public class Main {
    private static class Point {
        public int x;
        public int y;

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    private static class Pair<E> {
        E a;
        E b;

        Pair(E x, E y) {
            a = x;
            b = y;
        }
    }

    private static int targets(int[][] grid, Point ul, Point br) {
        int cnt = 0;
        for (int i = ul.x; i <= br.x; i++) {
            for (int j = ul.y; j <= br.y; j++) {
                if (grid[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }

    private static Pair<Point> range(int n, Point center, int size) {
        int a = center.x - (size - 1) / 2;
        int b = center.y - (size - 1) / 2;
        int c = center.x + (size - 1) / 2;
        int d = center.y + (size - 1) / 2;
        return new Pair<Point>(new Point(Math.max(0, a), Math.max(0, b)),
                new Point(Math.min(c, n - 1), Math.min(d, n - 1)));
    }

    private static int score(int[][] grid, Point ul, Point br) {
        int sc = 0;
        for (int i = ul.x; i <= br.x; i++)
            for (int j = ul.y; j <= br.y; j++)
                if (grid[i][j] == 1)
                    sc = sc + 3;
                else
                    sc = sc - 1;
        return sc;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pair<Point> p = new Pair<Point>(new Point(1, 2), new Point(2, 3));

    }
}