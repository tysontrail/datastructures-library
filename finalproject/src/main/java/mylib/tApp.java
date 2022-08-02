package mylib;

import mylib.datastructures.trees.BST;

public class tApp {
  public static void main(String[] args) {

    // Create array
    int[] arr = {
      16, 14, 4, 8, 11, 20, 29, 19, 21, 22, 23, 9, 12, 3, 2, 30, 1, 10, 17, 5, 13, 15, 27, 28, 7,
      25, 31, 24, 26, 18, 6
    };

    // Create binary tree object
    BST bst = new BST();

    // Insert array into BST
    for (int i = 0; i < arr.length; i++) {
      bst.insert(arr[i]);
    }

    // Print BST tree in order to terminal
    System.out.println("BST tree in order: ");
    bst.printInOrder(bst.getRoot());
    System.out.println();

    // Print BST tree in breadth-first left-right traversal to file
    System.out.println("BST tree in breadth-first:");
    bst.printBF();
    System.out.println();
  }
}
