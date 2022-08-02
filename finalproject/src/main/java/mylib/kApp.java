package mylib;

/**
 * Hello world!
 *
 */
public class kApp 
{
    public static void main( String[] args )
    {
        System.out.println("\n******** SINGLY LINKED LIST ********\n");
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
        ssl.sortedInsert(new DNode(11));
        System.out.println("\nSorted insert of value 11");
        ssl.print();

        //is Sorted flag check
        ssl.insertHead(new DNode(45));
        System.out.println("\nIs sorted flag test");
        ssl.print();

        //Delete method tests
        System.out.println("\nDelete method tests");
        ssl.delete(88);
        ssl.deleteTail();
        ssl.deleteHead();
        ssl.print();

        System.out.println("\nSearch");
        System.out.println("Search for 4: ");
        System.out.println(ssl.search(4));
        System.out.println("Search for 45: ");
        System.out.println(ssl.search(45));

        System.out.println("\nClear");
        ssl.clear();
        ssl.print();

        System.out.println("\n****** DOUBLY LINKED LIST ******** \n");
        DLL dll= new DLL();

        //Insertion methods tests
        dll.insert(new DNode(1), 0);
        dll.insertHead(new DNode(88));
        dll.insertTail(new DNode(4));
        dll.insert(new DNode(15), 3);

        System.out.println("The list:");
        dll.print();

        //Sort method test CHECK ABOUT EXTENDING OR IF IT'S JUST EASIER TO COPY METHODS OVER. METHODS MISSING FROM DLL ARE SEARCH, SORT/sortedinserted, CLEAR, issorted
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
        dll.delete(88);
        dll.deleteTail();
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

    }
}
