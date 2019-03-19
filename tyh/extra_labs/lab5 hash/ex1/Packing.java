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
	public int value;
	public int size;

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
			items.add(new Item(sc.nextInt(), sc.nextInt()));
		}

		//implement the selection procedures recursively
		List<Item> ans = select(items, new ArrayList<Item>(), size);
		System.out.printf("%d %d\n", totalSize(ans), totalValue(ans));
		sc.close();
	}

	//description:
	//precondition:
	//You can change the signature of this method if you want, but you have to use recursion. 
	public static ArrayList<Item> select(ArrayList<Item> remaining, 
			ArrayList<Item> selected, int remainingSpace) {
//		System.out.printf("%d %d\n",remaining.size(), selected.size());
		if(remainingSpace<=0) return selected;
		ArrayList<Item> res = selected;
		int maxvalue = totalValue(res);

		for(Item i: remaining) {
			if(i.size <= remainingSpace) {
				ArrayList<Item> temp = new ArrayList<>();
				for(Item j: remaining) {
					if(j!=i) temp.add(j);
				}
				ArrayList<Item> newSel = Packing.copy(selected);
				newSel.add(i);
				ArrayList<Item> temp2 = select(temp,newSel,remainingSpace-i.size);
				int t = totalValue(temp2);
				if(t > maxvalue) {
					maxvalue = t;
					res = temp2;
				}
			}
		}
		return res;
	}

	public static int totalValue(List<Item> list) {
		int value = 0;
		for(Item i: list) {
			value += i.value;
		}
		return value;
	}

	public static int totalSize(List<Item> list) {
		int size = 0;
		for(Item i:list) {
			size += i.size;
		}
		return size;
	}

	//this method makes a copy of an existing Arraylist
	public static ArrayList<Item> copy(ArrayList<Item> arrlist) {
		return new ArrayList<Item>(arrlist);
	}

	//add other methods if you need

}

