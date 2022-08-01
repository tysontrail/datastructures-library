package mylib;


public class DLL extends SLL
{
    private DNode head;
    private DNode tail;
    private int size;

    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
}

    //Overload constructor with a Node object argument to use as head
    public DLL(DNode head, DNode tail) {
        this.head = head;
        this.tail = tail;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    //Inserts node object at head of the list
    @Override
    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } 
        else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        size++;
    }

    //Inserts node object at the tail of the list
    @Override
    public void insertTail(DNode node) {

        if (head == null) {
            head = node;
            tail = node;
        } 
        else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
    }

    //Inserts node object in the specified position
    @Override
    public void insert(DNode node, int position) {
        if(head == null) {
            head = node;
        }
        else if(getNode(position) == null) {
            getNode(position).setNext(node);
            node.setPrev(getNode(position));
        }
        else {
            DNode nodeBefore = getNode(position);
            DNode nodeAfter = getNode(position).getNext();
            node.setNext(nodeAfter);
            nodeBefore.setNext(node);
            nodeAfter.setPrev(node);
            node.setPrev(nodeBefore);

        }
        size++;
    }

    //get node at specific index
    @Override
    public DNode getNode(int position) {
        DNode current = head;
        int count = 0;
        while(count < position) {
            current = current.getNext();
            count++;
        }
        return current;
    }

    //Inserts node object in its proper position in a sorted list
    @Override
    public void sortedInsert(DNode node) {

        DNode current = head;
        if(isSorted() == false) {
            sort();
        }
    
        if(head == null || head.getData() > node.getData()) {
            node.setNext(head);
            head = node;
        }
        else {
            current = head;
            while(current.getNext() != null && current.getData() != node.getData() && current.getNext().getData() < node.getData()) {
                current = current.getNext(); 
            }
            //set next for new node
            node.setNext(current.getNext());
            //set new nodes previous
            node.setPrev(current);
            //set previous for node before new node
            current.getNext().setPrev(node);
            //set next to be new node
            current.setNext(node);
            
        }
        size++;
    }

    //Delete head node
    @Override
    public DNode deleteHead() {
        DNode temp = head;
        head = head.getNext();
        head.setPrev(null);
        size--;
        return temp;
    }

    //Delete tail node
    @Override
    public DNode deleteTail() {
        tail = tail.getPrev();
        tail.setNext(null);
        size--;
        return tail;
    }



}
