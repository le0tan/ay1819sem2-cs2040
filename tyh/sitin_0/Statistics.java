import java.util.*;
public class Statistics {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long sum = 0;
		for(int i=0;i<n;i++) {
			sum += sc.nextLong();
		}
		System.out.printf("Sum: %d\n", sum);
		System.out.printf("Average: %.2f\n", (double)sum/n);

	}

	public static void main(String[] args) {
		Statistics s = new Statistics();
		s.run();
	}
}
