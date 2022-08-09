package mylib;

/**
 * Stack class
 *
 */
//ADD IS EMPTY TO STACK
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
        getHead(head);
        setSize(0);
    }

    public void push(DNode node) {
        super.insertHead(node);
    }

    //deletes top of the stack
    public DNode pop() {
        return super.deleteHead();
    }
    
    public boolean isEmpty() {
        if(getHead() == null) {
            return true;
        }
        return false;
    }

    public int peek() {
        if(getHead() == null) {
            System.out.println("The stack is empty");
            return -1;
        }
        return System.out.println(getHead().getData());
    
    }

    @Override
    public void insertTail(DNode node) {
        //override with empty body
    }

    @Override 
    public void insert(DNode node, int position) {
        //Override with empty body
    }

    //Needs search, clear, print, getsize - figure out if you can use these straight from SLL or do you need to override??

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

    public DNode getHead() {
        return head;
    }

    public void setHead(DNode head) {
        this.head = head;
    }

}
