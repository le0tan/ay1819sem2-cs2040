import java.util.*;

public class Sequences {
	private void generateArithmeticSeq(long a, long d, int terms) {
        for(int i = 0; i < terms; i++, a+=d) {
            System.out.print(a);
            if(i < terms - 1) System.out.print(" ");
            else System.out.println();
        }
    }
    private void generateGeometricSeq(long a, long r, int terms) {
        for(int i = 0; i < terms; i++, a*=r) {
             System.out.print(a);
             if(i < terms - 1) System.out.print(" ");
             else System.out.println();
        }
    }

    private void run() {
        Scanner in = new Scanner(System.in);
	    int terms = in.nextInt();
        int type = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        if(type == 1) {
            generateArithmeticSeq(a, b, terms);
        } else {
            generateGeometricSeq(a, b, terms);
        }
    }

	public static void main(String[] args) {
		Sequences newSequences = new Sequences();
		newSequences.run();
	}
}
