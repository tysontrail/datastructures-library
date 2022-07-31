package mylib;

/**
 * Hello world!
 *
 */
public class linkedListNode
{
    private Node next;
    
    //Constructor
    public Node() {
        setNext(null);
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }   
}
