package mylib;

/**
 * Circular Singly Linked Lists
 *
 */
public class CSLL extends SLL
{
    private DNode head;
    private int size;

    public CSLL() {
        this.head.setNext(this.head);
        this.size = super.getSize();
    }

    public CSLL(DNode head) {
        this.head = head;
        this.size = super.getSize();
    }
    //circular linked lists
    
}
