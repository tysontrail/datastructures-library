package mylib;

/** Singly linked list class */

public class SLL
{
    private DNode head;
    private int size;
    private DNode sorted;

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
            setHead(node);
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
            node.setNext(getNode(position).getNext());
            getNode(position).setNext(node);
        }
        
    }

    //Inserts node object in its proper position in a sorted list
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
			node.setNext(current.getNext());
			current.setNext(node);
		}
        setSize(getSize()+1);
    }

    //SORTING METHODS
    //checks to see if list is sorted or not
    public boolean isSorted() {
        DNode current = getHead();
        if(getHead() == null) {
            return true;
        }
        for(current = getHead(); current.getNext() != null; current = current.getNext()) {
            if(current.getData() > current.getNext().getData()) {
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
			while(current.getNext() != null && current.getData() != node.getData() && current.getNext().getData() < node.getData()) {
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
            current = current.getNext();
            if (current.getNext().getNext() == null) {
                temp = current.getNext();
                current.setNext(null);
            return temp;
            }
        }
        return temp;
    }

    //Deletes the node if found in the list
    public DNode delete(int data) {
        DNode current = getHead();
        DNode temp = null;
        setSize(getSize()-1);
        // If the id given is the first element
        if (getHead().getData() == data) {
            return deleteHead();
        }
        while (current != null) {
            current = current.getNext();
            // If the id given is the last element
            if (current.getNext() == null && current.getData() == data) {
                return deleteTail();
            }

            if (current.getNext().getData() == data) {
                temp = current.getNext();
                current.setNext(current.getNext().getNext());
                return temp;
            }
        }
        return null;
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

        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    //grabs last node in the list
    public DNode getLastNode() {
        DNode current = getHead();
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    //get node at specific index
    public DNode getNode(int position) {
        DNode current = getHead();
        int count = 0;
        while(count < position) {
            current = current.getNext();
            count++;
        }
        return current;
    }

}
