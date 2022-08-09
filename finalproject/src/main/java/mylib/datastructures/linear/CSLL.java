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
    private DNode tailPointer;

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

    public  DNode getTailPointer() {
        return getHead();
    }

    public  void setTailPointer(DNode tailPointer) {
        this.tailPointer = tailPointer;
    }

    //CONSTRUCTORS
    public CSLL() {
        setHead(null);
        setTail(getHead());
        setSize(0);
    }

    //INSERTION METHODS
    //O(1)
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

    //O(n) - could have enhanced this by doing setPrev(head) to node and setNext(tail) to node
    //but was trying to reduce the duplication of code and use the super class
    @Override
    public void insertTail(DNode node) {
        super.insertTail(node);
        setTail(node);
        node.setNext(getHead());
    }

    //O(n)
    @Override
    public void insert(DNode node, int position) {
        super.insert(node, position);
        setTail(getLastNode());
        getTail().setNext(getHead());
    }

    //O(n^2) - nested traversal
    @Override
    public void sort() {
        DNode current = getHead();
        setSorted(null);

        for (int i = 0; i < getSize(); i++) {
            DNode temp = current.getNext();
            sortedInserted(current);
            current = temp;
        }
        setHead(getSorted());

        DNode temp2 = getHead();
        for(int i = 1; i < getSize(); i++) {
            temp2 = temp2.getNext();

        }
        setTail(temp2);
        getTail().setNext(getHead());

    }

    //SEARCH
    //Looks up node in the list
    //O(n)
    @Override
    public DNode search(int data) {
        DNode current = getHead();
        DNode match = null;
        for(int i = 0; i < getSize(); i++) {
            if(current.getData() == data) {
                match = current;
            }
            current = current.getNext(); 
        }
        return match;
    }

    //DELETION METHODS
    //Delete head node
    //O(1)
    @Override
    public DNode deleteHead() {
        DNode temp = getHead();
        setHead(getHead().getNext());
        getTail().setNext(getHead());
        setSize(getSize()-1);
        return temp;
    }

    //O(n)
    @Override
    public DNode deleteTail() {
        DNode current = getHead();
        DNode temp = null;
        setSize(getSize()-1);
        while(current.getNext() != getHead()) {
            current = current.getNext();
            if(current.getNext().getNext() == getHead()) {
                temp = current.getNext();
                current.setNext(getHead());
                return temp;
            }
        }
        return temp; 
    }

    //Complexity O(n)
    @Override
    public DNode delete(int data) {
        DNode current = getHead();
        DNode temp = null;
        setSize(getSize()-1);

        // If the id given is the first element
        if (current.getData() == data && current != null) {
            setSize(getSize()+1);
            return deleteHead();
        }
        //search for key until find node
        while (current.getNext() != getHead() && current.getData() != data) {
            temp = current;
            current = current.getNext();
        }
        //if key was at the tail
        if(current.getNext() == getHead() && current.getData() == data) {
            setSize(getSize()+1);
            return deleteTail();
        }
        //if key was not in list
        if(current.getNext() == getHead()) {
            setSize(getSize()+1);
            System.out.println("Element not found in list \n");
            return null;
        }
        temp.setNext(current.getNext());
        return current;
    }
    
}
