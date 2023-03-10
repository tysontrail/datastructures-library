package mylib;

import java.util.Collections;
import java.util.Vector;

public class MinH extends Heap {

  // Default constructor initializes vector to no size
  public MinH() {
    this.elements = new Vector<Integer>(0);
  }

  // Overload constructor initializes vector to a size passed as argument
  public MinH(int size) {
    this.elements = new Vector<Integer>(size);
  }

  // Overload constructor creates a heap from an array and stores it in elements
  public MinH(int array[]) {
    elements = heapify(array);
  }

  // Inserts the value key to the vector and maintains heap properties
  public void insert(int key) {
    elements.add(key);
    heapifyUp(getSize() - 1);
  }

  // Removes the value key from the vector and maintains heap properties
  // Complexity O(logn)
  public void delete(int key) {

    // Create index for key and initialize to -1
    int idx = -1;

    // Search for key in heap
    for (int i = 0; i < getSize(); i++) {
      if (elements.get(i) == key) {
        idx = i;
        break;
      }
    }

    // Check if key was found
    if (idx == -1) {
      System.out.println("Value to delete not found.");
      return;
    } else {

      // Swap node to be deleted with last leaf node
      swap(idx, getSize() - 1);

      // Remove last leaf node
      elements.remove(getSize() - 1);

      // Heapify downwards from swapped node
      heapifyDown(idx);
    }
  }

  // Applies heapsort to the vector content
  // Complexity O(nlogn)
  public void sort() {

    // Create array from elements
    int[] array = new int[getSize()];

    // Copy elements into array
    for (int i = 0; i < getSize(); i++) {
      array[i] = elements.get(i);
    }

    // Create heap
    elements = heapify(array);

    // Sort array
    for (int i = getSize() - 1; i >= 0; i--) {

      // Create new int array
      int[] arr = new int[i + 1];
      // Copy values from elements
      for (int j = 0; j < i + 1; j++) {
        arr[j] = elements.get(j);
      }
      // Create new vector
      Vector<Integer> vector = new Vector<Integer>(arr.length);
      // Heapify arr
      vector = heapify(arr);
      // Copy vector to elements
      for (int j = 0; j < vector.size(); j++) {
        elements.set(j, vector.get(j));
      }
      // Swap root/largest item with end item
      swap(0, i);
    }
    // Reverse order to re-create max heap
    Collections.reverse(elements);
  }

  // Heapification process after deletion
  // Complexity O(logn)
  private void heapifyDown(int i) {
    while (i < getSize()) {
      // If swapped element is less than its children, swap with the
      // largest child
      if (((2 * i + 1) < getSize() && left(i) < elements.get(i))
          || ((2 * i + 1) < getSize() && right(i) < elements.get(i))) {
        if (((2 * i + 2) >= getSize()) || (left(i) < right(i))) {
          // Swap left child
          swap(i, (2 * i + 1));
          // Update i to left child
          i = 2 * i + 1;
        } else {
          // Swap right child
          swap(i, (2 * i + 2));
          // Update i to right child
          i = 2 * i + 2;
        }
      } else {
        // Tree is heapified
        return;
      }
    }
  }

  // Heapification process after insertion
  // Complexity O(logn)
  private void heapifyUp(int i) {
    while (i > 0) {
      // If added element is greater than its parent, swap
      if (parent(i) > elements.get(i)) {
        swap(i, ((i - 1) / 2));
      } else {
        return;
      }
      // Move index of inserted node to parent position
      i = ((i - 1) / 2);
    }
  }

  // Takes in an array of values and returns a valid heap
  // this can be used by sort() and the third overload constructor
  // Complexity O(nlogn)
  private Vector<Integer> heapify(int[] array) {

    // Start iterating from last non-leaf node
    for (int i = array.length / 2 - 1; i >= 0; i--) {
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      int parent = i;
      int temp;

      // If one or both children index's are less than the size of the array and
      // largest child
      while ((left < array.length && array[left] < array[parent])
          || (right < array.length && array[right] < array[parent])) {
        // Swap larger child
        if (right >= array.length || array[left] < array[right]) {
          // Swap parent and left child
          temp = array[left];
          array[left] = array[parent];
          array[parent] = temp;
          // Assign parent index to left child
          parent = left;
        } else {
          // Swap parent with right child
          temp = array[right];
          array[right] = array[parent];
          array[parent] = temp;
          // Assign parent index to right child
          parent = right;
        }
        // Set new child index's
        left = 2 * parent + 1;
        right = 2 * parent + 2;
      }
    }

    // Create new vector
    Vector<Integer> vector = new Vector<Integer>(array.length);

    // Copy array over
    for (int i = 0; i < array.length; i++) {
      vector.add(array[i]);
    }
    return vector;
  }
}
