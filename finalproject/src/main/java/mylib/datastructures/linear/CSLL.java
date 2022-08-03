package mylib;

/**
 * Circular Singly Linked Lists
 *
 */
public class CSLL extends SLL
{
    private DNode head;
    private DNode tail;
    private int size;

    //GETTERS & SETTERS
    public DNode getHead() {
        return head;
    }

    public void setHead(DNode head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DNode getTail() {
        return tail;
    }

    public void setTail(DNode tail) {
        this.tail = tail;
    }

    //CONSTRUCTORS
    public CSLL() {
        setHead(null);
        setTail(getHead());
        setSize(0);
    }

    //INSERTION METHODS
    @Override
    public void insertHead(DNode node) {
        //System.out.println(getTail());
        super.insertHead(node);
        if(getTail() == null) {
            setTail(getHead());
        }
        else {
            getTail().setNext(getHead());
        }

    }

    @Override
    public void insertTail(DNode node) {
        super.insertTail(node);
        setTail(node);
        node.setNext(getHead());
    }

    @Override
    public DNode getLastNode() {
        return getTail();
    }

    



    //Insert shouldn't have to be extended because inserting in the middle will 
    //should not make any difference. & since insert head and insert tail are called in super class and they are overridden
    //it should override to set the new head or new tail back to looop around boiiii

    @Override
    public void print() {
        DNode current = getHead();
        System.out.println("List size: " + getSize());
        // System.out.println("Sorted: "+isSorted());

        for(int i = 0; i < getSize(); i++) {
            System.out.println(current);
            current = current.getNext();
        }
    }
    
}
