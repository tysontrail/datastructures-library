package mylib;

import java.util.Vector;

public class MaxH extends Heap {

  // The only member variable of these class is an object of the class vector to
  // hold the content of the heap. the vector object is of type integer and is named elements
  private Vector<Integer> elements;

  // Default constructor initializes vector to no size
  public MaxH() {
    this.elements = new Vector(0);
  }

  // Overload constructor initializes vector to a size passed as argument
  public MaxH(int size) {
    this.elements = new Vector(size);
  }

  // Overload constructor creates a heap from an array and stores it in elements
  public MaxH(int array[]) {
    elements = heapify(array);
  }

  // Inserts the value key to the vector and maintains heap properties
  public void insert(int key) {}

  // Removes the value key from the vector and maintains heap properties
  public delete(int key) {}

  // Applies heapsort to the vector content
  // Uses heapify(int[] array)?
  public sort() {}

  // Heapification process after deletion
  private heapifyDown(int i) {}

  // Heapification process after insertion
  private heapifyUp(int i) {}

  // takes in an array of values and returns a valid heap
  // this can be used by sort() and the third overload constructor
  private Vector<Integer> heapify(int[] array) {}
}
