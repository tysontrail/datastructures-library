package mylib;

/**
 * Hello world!
 *
 */
public class kApp 
{
    public static void main( String[] args )
    {
        // SLL ssl = new SLL();
        // ssl.insert(new DNode(1), 0);
        // ssl.insertHead(new DNode(88));
        // ssl.insertTail(new DNode(4));
        // ssl.insert(new DNode(5), 2);
        // //ssl.sortedInsert(new DNode(0));
        // ssl.print();
        // ssl.sort();
        // //ssl.insert(new DNode(3),1);
        // //ssl.print();
        // ssl.deleteHead();
        // ssl.print();

        DLL doublelist = new DLL();
        doublelist.insertHead(new DNode(5));
        doublelist.insertHead(new DNode(4));
        // doublelist.insert(new DNode(3), 1);
        // doublelist.insert(new DNode(10), 2);
        // doublelist.insert(new DNode(12), 3);
        doublelist.print();

    }
}
