// Test comment
package mylib;

/** Singly linked list class */

//HELLO TESTING THIS IS MY LATEST COMMENT

public class SLL
{
    private DNode head;
    private int size;

    public SLL() {
        head = null;
        size = 0;
    }

    public SLL(DNode head) {
        this.head = head;
        size = 0;
    }

    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
        } 
        else {
        node.setNext(head);
        head = node;
        }
        size++;
    }

    public void insertTail(DNode node) {

        if (head == null) {
          head = node;
        } 
        else {
          getLastNode().setNext(node);
        }
        size++;
    }

    public void insert(DNode node, int position) {
        if(head == null) {
            head = node;
        }
        else {
            node.setNext(getNode(position).getNext());
            getNode(position).setNext(node);
        }

    }

  public DNode removeEndElement() {
    DNode current = head;
    DNode temp = null;
    while (current != null) {
      current = current.getNext();
      if (current.getNext().getNext() == null) {
        temp = current.getNext();
        current.setNext(null);
        return temp;
      }
    }
    return temp;
  }

  public DNode removeFirstElement() {
    temp = head;
    head = head.getNext();
    return temp;
  }

  public DNode removeElement(int id) {
    DNode current = head;
    // If the id given is the first element
    if (head.getId() == id) {
      return removeFirstElement();
    }
    while (current != null) {
      current = current.getNext();
      // If the id given is the last element
      if (current.getNext() == null && current.getId() == id) {
        return removeEndElement();
      }
      if (current.getNext().getId() == id) {
        temp = current.getNext();
        current.setNext(current.getNext().getNext());
        return temp;
      }
    }
    return temp;
  }

  public void recursivePrintList() {
    recursivePrintList(head);
  }

  private void recursivePrintList(DNode cursor) {

    if (cursor != null) {

      System.out.println(cursor);
      recursivePrintList(cursor.getNext());
    }
  }

  public void printList() {
    Student cursor = head;
    while (cursor != null) {
      System.out.println(cursor);
      cursor = cursor.getNext();
    }
  }

  private DNode getLastNode() {
    DNode cursor = head;
    while (cursor.getNext() != null) {
      cursor = cursor.getNext();
    }
    return cursor;
  }

  private DNode getNode(int position) {
    DNode cursor = head;
    int count = 0;
    while(count != position - 1) {
        cursor = cursor.getNext();
        count++;
    }
    return cursor;
  }

  public DNode getHead() {
    return head;
  }
}
