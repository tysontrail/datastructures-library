package mylib;


public class DNode
{
    private DNode next;
    private DNode prev;
    private int data;
    
    //Constructor
    public DNode(int data) {
        setNext(null);
        setPrev(null);
        setData(data);
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
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
