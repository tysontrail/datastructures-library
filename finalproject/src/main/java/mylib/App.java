package mylib;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("\n********** MODULE 1: LINEAR DATA STRUCTURES ********** \n");
        System.out.println("\n****** SINGLY LINKED LIST ******\n");
        SLL ssl = new SLL();
        //Insertion methods tests
        ssl.insert(new DNode(1), 0);
        ssl.insertHead(new DNode(88));
        ssl.insertTail(new DNode(4));
        ssl.insert(new DNode(15), 3);

        System.out.println("The list:");
        ssl.print();

        //Sort method test
        ssl.sort();
        System.out.println("\nThe sorted list: ");
        ssl.print();

        //Sorted insert test
        ssl.sortedInsert(new DNode(0));
        System.out.println("\nSorted insert of value 0");
        ssl.print();

        //is Sorted flag check
        ssl.insertHead(new DNode(45));
        System.out.println("\nIs sorted flag test");
        ssl.print();

        //Delete method tests
        System.out.println("\nDeleted Data 15");
        ssl.delete(15);
        ssl.print();
        System.out.println("\nDeleted Tail");
        ssl.deleteTail();
        ssl.print();
        System.out.println("\nDeleted Head");
        ssl.deleteHead();
        ssl.print();
        System.out.println("\nDelete element not in list test: ");
        ssl.delete(100);

        System.out.println("\nSearch");
        System.out.println("Search for 4: ");
        System.out.println(ssl.search(11));
        System.out.println("Search for 45: ");
        System.out.println(ssl.search(45));

        System.out.println("\nClear");
        ssl.clear();
        ssl.print();

        System.out.println("\n****** DOUBLY LINKED LIST ****** \n");
        DLL dll= new DLL();

        //Insertion methods tests
        dll.insert(new DNode(1), 0);
        dll.insertHead(new DNode(88));
        dll.insertTail(new DNode(4));
        dll.insert(new DNode(15), 3);

        System.out.println("The list:");
        dll.print();

        dll.sort();
        System.out.println("\nThe sorted list: ");
        dll.print();


        //Sorted insert test
        dll.sortedInsert(new DNode(0));
        System.out.println("\nSorted insert of value 0");
        dll.print();

        //is Sorted flag check
        dll.insertHead(new DNode(45));
        System.out.println("\nIs sorted flag test");
        dll.print();

        //Delete method tests
        System.out.println("\nDeleted Data 15");
        dll.delete(15);
        dll.print();
        System.out.println("\nDeleted Tail");
        dll.deleteTail();
        dll.print();
        System.out.println("\nDeleted Head");
        dll.deleteHead();
        dll.print();
        System.out.println("\nDelete element not in list test: ");
        dll.delete(100);

        System.out.println("\nSearch");
        System.out.println("Search for 4: ");
        System.out.println(dll.search(4));
        System.out.println("Search for 45: ");
        System.out.println(dll.search(45));

        System.out.println("\nClear");
        dll.clear();
        dll.print();

        System.out.println("\n****** CIRCULAR SINGLY LINKED LIST ******\n");
        CSLL csll = new CSLL();

        //INSERTION METHODS
        csll.insertTail(new DNode(16));
        csll.insertTail(new DNode(55));
        csll.insertTail(new DNode(15));
        csll.insert(new DNode(17), 2);

        System.out.println("The list:");
        csll.print();

        //SORT METHOD
        csll.sort();
        System.out.println("\nThe sorted list: ");
        csll.print();

        //is Sorted flag check
        csll.insertHead(new DNode(45));
        System.out.println("\nIs sorted flag test");
        csll.print();

        //Sorted insert test
        csll.sortedInsert(new DNode(32));
        System.out.println("\nSorted insert of value 11");
        csll.print();

        //SEARCH METHODS
        System.out.println("\nSearch");
        System.out.println("Search for 5: ");
        System.out.println(csll.search(5));
        System.out.println("Search for 45: ");
        System.out.println(csll.search(45));
        
        //DELETION METHODS
        System.out.println("\nDelete tail");
        csll.deleteTail();
        csll.print();
        System.out.println("\nDelete head");
        csll.deleteHead();
        csll.print();
        System.out.println("\nDelete 32");
        csll.delete(32);
        csll.print();
        System.out.println("\nTry to delete element not in list:");
        csll.delete(56);
        csll.print();

        System.out.println("\nClear");
        csll.clear();
        csll.print();

        System.out.println("\n****** CIRCULAR DOUBLY LINKED LIST ****** \n");
        CDLL cdll = new CDLL();

        //INSERTION METHODS
        cdll.insertTail(new DNode(16));
        cdll.insertTail(new DNode(55));
        cdll.insertTail(new DNode(15));
        cdll.insert(new DNode(17), 2);

        System.out.println("The list:");
        cdll.print();

        //SORT METHOD
        cdll.sort();
        System.out.println("\nThe sorted list: ");
        cdll.print();

        //is Sorted flag check
        cdll.insertHead(new DNode(45));
        System.out.println("\nIs sorted flag test");
        cdll.print();

        //Sorted insert test
        cdll.sortedInsert(new DNode(32));
        System.out.println("\nSorted insert of value 32");
        cdll.print();

        //SEARCH METHODS
        System.out.println("\nSearch");
        System.out.println("Search for 5: ");
        System.out.println(cdll.search(5));
        System.out.println("Search for 45: ");
        System.out.println(cdll.search(45));
        
        //DELETION METHODS
        System.out.println("\nDelete tail");
        cdll.deleteTail();
        cdll.print();
        System.out.println("\nDelete head");
        cdll.deleteHead();
        cdll.print();
        System.out.println("\nDelete 16");
        cdll.delete(16);
        cdll.print();
        System.out.println("\nTry to delete element not in list:");
        cdll.delete(56);
        cdll.print();

        System.out.println("\nClear");
        cdll.clear();
        cdll.print();

        System.out.println("\n****** STACKS ****** \n");
        Stack stack = new Stack();

        System.out.println("Push");
        stack.push(new DNode(2));
        stack.push(new DNode(5));
        stack.push(new DNode(15));
        stack.push(new DNode(91));
        stack.print();

        System.out.println("\nPop");
        stack.pop();
        stack.print();
        System.out.println();
        stack.pop();
        stack.print();

        System.out.println("\nPeek");
        System.out.println(stack.peek());

        System.out.println("\nSearch for Value: 2s position");
        System.out.println(stack.searchStack(2));

        System.out.println("\nCheck if stack is empty");
        System.out.println(stack.isEmpty());

        System.out.println("\nClear");
        stack.clear();
        stack.print();

        System.out.println("\nRecheck if stack is empty");
        System.out.println(stack.isEmpty());

        System.out.println("\n****** QUEUES ******\n");
        QueueLL queue = new QueueLL();

        System.out.println("Enqueue");
        queue.enqueue(new DNode(3));
        queue.enqueue(new DNode(11));
        queue.enqueue(new DNode(7));
        queue.enqueue(new DNode(64));
        queue.enqueue(new DNode(1));
        queue.print();

        System.out.println("\nDequeue");
        queue.dequeue();
        queue.print();
        
        System.out.println("\nPeek");
        System.out.println(queue.peek());

        System.out.println("\nSearch for Value: 7s position");
        System.out.println(queue.searchQueue(7));

        System.out.println("\nCheck if stack is empty");
        System.out.println(queue.isEmpty());

        System.out.println("\nClear");
        queue.clear();
        queue.print();

        System.out.println("\nRecheck if queue is empty");
        System.out.println(queue.isEmpty());

        System.out.println("\n********** MODULE 2: BINARY & AVL TREES ********** \n");

        System.out.println("****** BST ******");
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
    
        System.out.println("\nBST tree in breadth-first:");
        bst.printBF();
    
        System.out.println("\nInsert 69 into BST:");
        bst.insert(69);
        bst.printBF();
    
        System.out.println("\nDelete 51 from BST:");
        bst.delete(51);
        bst.printBF();
    
        System.out.println("\n****** AVL ******");
        // Testing AVL default constructor
        AVL avlDefault = new AVL();
    
        // Testing AVL first overload constructor
        AVL avlOverload1 = new AVL(5);
    
        // Testing AVL overload constructor
        AVL avl = new AVL(bst.getRoot());
    
        System.out.println("\nAVL tree in order: ");
        avl.printInOrder(avl.getRoot());
    
        System.out.println("\nAVL tree in breadth-first:");
        avl.printBF();
    
        searchValue = avl.search(3);
        System.out.println("\nReturned AVL search value: " + searchValue.getData());
    
        System.out.println("\nInsert value 14 into AVL Tree: ");
        avl.insert(14);
        avl.printBF();
    
        System.out.println("\n********** MODULE 3: HEAPS **********");
    
        System.out.println("\n****** MAX HEAP ******");
    
        // Testing max heap constructors
        MaxH maxConstructor1 = new MaxH();
        MaxH maxConstructor2 = new MaxH(10);
    
        System.out.println("\nMax Heap Constructed from Array");
        MaxH maxH = new MaxH(arr);
        maxH.print();
    
        System.out.println("\nSorted Max Heap");
        maxH.sort();
        maxH.print();
    
        System.out.println("\nDeleting 31");
        maxH.delete(31);
        maxH.print();
    
        System.out.println("\nInserting 25");
        maxH.insert(25);
        maxH.print();
    
        System.out.println("\nResorting");
        maxH.sort();
        maxH.print();
    
        System.out.println("\n****** MIN HEAP ******");
    
        // Testing min heap constructors
        MinH minConstructor1 = new MinH();
        MinH minConstructor2 = new MinH(9);
    
        System.out.println("\nMin Heap Constructed from Array");
        MinH minH = new MinH(arr);
        minH.print();
    
        System.out.println("\nSorted Heap");
        minH.sort();
        minH.print();
    
        System.out.println("\nDeleting 31");
        minH.delete(31);
        minH.print();
    
        System.out.println("\nInserting 25");
        minH.insert(25);
        minH.print();
    
        System.out.println("\nResorting");
        minH.sort();
        minH.print();
    }
}
