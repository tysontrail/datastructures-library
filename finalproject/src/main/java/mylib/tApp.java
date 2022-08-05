package mylib;

public class tApp {
  public static void main(String[] args) {

    // TREES

    // Create array
    int[] arr = {
      16, 14, 20, 4, 15, 19, 29, 3, 8, 17, 21, 30, 2, 5, 11, 18, 22, 31, 1, 7, 9, 12, 23, 6, 10, 13,
      27, 25, 28, 24, 26
    };

    // Create binary tree object
    BST bst = new BST();

    // Insert array into BST
    for (int i = 0; i < arr.length; i++) {
      bst.insert(arr[i]);
    }

    // Search value in tree
    System.out.println();
    TNode searchValue = bst.search(3);
    System.out.println("Returned BST search value: " + searchValue.getData());

    // Print BST tree in order to terminal
    System.out.println("BST tree in order: ");
    bst.printInOrder(bst.getRoot());
    System.out.println();

    // Print BST tree in breadth-first left-right traversal to file
    System.out.println("BST tree in breadth-first:");
    bst.printBF();
    System.out.println();

    // Create an AVL tree object from bst
    AVL avl = new AVL(bst.getRoot());

    // Print AVL tree in order to terminal
    System.out.println();
    System.out.println("AVL tree in order: ");
    avl.printInOrder(avl.getRoot());
    System.out.println();

    // Print AVL tree in breadth-first left-right traversal to file
    System.out.println("AVL tree in breadth-first:");
    avl.printBF();
    System.out.println();

    // Search value in AVL tree
    searchValue = avl.search(3);
    System.out.println("Returned AVL search value: " + searchValue.getData());

    // Delete value from tree
    bst.delete(3);

    // HEAPS

  }
}
