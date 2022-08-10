package mylib;

/** Circular Doubly Linked List
 *
 */
public class CDLL extends DLL
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
    public DNode getTailPointer() {
        return getHead();
    }
    public void setTailPointer(DNode tailPointer) {
        this.tailPointer = tailPointer;
    }

    //CONSTRUCTORS
    public CDLL() {
        setHead(null);
        setTail(getHead());
        setSize(0);
    }

    public CDLL(DNode head) {
        setHead(head);
        setTail(head);
        getHead().setNext(getTail());
        getTail().setNext(getHead());
        getHead().setPrev(getTail());
        getTail().setPrev(getHead());
        setSize(0);
    }

    //INSERTION METHODS
    //O(1)
    @Override
    public void insertHead(DNode node) {
        super.insertHead(node);
        getHead().setPrev(getTail());
        getTail().setNext(getHead());
    }

    //O(1)
    @Override
    public void insertTail(DNode node) {
        super.insertTail(node);
        getTail().setNext(getHead());
        getHead().setPrev(getTail());
    }

    //O(n)
    @Override
    public void insert(DNode node, int position) {
        super.insert(node, position);
        getTail().setNext(getHead());
        getHead().setPrev(getTail());
    }

    //SORT METHODS
    //O(n^2)
    @Override
    public void sort() {
        DNode current = getHead();
        getTail().setNext(null);
        setSorted(null);

        for(int i = 0; i < getSize(); i++) {
            DNode temp = current.getNext();
            current.setPrev(null);
            current.setNext(null);
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
        getHead().setPrev(getTail());
    }

    //O(n)
    @Override
    public void sortedInserted(DNode node) {
        if(getSorted() == null) {
            //System.out.println(getSorted());
            setSorted(node);
        }
        else if(getSorted().getData() > node.getData() || getSorted().getData() == node.getData()) {
            //System.out.println(getSorted());
            node.setNext(getSorted());
            node.getNext().setPrev(node);
            setSorted(node);
		}
        else {
			DNode current = getSorted();
			while(current.getNext() != null && current.getNext().getData() < node.getData()) {
				current = current.getNext();
			}

			node.setNext(current.getNext()); 
            current.setNext(node);
            node.setPrev(current);	
		}
    }

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
        else if(getHead().getData() > node.getData() || getHead().getData() == node.getData()) {
            insertHead(node);
            setSize(getSize()-1);
		}
        else {
            current = getHead();
			while(current.getNext() != null && current.getNext().getData() < node.getData()) {
				current = current.getNext();
			}

			node.setNext(current.getNext()); 
            current.setNext(node);
            node.setPrev(current);	
		}
        setSize(getSize()+1);
    }

    //SEARCH
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
    //O(1)
    @Override
    public DNode deleteHead() {
        DNode temp = getHead();
        setHead(getHead().getNext());
        getTail().setNext(getHead());
        getHead().setPrev(getTail());
        setSize(getSize()-1);
        return temp;
    }

    //O(1)
    @Override
    public DNode deleteTail() {
        DNode temp = getTail();
        setTail(getTail().getPrev());
        getTail().setNext(getHead());
        getHead().setPrev(getTail());
        setSize(getSize()-1);
        return temp;
    }

    //O(n)
    @Override
    public DNode delete(int data) {
        DNode current = getHead();
        DNode temp = null;
        setSize(getSize()-1);

        //If the id given is the first element
        if (current.getData() == data && current != null) {
            setSize(getSize()+1);
            return deleteHead();
        }

        //Search through list until the end or until you find node
        while (current.getNext() != getHead() && current.getData() != data) {
            //keep track of current so if you find node you can delete current
            temp = current;
            current = current.getNext();
        }
        //if key is at the tail
        if(current.getNext() == getHead() && current.getData() == data) {
            setSize(getSize()+1);
            return deleteTail();
        }

        //if key was not in the list
        if(current.getNext() == getHead()) {
            setSize(getSize()+1);
            System.out.println("Element not found in list \n");
            return null;
        }
        temp.setNext(current.getNext());
        current.getNext().setPrev(temp);
        return current;
    }
}
