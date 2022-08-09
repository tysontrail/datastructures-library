package mylib;

/**
 * Stack class
 *
 */
public class Stack extends SLL
{
    private DNode head;
    private int size;


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

    public Stack() {
        setHead(null);
        setSize(0);
    }

    public Stack(DNode head) {
        setHead(head);
        setSize(0);
    }

    //O(1)
    public void push(DNode node) {
        super.insertHead(node);
    }

    //deletes top of the stack
    //O(1)
    public DNode pop() {
        return super.deleteHead();
    }
    
    //O(1)
    public boolean isEmpty() {
        if(getHead() == null) {
            return true;
        }
        return false;
    }

    //O(1)
    public int peek() {
        if(getHead() == null) {
            System.out.println("The stack is empty");
            return -1;
        }
        return getHead().getData();
    
    }

    @Override
    public void insertTail(DNode node) {
        //override with empty body
    }

    @Override 
    public void insert(DNode node, int position) {
        //Override with empty body
    }


    //sortedInsert
    @Override 
    public void sortedInsert(DNode node) {
        //empty body for override
    }

    //sort
    @Override 
    public void sort() {
        //empty body n/a for stacks
    }

    @Override 
    public void sortedInserted(DNode node) {
        //empty body n/a for stacks
    }

    @Override
    public DNode deleteTail() {
        return null;
    }

    @Override
    public DNode delete(int data) {
        return null;
    }

    //O(n)
    public int searchStack(int data) {
        DNode current = getHead();
        int count = 0;
		while(current != null && current.getData() != data) {
			current = current.getNext();
            count++;
		}
		if(current != null && current.getData() == data) {
			return count;
		}
		else {
			return -1;
		}
    }

}
