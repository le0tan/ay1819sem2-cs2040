/**
 * Name         :
 * Matric. No   :
 * PLab Acct.   :
 */

import java.util.*;

public class Ranking {
	private void run() {
		//implement your "main" method here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Student> students = new ArrayList<>();
		List<Student> original = new ArrayList<>();
		for(int i=0;i<n;i++) {
			students.add(new Student(sc.next(), sc.nextInt()));
//			sc.next();
		}
		original.addAll(students);
		Collections.sort(students);
		long lastScore = students.get(0).score;
		int lastRank = 1;
		for(int i=0;i<n;i++) {
			Student cur = students.get(i);
			if(cur.score == lastScore) 
				cur.setRank(lastRank);
			else {
				lastScore = cur.score;
				lastRank = i+1;
				cur.setRank(lastRank);
			}
		}
		for(Student s: original) {
			System.out.println(s.name+" "+s.rank);
		}
	}

	public static void main(String[] args) {
		Ranking r = new Ranking();
		r.run();
	}
}

class Student implements Comparable<Student> {
	String name;
	long score;
	int rank;

	public Student(String a, long b) {
		name=a;
		score=b;
	}

	public void setRank(int i) {
		rank=i;
	}

	@Override
	public int compareTo(Student o) {
		return score==o.score ? 0 : score>o.score ? -1 : 1;
	}
}
