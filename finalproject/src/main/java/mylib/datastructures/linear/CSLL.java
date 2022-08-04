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
    public void insert(DNode node, int position) {
        super.insert(node, position);
        setTail(getLastNode());
        getTail().setNext(getHead());
    }

    @Override
    public void sort() {
        DNode current = getHead();
        setSorted(null);
        for(int i = 0; i < getSize(); i++) {
            DNode temp = current.getNext();
            sortedInsert(current);
            current = temp;
        }
    }

    @Override 
    public void sortedInserted(DNode node) {
        DNode current = getSorted();
        if(getSorted() == null) {
            node.setNext(getSorted());
            setSorted(node);
        }

        else if(current.getData() >= node.getData()) {
            while(current.getNext() != getTailPointer()) {
                current = current.getNext();
            }
            current.setNext(node);
            node.setNext(getHead());
            setHead(node);
            getTail().setNext(getHead());
        }
        else {
            while(current.getNext() != getTailPointer() && current.getNext().getData() < node.getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
        }
    }

    //SEARCH
    //Looks up node in the list
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
    @Override
    public DNode deleteHead() {
        DNode temp = getHead();
        setHead(getHead().getNext());
        setSize(getSize()-1);
        return temp;
    }

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
        //if key was not in linked list
        if(current.getNext() == getHead()) {
            setSize(getSize()+1);
            return null;
        }
        temp.setNext(current.getNext());
        return temp;
    }
    
}
