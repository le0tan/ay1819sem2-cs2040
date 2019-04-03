import java.util.*;

// barebones implementation of BST

// Every vertex in this BST is a Java Class
class BSTVertex {
  BSTVertex(int v) { key = v; parent = left = right = null; height = 0; bf = 0; }
  // all these attributes remain public to slightly simplify the code
  public BSTVertex parent, left, right;
  public int key;
  public int height; // will be used in lecture on AVL
  public int bf; // the balance factor
}

// This is just a sample implementation
// There are other ways to implement BST concepts...
public class BST {
  public BSTVertex root;

  public BST() { root = null; }

  // public method called to search for a value v. 
  // Return v if it is found in the BST otherwise return -1.
  // Here the assumption is that -1 is never a valid key value.
  public int search(int v) {
    BSTVertex res = search(root, v);
    return res == null ? -1 : res.key;
  }

  // helper method to perform search
  private BSTVertex search(BSTVertex T, int v) {
         if (T == null)  return null;                     // not found
    else if (T.key == v) return T;                        // found
    else if (T.key < v)  return search(T.right, v);       // search to the right
    else                 return search(T.left, v);        // search to the left
  }
  
  // public method called to find Minimum key value in BST
  public int findMin() { return findMin(root); }

  // helper method to perform findMin
  // Question: What happens if BST is empty?
  private int findMin(BSTVertex T) {
    if (T.left == null) return T.key;                    // this is the min
    else                return findMin(T.left);           // go to the left
  }

  // public method called to find Maximum key value in BST
  public int findMax() { return findMax(root); }

  // helper method to perform findMax
  // Question: Again, what happens if BST is empty?
  private int findMax(BSTVertex T) {
    if (T.right == null) return T.key;                   // this is the max
    else                 return findMax(T.right);        // go to the right
  }

  // public method to find successor to given value v in BST.
  public int successor(int v) { 
    BSTVertex vPos = search(root, v);
    return vPos == null ? -1 : successor(vPos);
  }

  // helper recursive method to find successor to for a given vertex T in BST
  private int successor(BSTVertex T) {
    if (T.right != null)                       // this subtree has right subtree
      return findMin(T.right);  // the successor is the minimum of right subtree
    else {
      BSTVertex par = T.parent;
      BSTVertex cur = T;
      // if par(ent) is not root and cur(rent) is its right children
      while ((par != null) && (cur == par.right)) {
        cur = par;                                         // continue moving up
        par = cur.parent;
      }
      return par == null ? -1 : par.key;           // this is the successor of T
    }
  }

  // public method to find predecessor to given value v in BST
  public int predecessor(int v) { 
    BSTVertex vPos = search(root, v);
    return vPos == null ? -1 : predecessor(vPos);
  }

  // helper recursive method to find predecessor to for a given vertex T in BST
  private int predecessor(BSTVertex T) {
    if (T.left != null)                         // this subtree has left subtree
      return findMax(T.left);  // the predecessor is the maximum of left subtree
    else {
      BSTVertex par = T.parent;
      BSTVertex cur = T;
      // if par(ent) is not root and cur(rent) is its left children
      while ((par != null) && (cur == par.left)) { 
        cur = par;                                         // continue moving up
        par = cur.parent;
      }
      return par == null ? -1 : par.key;           // this is the successor of T
    }
  }

  // public method called to perform inorder traversal
  public void inorder() { 
    inorder(root);
    System.out.println();
  }

  // helper method to perform inorder traversal
  private void inorder(BSTVertex T) {
    if (T == null) return;
    inorder(T.left);                               // recursively go to the left
    System.out.printf(" (%d, H:%d, BF: %d)", T.key, T.height, T.bf);                      // visit this BST node
    inorder(T.right);                             // recursively go to the right
  }

  // public method called to insert a new key with value v into BST
  public void insert(int v) { 
    BSTVertex[] insertedVertex = new BSTVertex[1];
    root = insert(root, v, insertedVertex); 
    if(insertedVertex != null) {
      // check balance factor 
      BSTVertex i = insertedVertex[0];
      balance(i);
    } else {
      System.out.println("Error");
    }
  }
  
  // helper recursive method to perform insertion of new vertex into BST
  private BSTVertex insert(BSTVertex T, int v, BSTVertex[] inserted) {
    if (T == null) {
      inserted[0] = new BSTVertex(v);
      return inserted[0];          // insertion point is found
    }

    T.height++;
    if (T.key < v) {     
      T.bf--;                                 // search to the right
      T.right = insert(T.right, v, inserted);
      T.right.parent = T;
    }
    else {   
      T.bf++;                                              // search to the left
      T.left = insert(T.left, v, inserted);
      T.left.parent = T;
    }

    return T;                                          // return the updated BST
  }  

  private void balance(BSTVertex t) {
    // right[1] = whether the last vertex is on the right
    // right[0] = whether the last last vertex is on the right
    while(t != null) {
      System.out.println("asd");
      if(Math.abs(t.bf) >= 2) {
        System.out.printf("Rotate %d at bf %d\n", t.key, t.bf);
        rotate(t);
      }
      t = t.parent;
    }
  }

  private void rotate(BSTVertex t) {
    if(t.right != null && t.bf==-2 && t.right.bf <= 0 && t.right.bf >= -1) {
      rotateLeft(t);
    } else if(t.left != null && t.bf == 2 && t.left.bf >= 0 && t.left.bf <= 1) {
      rotateRight(t);
    } else if(t.right != null && t.bf == -2 && t.right.bf == 1) {
      rotateRight(t.right);
      rotateLeft(t);
    } else {
      rotateLeft(t.left);
      rotateRight(t);
    }
  }

  private void rotateLeft(BSTVertex t) {
    BSTVertex w = t.right;
    w.parent = t.parent;
    t.parent = w;
    t.right = w.left;
    if(w.left != null) {
      w.left.parent = t;
    }
    w.left = t;
    // if(t.right != null) t.right.left = t;
  }

  private void rotateRight(BSTVertex t) {
    BSTVertex w = t.left;
    w.parent = t.parent;
    t.parent = w;
    t.left = w.right;
    if(w.right != null) {
      w.right.parent = t;
    }
    w.right = t;
    // if(t.left != null) t.left.right = t;
  }



  // public method to delete a vertex containing key with value v from BST
  public void delete(int v) { root = delete(root, v); }

  // helper recursive method to perform deletion 
  private BSTVertex delete(BSTVertex T, int v) {
    if (T == null)  return T;              // cannot find the item to be deleted

    if (T.key < v)                                    // search to the right
      T.right = delete(T.right, v);
    else if (T.key > v)                               // search to the left
      T.left = delete(T.left, v);
    else {                                            // this is the node to be deleted
      if (T.left == null && T.right == null)                   // this is a leaf
        T = null;                                      // simply erase this node
      else if (T.left == null && T.right != null) {   // only one child at right        
        T.right.parent = T.parent;
        T = T.right;                                                 // bypass T        
      }
      else if (T.left != null && T.right == null) {    // only one child at left        
        T.left.parent = T.parent;
        T = T.left;                                                  // bypass T        
      }
      else {                                 // has two children, find successor
        int successorV = successor(v);
        T.key = successorV;         // replace this key with the successor's key
        T.right = delete(T.right, successorV);      // delete the old successorV
      }
    }
    
    return T;                                          // return the updated BST
  }

  // will be used in AVL lecture
  private int getHeight(BSTVertex T) {
    if (T == null) return -1;
    else return Math.max(getHeight(T.left), getHeight(T.right)) + 1;
  }

  public int getHeight() { return getHeight(root); }
  
  public int getRank(int v) {
    // implement this logic
    return 0;
  }
}
