import java.util.*;

public class Election {

	private void run() {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Candidate> candidates = new PriorityQueue<>(new CandidateComparator());
		int n = sc.nextInt();
		HashMap<String, Candidate> map = new HashMap<>(n);
		for(int i=0;i<n;i++) {
			Candidate can = new Candidate(sc.next(), sc.nextInt());
			candidates.add(can);
			map.put(can.name, can);
		}
		int k = sc.nextInt();
		for(int i=0;i<k;i++) {
			sc.next();
			int a = sc.nextInt();
			String b = sc.next();
			Candidate cur = map.get(b);
			candidates.remove(cur);
			cur.votes += a;
			candidates.add(cur);
			if(candidates.size() >= 2) {
				Candidate temp1 = candidates.poll();
				Candidate temp2 = candidates.poll();
				candidates.add(temp1);
				candidates.add(temp2);
				if(temp1.votes == temp2.votes) {
					System.out.printf("Tied at %d votes!\n", temp1.votes);
				} else {
					System.out.printf("%s is winning with %d votes!\n", candidates.peek().name, candidates.peek().votes);	
				}
			} else {
				System.out.printf("%s is winning with %d votes!\n", candidates.peek().name, candidates.peek().votes);
			}
		}
	}

	public static void main(String[] args) {
		Election e = new Election();
		e.run();
	}
}

class Candidate {
	String name;
	int votes;
	public Candidate(String a, int b) {
		this.name = a;
		this.votes = b;
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Candidate)) return false;
		Candidate c = (Candidate) o;
		return this.name.equals(c.name) && this.votes == c.votes;
	}
}

class CandidateComparator implements Comparator<Candidate> {
	public int compare(Candidate a, Candidate b) {
		return b.votes - a.votes;
	}
	public boolean equals(Object o) {
		return this==o;
	}
}