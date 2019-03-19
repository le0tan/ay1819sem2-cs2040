// CS1020 (AY2014/5 Semester 2)
// Take-home Lab5 Ex2
// Name:
// Matric. No.:
// Lab group:
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Marks will be awarded for this in sit-in labs.
// Please remove this line and its preceding 3 lines.

import java.util.Scanner;

public class ObstacleCourse {

	/**
	 * Description:
	 *   ???
	 * Pre-condition(s):
	 *   ???
	 */
	public static int countHops(Block[] blocks, int currIndex) {

		// TODO

		//
		// Note: You should use inline comments where appropriate to explain
		// your algorithm.
		//
		
		if(currIndex >= blocks.length-1) {
			return 0;
		}
		int minHops = countHops(blocks, currIndex+1); // jump to the adjacent one
		for(int i=1;currIndex+i < blocks.length;i++) {
			if(blocks[currIndex+i].getHeight() > blocks[currIndex].getHoppingRange()) break;
			int next = countHops(blocks, currIndex+i);
			minHops = Math.min(minHops, next);
		}	
		return minHops+1;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Block[] blocks = new Block[n];
		for (int i = 0; i < n; i++) {
			blocks[i] = new Block(sc.nextInt(), sc.nextInt());
		}
		System.out.println(countHops(blocks, 0));
	}

}

class Block {

	private int height;
	private int hoppingRange;

	public Block(int height, int hoppingRange) {
		this.height = height;
		this.hoppingRange = hoppingRange;
	}

	public int getHeight() {
		return this.height;
	}

	public int getHoppingRange() {
		return this.hoppingRange;
	}

}

