package mylib;

/** Doubly linked list class */

public class DLL extends SLL
{
    //INSTANCE VARIABLES
    private DNode head;
    private DNode tail;
    private int size;
    private DNode sorted;

    //GETTERS & SETTERS
    public DNode getHead() {
        return head;
    }

    public void setHead(DNode head) {
        this.head = head;
    }

    public DNode getTail() {
        return tail;
    }

    public void setTail(DNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //CONSTRUCTORS
    public DLL() {
        setHead(null);
        setTail(null);
    }

    //Overload constructor with a Node object argument to use as head
    public DLL(DNode head, DNode tail) {
        setHead(head);
        setTail(tail);
    }

    //INSERTION METHODS
    //Inserts node object at head of the list
    @Override
    public void insertHead(DNode node) {
        if (getHead() == null) {
            setHead(node);
            setTail(node);
        } 
        else {
            node.setNext(getHead());
            getHead().setPrev(node);
            setHead(node);
        }
        setSize(getSize()+1);
    }

    //Inserts node object at the tail of the list
    @Override
    public void insertTail(DNode node) {

        if (getHead() == null) {
            setHead(node);
            setTail(node);
        } 
        else {
            getTail().setNext(node);
            node.setPrev(getTail());
            setTail(node);
        }
        setSize(getSize()+1);
    }

    //Inserts node object in the specified position
    @Override
    public void insert(DNode node, int position) {
        if(getHead() == null) {
            setHead(node);
            setTail(node);
        }
        else if(getNode(position) == null) {
            insertTail(node);
            setSize(getSize()-1);
        }
        else if(position == 0) {
            insertHead(node);
            setSize(getSize()-1);
        }
        else {
            DNode nodeBefore = getNode(position).getPrev();
            DNode nodeAfter = getNode(position);
            node.setNext(nodeAfter);
            nodeBefore.setNext(node);
            nodeAfter.setPrev(node);
            node.setPrev(nodeBefore);

        }
        setSize(getSize()+1);
    }

    //Inserts node object in its proper position in a sorted list
    @Override
    public void sortedInsert(DNode node) {

        DNode current = getHead();
        if(isSorted() == false) {
            sort();
        }
    
        if(getHead() == null || getHead().getData() > node.getData()) {
            node.setNext(getHead());
            setHead(node);
        }
        else {
            current = getHead();
            while(current.getNext() != null && current.getData() != node.getData() && current.getNext().getData() < node.getData()) {
                current = current.getNext(); 
            }
            //set next for new node
            node.setNext(current.getNext());
            //set new nodes previous
            node.setPrev(current);
            //set previous for node before new node
            current.getNext().setPrev(node);
            //set next to be new node
            current.setNext(node);
            
        }
        setSize(getSize()+1);
    }

    //SORT METHODS
    @Override
    public void sort() {
        super.sort();
        setTail(getLastNode());
    }

    @Override
    public void sortedInserted(DNode node) {
        if(getSorted() == null || getSorted().getData() > node.getData()) {
			node.setNext(getSorted());
            setSorted(node);
		}
        else {
			DNode current = getSorted();
			while(current.getNext() != null && current.getData() != node.getData() && current.getNext().getData() < node.getData()) {
				current = current.getNext(); 
			}
			node.setNext(current.getNext());
            current.getNext().setPrev(node);
            node.setPrev(current);
			current.setNext(node);
		}
    }

    //DELETE METHODS
    //Delete head node
    @Override
    public DNode deleteHead() {
        DNode temp = getHead();
        setHead(getHead().getNext());
        getHead().setPrev(null);
        setSize(getSize()-1);
        return temp;
    }

    //Delete tail node
    @Override
    public DNode deleteTail() {
        setTail(getTail().getPrev());
        getTail().setNext(null);
        setSize(getSize()-1);
        return getTail();
    }

    //Deletes the node if found in the list
    @Override
    public DNode delete(int data) {
        DNode current = getHead();
        DNode tempNext = null;
        setSize(getSize()-1);
        // If the id given is the first element
        if (getHead().getData() == data) {
            return deleteHead();
        }
        else if(getTail().getData() == data) {
            System.out.println("tst");
            return deleteTail();
        }
        while (current != null) {
            if (current.getNext().getData() == data) {
                tempNext = current.getNext();
                current.setNext(current.getNext().getNext());
                current.getNext().setPrev(current);
                return tempNext;
            }
            current = current.getNext();
        }
        return null;
    }
}
