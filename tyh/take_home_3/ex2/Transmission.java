/*
 * Name       : 
 * Matric No. :
 * Plab Acct. :
 */
import java.util.*;

public class Transmission {
    private void run() {
        //implement your "main" method here
				Scanner sc = new Scanner(System.in);
				// store # of cats that are sleeping
				// transmit(x,y) is to query whether there are # in range [x,y]
				int n=sc.nextInt();
				int q=sc.nextInt();
				TreeSet<Integer> set = new TreeSet<>();
				for(int i=0;i<q;i++) {
					String cmd = sc.next();
					switch(cmd) {
						case "TRANSMIT":
							int x = sc.nextInt(); int y = sc.nextInt();
							Integer t = set.ceiling(x);
							if(t==null ? true : t>y) System.out.println("YES");
							else System.out.println("NO");
							break;
						case "SLEEP":
							set.add(sc.nextInt());
							break;
						case "WAKE":
							set.remove(sc.nextInt());
							break;
						default:
							break;
					}
				}
    }
    public static void main(String[] args) {
        Transmission newTransmission = new Transmission();
        newTransmission.run();
    }
}
