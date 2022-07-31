package mylib;


public class linkedListNode
{
    private linkedListNode next;
    private int data;
    
    //Constructor
    public linkedListNode(int data) {
        setNext(null);
        setData(data);
    }

    public linkedListNode getNext() {
        return next;
    }

    public void setNext(linkedListNode next) {
        this.next = next;
    }   

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Value:" + getData();
    }
}
