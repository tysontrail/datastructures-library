package mylib;

/**
 * Stack class
 *
 */
//ADD IS EMPTY TO STACK
public class Stack extends SLL
{
    private DNode tail;
    private int size;

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

    public Stack() {
        this.tail = null;
        this.size = 0;
    }

    public Stack(DNode tail) {
        this.tail = tail;
        this.size = 0;
    }

    public void push(DNode node) {
        super.insertHead(node);
    }

    //deletes top of the stack
    public DNode pop() {
        return super.deleteHead();
    }
    
    public int peek() {
        if(tail == null) {
            System.out.println("The stack is empty");
            return -1;
        }
        return tail.getData();
    
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

}
