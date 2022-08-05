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
        return tailPointer;
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

    //INSERTION METHODS
    @Override
    public void insertHead(DNode node) {
        super.insertHead(node);
        getHead().setPrev(getTail());
        getTail().setNext(getHead());
    }

    @Override
    public void insertTail(DNode node) {
        super.insertTail(node);
        getTail().setNext(getHead());
        getHead().setPrev(getTail());
    }

    @Override
    public void insert(DNode node, int position) {
        super.insert(node, position);
        getTail().setNext(getHead());
        getHead().setPrev(getTail());
    }

    //SORT METHODS
    @Override
    public void sort() {
        DNode current = getHead();
        getTail().setNext(null);
        setSorted(null);

        for(int i = 0; i < getSize(); i++) {
            DNode temp = current.getNext();
            // System.out.println(i);
            // System.out.println(temp);
            // System.out.println(current);
            sortedInserted(current);
            current = temp;
        }
        setHead(getSorted());

        //DNode temp2 = getHead();
        //System.out.println(" OG temp2 "+temp2);
        // for(int i = 1; i < getSize(); i++) {
        //     temp2 = temp2.getNext();
        //     //System.out.println("temp2 "+temp2);
        // }
        setTail(getLastNode());
        getTail().setNext(getHead());
        getHead().setPrev(getTail());
    }

    @Override
    public void sortedInserted(DNode node) {
        if(getSorted() == null || getSorted().getData() > node.getData()) {
			node.setNext(getSorted());
            setSorted(node);
            //getSorted().getNext().setPrev(getSorted());
            //System.out.println("geetSorted: "+getSorted());
		}
        else {
			DNode current = getSorted();
            //System.out.println("geetSorted: "+getSorted());
			while(current.getNext() != null && current.getNext().getData() < node.getData()) {
				current = current.getNext();
			}

			node.setNext(current.getNext()); //loses that 55
            current.getNext().setPrev(node);

			
		}
    }

    //SEARCH
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
    @Override
    public DNode deleteHead() {
        DNode temp = getHead();
        setHead(getHead().getNext());
        getTail().setNext(getHead());
        getHead().setPrev(getTail());
        setSize(getSize()-1);
        return temp;
    }

    @Override
    public DNode deleteTail() {
        DNode temp = getTail();
        setTail(getTail().getPrev());
        getTail().setNext(getHead());
        getHead().setPrev(getTail());
        setSize(getSize()-1);
        return temp;
    }

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
