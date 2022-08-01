package mylib;

/**
 * Hello world!
 *
 */
public class kApp 
{
    public static void main( String[] args )
    {
        SLL ssl = new SLL();
        ssl.insert(new DNode(1), 0);
        ssl.insert(new DNode(88), 1);
        ssl.insert(new DNode(4), 2);
        ssl.insert(new DNode(5), 3);
        ssl.sortedInsert(new DNode(0));
        //ssl.insert(new DNode(3),1);
        //ssl.printList();

        
        //ssl.deleteTail();
        ssl.printList();

    }
}
