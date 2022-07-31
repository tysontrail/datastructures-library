package mylib;


public class linkedListNode
{
    private linkedListNode next;
    
    //Constructor
    public linkedListNode(linkedListNode next) {
        this.next = next;
    }

    public linkedListNode getNext() {
        return next;
    }

    public void setNext(linkedListNode next) {
        this.next = next;
    }   
}
