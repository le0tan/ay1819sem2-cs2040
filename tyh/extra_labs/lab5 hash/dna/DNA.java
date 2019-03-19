/**
 *	Name	  :
 *	Matric no.:
 */

import java.util.*;

public class DNA {
    
    // attributes
		HashMap<String, Integer> map;
		int N;
		int K;
    
    public void run() {
        // declare the necessary variables
        
        // declare a Scanner object to read input
        Scanner sc = new Scanner(System.in);
        // read input and process them accordingly
				N = sc.nextInt();
				K = sc.nextInt();
				generate(sc.next());
				int loop = sc.nextInt();
				for(int i=0;i<loop;i++) {
					System.out.println(count(sc.next()));
				}
    }
    
    /**
     *	generate		: use this method to generate/pre-process the substrings of length K from DNA
     *	Pre-condition	:
     *	Post-condition	:
     */
    public void generate(String dna) {
        // implementation
				map = new HashMap<>();
				for(int i=0;i<=dna.length()-K;i++) {
					String cur = dna.substring(i,i+K);
					if(map.get(cur) != null) {
						map.put(cur, map.get(cur)+1);
					} else {
						map.put(cur, 1);
					}
				}
    }
    
    /**
     *	count			: use this method to answer one query.
     *	Pre-condition	:
     *	Post-condition	:
     */
    public int count(String substring) {
        // implementation
				Integer res = map.get(substring);
        return res == null ? 0 : res;
    }

    public static void main(String[] args) {
        DNA dna = new DNA();
        dna.run();
    }
}
