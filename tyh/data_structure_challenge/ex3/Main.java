/**
 * Main
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BST bst = new BST();
        for(int i=0;i<n;i++) {
            bst.insert(sc.nextInt());
        }
        bst.inorder();
    }
}