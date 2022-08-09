package mylib;

public class tApp {
  public static void main(String[] args) {

    System.out.println("TESTING TREES");

    int[] arr = {17, 8, 0, 12, 51, 3, 84, 4, 9};

    BST bst = new BST();

    // Insert array into BST
    for (int i = 0; i < arr.length; i++) {
      bst.insert(arr[i]);
    }

    System.out.println();
    TNode searchValue = bst.search(3);
    System.out.println("Returned BST search value: " + searchValue.getData());

    System.out.println("BST tree in order: ");
    bst.printInOrder(bst.getRoot());
    System.out.println();

    System.out.println("BST tree in breadth-first:");
    bst.printBF();
    System.out.println();

    AVL avl = new AVL(bst.getRoot());

    System.out.println();
    System.out.println("AVL tree in order: ");
    avl.printInOrder(avl.getRoot());
    System.out.println();

    System.out.println("AVL tree in breadth-first:");
    avl.printBF();
    System.out.println();

    searchValue = avl.search(3);
    System.out.println("Returned AVL search value: " + searchValue.getData());

    System.out.println("Delete value 3 from tree");
    bst.delete(3);
    System.out.println();

    System.out.println("TESTING HEAPS");

    MaxH maxConstructor1 = new MaxH();
    MaxH maxConstructor2 = new MaxH(10);

    System.out.println("MAX HEAP");
    System.out.println("Max Heap Constructed from Array");
    MaxH maxH = new MaxH(arr);
    maxH.print();
    System.out.println();

    System.out.println("Sorted Max Heap");
    maxH.sort();
    maxH.print();
    System.out.println();

    System.out.println("Deleting 31");
    maxH.delete(31);
    maxH.print();
    System.out.println();

    System.out.println("Inserting 25");
    maxH.insert(25);
    maxH.print();
    System.out.println();

    System.out.println("Resorting");
    maxH.sort();
    maxH.print();
    System.out.println();

    MinH minConstructor1 = new MinH();
    MinH minConstructor2 = new MinH(9);

    System.out.println("MIN HEAP");
    System.out.println("Constructed from Array");
    MinH minH = new MinH(arr);
    minH.print();
    System.out.println();

    System.out.println("Sorted Heap");
    minH.sort();
    minH.print();
    System.out.println();

    System.out.println("Deleting 31");
    minH.delete(31);
    minH.print();
    System.out.println();

    System.out.println("Inserting 25");
    minH.insert(25);
    minH.print();
    System.out.println();

    System.out.println("Resorting");
    minH.sort();
    minH.print();
    System.out.println();
  }
}
