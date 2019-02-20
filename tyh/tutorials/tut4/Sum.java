public class Sum {
	private static int sum(int n) {
		if(n==1) {
			System.out.println("Sum(1) = 1");
			return 1;
		} else {
			System.out.printf("Sum(%d) = %d + Sum(%d)\n", n, n, n-1);
			return n + sum(n-1);
		}
	}
	public static void main(String[] args) {
		sum(4);
	}
}
