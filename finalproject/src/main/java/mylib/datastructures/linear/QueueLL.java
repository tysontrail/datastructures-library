// test comment
package mylib;

/** Queues */
public class QueueLL extends SLL {
  // queue
  private DNode head;
  private DNode tail;
  private int size;

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

  public QueueLL() {
    setHead(null);
    setTail(null);
    setSize(0);
  }

public QueueLL(DNode head, DNode tail) {
    setHead(head);
    setTail(tail);
    setSize(0);
}

  public void enqueue(DNode node) {
    super.insertTail(node);
  }

  public void dequeue() {
    super.deleteHead();
  }

  public DNode peek() {
    if(getHead() == null) {
      System.out.println("The queue is empty");
      return null;
    }
    return getHead();
  }

  public boolean isEmpty() {
    if(getHead() == null) {
        return true;
    }
    return false;
  }

  public int searchQueue(int data) {
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
