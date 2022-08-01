package mylib;

/** Singly linked list class */

public class SLL
{
    private DNode head;
    private int size;
    private DNode sorted;

    //Default constructor with no arguments that creates a null head object
    public SLL() {
        this.head = null;
        this.size = 0;
    }

    //Overload constructor with a Node object argument to use as head
    public SLL(DNode head) {
        this.head = head;
        this.size = 0;
    }

    //size of list getter
    public int getSize() {
        return size;
    }

    //Inserts node object at head of the list
    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
        } 
        else {
        node.setNext(head);
        head = node;
        }
        size++;

    }

    //Inserts node object at the tail of the list
    public void insertTail(DNode node) {

        if (head == null) {
          head = node;
        } 
        else {
          getLastNode().setNext(node);
        }
        size++;
    }

    //Inserts node object in the specified position
    public void insert(DNode node, int position) {
        if(head == null) {
            head = node;
        }
        else if(getNode(position) == null) {
            insertTail(node);
        }
        else if(position == 0) {
            insertHead(node);
        }
        else {
            node.setNext(getNode(position).getNext());
            getNode(position).setNext(node);
        }
        size++;
    }

    //finish is sorted
    public boolean isSorted() {
        DNode current = head;
        if(head == null) {
            return true;
        }
        for(current = head; current.getNext() != null; current = current.getNext()) {
            if(current.getData() > current.getNext().getData()) {
                return false;
            }
        }
        return true;
    }
    //Inserts node object in its proper position in a sorted list
    public void sortedInsert(DNode node) {

		DNode current = head;
        if(isSorted() == false) {
            sort();
        }

		if(head == null || head.getData() > node.getData()) {
			node.setNext(head);
			head = node;
		}
		else {
			current = head;
			while(current.getNext() != null && current.getData() != node.getData() && current.getNext().getData() < node.getData()) {
				current = current.getNext(); 
			}
			node.setNext(current.getNext());
			current.setNext(node);
		}
        size++;
    }

    public void sort() {

        DNode current = head;
        sorted = null;
        while(current != null) {
            DNode temp = current.getNext();
            sortedInserted(current);
            current = temp;
            //System.out.println(current);
            
        }
        head = sorted;
        //System.out.println(head);
    }

    public void sortedInserted(DNode node) {
		if(sorted == null || sorted.getData() > node.getData()) {
			node.setNext(sorted);
			sorted = node;
		}
        else {
			DNode current = sorted;
			while(current.getNext() != null && current.getData() != node.getData() && current.getNext().getData() < node.getData()) {
				current = current.getNext(); 
			}
			node.setNext(current.getNext());
			current.setNext(node);
		}

    }

    //Looks up node in the list
    public DNode search(int data) {
		DNode current = head;
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

    //Delete head node
    public DNode deleteHead() {
        DNode temp = head;
        head = head.getNext();
        size--;
        return temp;
    }

    //Delete tail node
    public DNode deleteTail() {
        DNode current = head;
        DNode temp = null;
        size--;
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
        DNode current = head;
        DNode temp = null;
        size--;
        // If the id given is the first element
        if (head.getData() == data) {
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
        head = null;
    }

    //Prints the list information on the screen - list length, sorted status, list content
    public void print() {
        DNode current = head;
        System.out.println("List size: " +size);
        System.out.println("Sorted: "+isSorted());

        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    //
    public DNode getLastNode() {
        DNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    //get node at specific index
    public DNode getNode(int position) {
        DNode current = head;
        int count = 0;
        while(count < position) {
            current = current.getNext();
            count++;
        }
        return current;
    }

    public DNode getHead() {
        return head;
    }
}
