package mylib;

public class tApp {
  public static void main(String[] args) {

    System.out.println("TESTING TREES");
    System.out.println();
    System.out.println("BST");
    int[] arr = {17, 8, 0, 12, 51, 3, 84, 4, 9};

    // Testing TNode overload constructor
    TNode nodeTest = new TNode(0, 0, null, null, null);

    // Testing default BST constructor
    BST bst = new BST();

    // Testing first BST overload constructor
    BST bstOverload1 = new BST(5);

    // Testing second BST overload constructor
    BST bstOverload2 = new BST(nodeTest);

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

    System.out.println("Insert 69 into BST:");
    bst.insert(69);
    bst.printBF();
    System.out.println();

    System.out.println("Delete 51 from BST:");
    bst.delete(51);
    bst.printBF();
    System.out.println();

    System.out.println("AVL");
    // Testing AVL default constructor
    AVL avlDefault = AVL();

    // Testing AVL first overload constructor
    AVL avlOverload1 = AVL(5);

    // Testing AVL overload constructor
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

    System.out.println("Insert value 14 into AVL Tree: ");
    avl.insert(14);
    avl.printBF();
    System.out.println();

    System.out.println("TESTING HEAPS");

    System.out.println("MAX HEAP");

    // Testing max heap constructors
    MaxH maxConstructor1 = new MaxH();
    MaxH maxConstructor2 = new MaxH(10);

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

    System.out.println("MIN HEAP");

    // Testing min heap constructors
    MinH minConstructor1 = new MinH();
    MinH minConstructor2 = new MinH(9);

    System.out.println("Min Heap Constructed from Array");
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
