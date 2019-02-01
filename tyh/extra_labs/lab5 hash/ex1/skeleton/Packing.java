// CS1020 (AY2014/5 Semester 2)
// Take-home Lab5 Ex1
// Name:
// Matric. No.:
// Lab group:
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Marks will be awarded for this in sit-in labs.
// Please remove this line and its preceding 3 lines.

import java.util.*;

class Item{
	private int value;
	private int size;

	public Item(int size,int value) {
		this.value=value;
		this.size=size;
	}

	//add additional methods only if you need
}

public class Packing {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Item> items = new ArrayList<Item>();

		//read in the data
		int size = sc.nextInt();

		while (sc.hasNext()) {

		}

		//implement the selection procedures recursively

		sc.close();
	}

	//description:
	//precondition:
	//You can change the signature of this method if you want, but you have to use recursion. 
	public static ArrayList<Item> select(ArrayList<Item> remaining, 
			ArrayList<Item> selected, int remainingSpace) {


	}

	//this method makes a copy of an existing Arraylist
	public static ArrayList<Item> copy(ArrayList<Item> arrlist) {
		return new ArrayList<Item>(arrlist);

	}

	//add other methods if you need

}

