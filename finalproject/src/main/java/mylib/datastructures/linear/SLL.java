package mylib;

/**
 * Singly linked list class
 *
 */
public class SLL
{
    private linkedListNode head;
    private linkedListNode next;
    private linkedListNode current;
    private linkedListNode temp;
    private linkedListNode prev;

    public SLL () {
        head = null;
    }

    //public void insertionSort() {}

    //public void insertInOrder(linkedListNode node) {}

    public linkedListNode removeEndElement() {
		current = head;
		while(current != null) {
			current = current.getNext();
			if(current.getNext().getNext() == null){
				temp = current.getNext();
				current.setNext(null);
				return temp;
			}

		}
		return temp;
	}

	public linkedListNode removeFirstElement() {
		temp = head;
		head = head.getNext();
		return temp;
	}
		
	public linkedListNode removeElement(int id) {
		current = head;
		//If the id given is the first element
		if(head.getId() == id) {
			return removeFirstElement();
		}
		while(current != null) {
			current = current.getNext();
			//If the id given is the last element
			if(current.getNext() == null && current.getId() == id) {
				return removeEndElement();
			}
			if(current.getNext().getId() == id) {
				temp = current.getNext();
				current.setNext(current.getNext().getNext());
				return temp;
			}
		}
		return temp;
	}

	public void insertToEndOfList(linkedListNode node) {
		
		if (head == null) {
			head = node;
		}
		else {	
			getLastNode().setNext(node);
		}
		
	}
	public void insertToFrontOfList (linkedListNode node) {
		if (head == null) {
			head = node;
		}
		else {
			node.setNext(head);
			head = node;
		}
	}
 
	public void recursivePrintList () {
		recursivePrintList (head);
	}
	private void recursivePrintList (linkedListNode cursor) {
		
		if (cursor != null) {
			
			System.out.println(cursor);
			recursivePrintList (cursor.getNext());
		}
	}
	public void printList () {
		Student cursor = head;
		while (cursor != null) {
			System.out.println(cursor);
			cursor = cursor.getNext();
		}
		
	}
	private linkedListNode getLastNode() {
		linkedListNode cursor = head;
		while (cursor.getNext() != null) {
			cursor = cursor.getNext();
		}
		return cursor;
	}
	public linkedListNode getHead() {
		return head;
	}


}
