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
    //Complexity O(1)
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
    //O(n) because of getLastNode()
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
    //O(n) because of getNode()
    public void insert(DNode node, int position) {
        setSize(getSize()+1);
        if(getHead() == null) {
            insertHead(node);
            setSize(getSize()-1);
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
    //Complexity O(n)
    public void sortedInsert(DNode node) {

		DNode current = getHead();
        if(isSorted() == false) {
            sort();
        }

		if(current == null) {
			insertHead(node);
            setSize(getSize()-1);
            //System.out.println("UPDATED HEAD because null");
		}

        else if(getHead().getData() >= node.getData()) {
            insertHead(node);
            setSize(getSize()-1);
            //System.out.println("UPDATED because head is greater than node");
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
			node.setNext(current.getNext());
			current.setNext(node);
		}
        setSize(getSize()+1);
    }

    //SORTING METHODS
    //checks to see if list is sorted or not
    //Complexity O(n)
    public boolean isSorted() {
        DNode current = getHead();
        if(current == null) {
            return true;
        }
        while(current.getNext() != getTailPointer()) {
            if(current.getData() < current.getNext().getData()) {
                current = current.getNext();  
            }
            else {
                return false;
            }
        }
        return true;
    }

    //sorted elements ascending order
    //Complexity O(n^2) - O(n) for while looping through list * O(n) for sortedInserted()
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
    //Complexity O(n)
    public void sortedInserted(DNode node) {
		if(getSorted() == null || getSorted().getData() >= node.getData()) {
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
    //Complexity O(n)
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
    //Complexity O(1)
    public DNode deleteHead() {
        if(getHead() == null) {
            System.out.println("Cannot delete from empty list");
            return null;
        }
        DNode temp = getHead();
        setHead(getHead().getNext());
        setSize(getSize()-1);
        return temp;
    }

    //Delete tail node
    //Complexity O(n) - because you need to iterate through. If I would have held a tail reference it would be O(1)
    public DNode deleteTail() {
        if(getHead() == null) {
            System.out.println("Cannot delete from empty list");
            return null;
        }
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
    //Complexity O(n)
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
            System.out.println("Element not found in list");
            return null;
        }
        temp.setNext(current.getNext());
        return current;

    }

    //Deletes the whole list
    //Complexity O(1)
    public void clear() {
        setSize(0);
        setHead(null);
    }

    //PRINTS LIST
    //Prints the list information on the screen - list length, sorted status, list content
    //Complexity O(n)
    public void print() {
        DNode current = getHead();
        System.out.println("List size: " + getSize());
        System.out.println("Sorted: "+isSorted());

        for(int i = 0; i < getSize(); i++) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    //grabs last node in the list
    //Complexity O(n)
    public DNode getLastNode() {
        DNode current = getHead();
        while (current.getNext() != getTailPointer()) {
            current = current.getNext();
        }
        return current;
    }

    //get node at specific index
    //complexity - O(n)
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
