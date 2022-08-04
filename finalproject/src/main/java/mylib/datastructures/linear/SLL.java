package mylib;

/** Singly linked list class */

public class SLL
{
    private DNode head;
    private int size;
    private DNode sorted;
    private DNode tailPointer;

    //GETTERS & SETTERS
    public void setHead(DNode head) {
        this.head = head;
    }

    public DNode getHead() {
        return head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public DNode getSorted() {
        return sorted;
    }

    public void setSorted(DNode sorted) {
        this.sorted = sorted;
    }

    public DNode getTailPointer() {
        return null;
    }

    // public void setTailPointer() {
    //     this.tailPointer = null;
    // }

    //CONSTRUCTORS
    //Default constructor with no arguments that creates a null head object
    public SLL() {
        setHead(null);
        setSize(0);
    }

    //Overload constructor with a Node object argument to use as head
    public SLL(DNode head) {
        setHead(head);
        setSize(0);
    }

    //INSERTION METHODS
    //Inserts node object at head of the list
    public void insertHead(DNode node) {
        if (getHead() == null) {
            setHead(node);
        } 
        else {
        node.setNext(getHead());
        setHead(node);
        }
        setSize(getSize()+1);

    }

    //Inserts node object at the tail of the list
    public void insertTail(DNode node) {

        if (getHead() == null) {
            setHead(node);
        }
        else {
          getLastNode().setNext(node);
        }
        setSize(getSize()+1);
    }

    //Inserts node object in the specified position
    public void insert(DNode node, int position) {
        setSize(getSize()+1);
        if(getHead() == null) {
            insertHead(node);
            setSize(getSize()-1);
            //System.out.println("head null" +position);
        }
        else if(getNode(position) == null) {
            insertTail(node);
            setSize(getSize()-1);
            //System.out.println("get tail " +position);
        }
        else if(position == 0) {
            insertHead(node);
            setSize(getSize()-1);
            //System.out.println("get head " +position);
        }
        else {
            node.setNext(getNode(position).getNext());
            getNode(position).setNext(node);
            //System.out.println("Node at position" +getNode(position));
        }
        
    }

    //Inserts node object in its proper position in a sorted list
    public void sortedInsert(DNode node) {

		DNode current = getHead();
        if(isSorted() == false) {
            sort();
        }

		if(current == null || getHead().getData() >= node.getData()) {
			insertHead(node);
            setSize(getSize()-1);
            //System.out.println("UPDATED HEAD");
		}

        if(getLastNode().getData() < node.getData()) {
            insertTail(node);
            setSize(getSize()-1);
        }
		else {
			current = getHead();
			while(current.getNext() != getTailPointer() && current.getData() != node.getData() && current.getNext().getData() < node.getData()) {
				current = current.getNext(); 
			}
			node.setNext(current.getNext());
			current.setNext(node);
		}
        setSize(getSize()+1);
    }

    //SORTING METHODS
    //checks to see if list is sorted or not
    public boolean isSorted() {
        DNode current = getHead();
        if(current == null) {
            return true;
        }
        while(current.getNext() != getTailPointer()) {
            if(current.getData() < current.getNext().getData()) {
                current = current.getNext();
            }
            else{
                return false;
            }
        }
        return true;
    }

    public void sort() {

        DNode current = getHead();
        setSorted(null);
        while(current != null) {
            DNode temp = current.getNext();
            sortedInserted(current);
            current = temp;
            //System.out.println(current);
            
        }
        setHead(getSorted());
        //System.out.println(head);
    }

    //created a separate sortedinserted method to use in sort to reduce confusion since the actual sortedinsert has to call sort already
    public void sortedInserted(DNode node) {
		if(getSorted() == null || getSorted().getData() > node.getData()) {
			node.setNext(getSorted());
            setSorted(node);
		}
        else {
			DNode current = getSorted();
			while(current.getNext() != getTailPointer() && current.getData() != node.getData() && current.getNext().getData() < node.getData()) {
				current = current.getNext(); 
			}
			node.setNext(current.getNext());
			current.setNext(node);
		}

    }

    //SEARCH
    //Looks up node in the list
    public DNode search(int data) {
		DNode current = getHead();
		while(current != null && current.getData() != data) {
			current = current.getNext();
		}
		if(current != null && current.getData() == data) {
			DNode match = new DNode(current.getData());
			return match;
		}
		else {
			return null;
		}
	}	

    //DELETION METHODS
    //Delete head node
    public DNode deleteHead() {
        DNode temp = getHead();
        setHead(getHead().getNext());
        setSize(getSize()-1);
        return temp;
    }

    //Delete tail node
    public DNode deleteTail() {
        DNode current = getHead();
        DNode temp = null;
        setSize(getSize()-1);
        while (current != null) {
            if (current.getNext().getNext() == null) {
                temp = current.getNext();
                current.setNext(null);
            return temp;
            }
            current = current.getNext();
        }

        return temp;
    }

    //Deletes the node if found in the list
    public DNode delete(int data) {
        DNode current = getHead();
        DNode temp = null;
        setSize(getSize()-1);
        // If the id given is the first element
        if (current.getData() == data && current != null) {
            setSize(getSize()+1);
            return deleteHead();
        }
        while (current != null && current.getData() != data) {
            temp = current;
            current = current.getNext();
        }
        if(current == null) {
            setSize(getSize()+1);
            return null;
        }
        temp.setNext(current.getNext());
        return temp;

    }

    //Deletes the whole list
    public void clear() {
        setSize(0);
        setHead(null);
    }

    //PRINTS LIST
    //Prints the list information on the screen - list length, sorted status, list content
    public void print() {
        DNode current = getHead();
        System.out.println("List size: " + getSize());
        System.out.println("Sorted: "+isSorted());

        for(int i = 0; i < getSize(); i++) {
            System.out.println(current);
            current = current.getNext();
        }
        // while (current != getTailPointer()) {
        //     System.out.println(current);
        //     current = current.getNext();
        // }
    }

    //grabs last node in the list
    public DNode getLastNode() {
        DNode current = getHead();
        while (current.getNext() != getTailPointer()) {
            current = current.getNext();
        }
        return current;
    }

    //get node at specific index
    public DNode getNode(int position) {
        DNode current = getHead();
        int count = 0;
        for(int i = 0; i < position - 1; i++) {
            current = current.getNext();
            count++;
        }

        return current;
    }

}
