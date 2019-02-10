/**
 * Name         :YAN GUANYU
 * Matric. No   :A0177888Y
 * PLab Acct.   :
 */

import java.util.*;

public class Ballpassing {
    private void run() {
		//implement your "main" method here
        int N, Q;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  sc.nextLine();
        String [] people = sc.nextLine().split(" ");
        List<String>names = new LinkedList<>();
        for (int i = 0; i < N; i++){names.add(people[i]);}
        Q = sc.nextInt(); sc.nextLine();
        int index = 0;
        for (int i = 0; i < Q; i++){
            String[] event = sc.nextLine().split(" ");
            if (event[0].equals("NEXT")){
                index += 1; index %= N;
                System.out.println(names.get(index));
            }
            else if (event[0].equals("JOIN")){
                N++;
                if (index < N - 1){names.add(index + 1,event[1]);}
                else names.add(event[1]);
                index++; index %= N; 
                System.out.println(names.get(index));
            }
            else{
                N--; names.remove(index);
                index %= N;
                System.out.println(names.get(index));
                }
        }
    }
	public static void main(String[] args) {
		Ballpassing newBallpassing = new Ballpassing();
		newBallpassing.run();
	}
}
