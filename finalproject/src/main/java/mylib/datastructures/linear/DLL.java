package mylib;

/** Doubly linked list class */

public class DLL extends SLL
{
    //INSTANCE VARIABLES
    private DNode head;
    private DNode tail;
    private int size;
    private DNode sorted;
    private DNode tailPointer;

    //GETTERS & SETTERS
    public DNode getHead() {
        return head;
    }

    public DNode getSorted() {
        return sorted;
    }

    public void setSorted(DNode sorted) {
        this.sorted = sorted;
    }

    public DNode getTailPointer() {
        return tailPointer;
    }

    public void setTailPointer(DNode tailPointer) {
        this.tailPointer = tailPointer;
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
    //O(1)
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
    //O(1)
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
    //O(n)
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
    //O(n)
    @Override
    public void sortedInsert(DNode node) {

        DNode current = getHead();
        if(isSorted() == false) {
            sort();
        }
    
        if(current == null) {
            insertHead(node);
            setSize(getSize()-1);
        }

        else if(getHead().getData() >= node.getData()) {
            insertHead(node);
            setSize(getSize()-1);
        }

        else if(getLastNode().getData() < node.getData()) {
            insertTail(node);
            setSize(getSize()-1);
        }

        else {
            current = getHead();
            while(current.getNext() != getTailPointer() && current.getData() != node.getData() && current.getNext().getData() < node.getData()) {
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
    //O(n^2)
    @Override
    public void sort() {
        super.sort();
        setTail(getLastNode());
    }

    //O(n)
    @Override
    public void sortedInserted(DNode node) {
        if(getSorted() == null || getSorted().getData() > node.getData()) {
			node.setNext(getSorted());
            //getSorted().setPrev(node);
            setSorted(node);           
		}
        else {
			DNode current = getSorted();
            //System.out.println("geetSorted: "+getSorted());
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
    //O(1)
    @Override
    public DNode deleteHead() {
        DNode temp = getHead();
        setHead(getHead().getNext());
        getHead().setPrev(null);
        setSize(getSize()-1);
        return temp;
    }

    //Delete tail node
    //O(1)
    @Override
    public DNode deleteTail() {
        DNode temp = getTail();
        setTail(getTail().getPrev());
        getTail().setNext(null);
        setSize(getSize()-1);
        return temp;
    }

    //Deletes the node if found in the list
    //O(n - 1) AKA O(n)
    @Override
    public DNode delete(int data) {
        DNode current = getHead();
        DNode tempNext = null;
        setSize(getSize()-1);
        // If the id given is the first element
        if (current.getData() == data && current != null) {
            setSize(getSize()+1);
            return deleteHead();
        }

        else if(getTail().getData() == data) {
            return deleteTail();
        }
        
        while (current != null && current.getData() != data) {
            tempNext = current;
            current = current.getNext();
        }

        if(current == null) {
            setSize(getSize()+1);
            System.out.println("Element not found in list");
            return null;
        }
        tempNext.setNext(current.getNext());
        current.getNext().setPrev(tempNext);
        return current;
    }
}
