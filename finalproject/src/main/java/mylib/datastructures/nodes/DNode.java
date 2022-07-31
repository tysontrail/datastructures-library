package mylib;


public class DNode
{
    private DNode next;
    private int data;
    
    //Constructor
    public DNode(int data) {
        setNext(null);
        setData(data);
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
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
