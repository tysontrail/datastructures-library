package mylib;

import java.util.Vector;

public class MaxH extends Heap {

  // The only member variable of these class is an object of the class vector to
  // hold the content of the heap. the vector object is of type integer and is named elements
  private Vector<Integer> elements;

  // Default constructor initializes vector to no size
  public MaxH() {
    elements = new Vector<Integer>(0);
  }

  // Overload constructor initializes vector to a size passed as argument
  public MaxH(int size) {
    this.elements = new Vector<Integer>(size);
  }

  // Overload constructor creates a heap from an array and stores it in elements
  public MaxH(int array[]) {
    elements = heapify(array);
  }

  // Inserts the value key to the vector and maintains heap properties
  public void insert(int key) {
    elements.add(key);
    heapifyUp(getSize() - 1);
  }

  // Removes the value key from the vector and maintains heap properties
  public void delete(int key) {}

  // Applies heapsort to the vector content
  // Uses heapify(int[] array)?
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
      // Swap root/largest item with end item
      swap(0, i);
      // Create new int array
      int[] arr = new int[i + 1];
      // Copy values from elements
      for (int j = 0; j < i + 1; i++) {
        arr[j] = elements.get(j);
      }
      // Create new vector
      Vector<Integer> vector = new Vector<Integer>(arr.length);
      // Heapify arr
      vector = heapify(arr);
    }
  }

  // Heapification process after deletion
  private void heapifyDown(int i) {}

  // Heapification process after insertion
  private void heapifyUp(int i) {
    while (i > 0) {
      // If added element is greater than its parent, swap
      if (parent(i) < elements.get(i)) {
        swap(i, ((i - 1) / 2));
      }
      // Move index of inserted node to parent position
      i = ((i - 1) / 2);
    }
  }

  // Takes in an array of values and returns a valid heap
  // this can be used by sort() and the third overload constructor
  private Vector<Integer> heapify(int[] array) {

    // Start iterating from last non-leaf node
    for (int i = getSize() / 2 - 1; i >= 0; i--) {
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      int parent = i;
      int temp;

      // If one or both children index's are less than the size of the array and
      // largest child
      while ((left < array.length && array[left] > array[parent])
          || (right < array.length && array[right] > array[parent])) {
        // Swap larger child
        if (array[left] > array[right]) {
          // Swap parent and left child
          temp = array[left];
          array[left] = array[i];
          array[i] = temp;
          // Assign parent index to left child
          parent = left;
        } else {
          // Swap parent with right child
          temp = array[right];
          array[right] = array[i];
          array[i] = temp;
          // Assign parent index to right child
          parent = right;
        }
        // Set new child index's
        left = 2 * parent + 1;
        right = 2 * parent + 2;
      }

      Vector<Integer> vector = new Vector<Integer>(array.length);

      return vector;
    }
  }
}
