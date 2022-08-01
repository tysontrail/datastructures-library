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
        // ssl.insert(new DNode(5), 3);
        // //ssl.sortedInsert(new DNode(0));
        // ssl.print();
        // ssl.sort();
        // //ssl.insert(new DNode(3),1);
        // //ssl.print();
        // ssl.delete(88);
        // ssl.print();

        DLL list= new DLL();
        list.insertHead(new DNode(33));
        list.insert(new DNode(3), 1);
        list.insert(new DNode(10), 1);
        list.print();
        list.delete(10);
        // doublelist.insert(new DNode(12), 3);
        list.print();
        list.clear();
        list.print();

    }
}
