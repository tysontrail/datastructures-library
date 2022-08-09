package mylib;

/**
 * Hello world!
 *
 */
public class kApp 
{
    public static void main( String[] args )
    {
        // System.out.println("\n******** SINGLY LINKED LIST ********\n");
        // SLL ssl = new SLL();
        // //Insertion methods tests
        // ssl.insert(new DNode(1), 0);
        // ssl.insertHead(new DNode(88));
        // ssl.insertTail(new DNode(4));
        // ssl.insert(new DNode(15), 3);

        // System.out.println("The list:");
        // ssl.print();

        // //Sort method test
        // ssl.sort();
        // System.out.println("\nThe sorted list: ");
        // ssl.print();

        // //Sorted insert test
        // ssl.sortedInsert(new DNode(11));
        // System.out.println("\nSorted insert of value 11");
        // ssl.print();

        // //is Sorted flag check
        // ssl.insertHead(new DNode(45));
        // System.out.println("\nIs sorted flag test");
        // ssl.print();

        // //Delete method tests
        // System.out.println("\nDelete method tests");
        // ssl.delete(88);
        // ssl.deleteTail();
        // ssl.deleteHead();
        // ssl.delete(34);
        // ssl.print();

        // System.out.println("\nSearch");
        // System.out.println("Search for 4: ");
        // System.out.println(ssl.search(11));
        // System.out.println("Search for 45: ");
        // System.out.println(ssl.search(45));

        // System.out.println("\nClear");
        // ssl.clear();
        // ssl.print();

        System.out.println("\n****** DOUBLY LINKED LIST ******** \n");
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
        dll.sortedInsert(new DNode(11));
        System.out.println("\nSorted insert of value 11");
        dll.print();

        //is Sorted flag check
        dll.insertHead(new DNode(45));
        System.out.println("\nIs sorted flag test");
        dll.print();

        //Delete method tests
        System.out.println("\nDelete method tests");
        System.out.println("\nDeleted Data 11");
        dll.delete(11);
        dll.print();
        System.out.println("\nDeleted Tail");
        dll.deleteTail();
        dll.print();
        System.out.println("\nDeleted Head");
        dll.deleteHead();
        dll.print();

        System.out.println("\nSearch");
        System.out.println("Search for 4: ");
        System.out.println(dll.search(4));
        System.out.println("Search for 45: ");
        System.out.println(dll.search(45));

        System.out.println("\nClear");
        dll.clear();
        dll.print();

        System.out.println("\n****** CIRCULAR SINGLY LINKED LIST ******** \n");
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
        System.out.println("\nDelete method tests");
        //ssl.delete(88);
        System.out.println("\nDelete tail");
        csll.deleteTail();
        csll.print();
        System.out.println("\nDelete head");
        csll.deleteHead();
        csll.print();
        System.out.println("\nDelete 16 \n");
        csll.delete(32);
        csll.print();
        System.out.println("\nTry to delete element not in list:");
        csll.delete(56);
        csll.print();

        System.out.println("\nClear");
        csll.clear();
        csll.print();

        System.out.println("\n****** CIRCULAR DOUBLY LINKED LIST ******** \n");
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

        System.out.println("\nThe sorted list: ");

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
        System.out.println("\nDelete method tests");
        //ssl.delete(88);
        System.out.println("\nDelete tail");
        cdll.deleteTail();
        cdll.print();
        System.out.println("\nDelete head");
        cdll.deleteHead();
        cdll.print();
        System.out.println("\nDelete 16 \n");
        cdll.delete(16);
        cdll.print();
        System.out.println("\nTry to delete element not in list:");
        cdll.delete(56);
        cdll.print();

        System.out.println("\nClear");
        cdll.clear();
        cdll.print();

        System.out.println("\n****** STACKS ******** \n");
        Stack stack = new Stack();

        System.out.println("Push \n");
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

        System.out.println("\n******* QUEUES ******** \n");
        QueueLL queue = new QueueLL();

        System.out.println("Enqueue \n");
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
     }
}
