package mylib;

import java.util.Vector;

public class Heap {

  // The only member variable of these class is an object of the class vector to
  // hold the content of the heap. the vector object is of type integer and is named
  // elements
  protected Vector<Integer> elements;

  // Returns the size of the vector containing elements
  public int getSize() {
    return elements.size();
  }

  // Returns a Boolean True if the vector is empty, False otherwise
  public boolean isEmpty() {
    return elements.isEmpty();
  }

  // Clears the elements of the vector
  public void clear() {
    elements.clear();
  }

  // Searches for the value “ i ” in the heap
  public boolean contains(int i) {
    return elements.contains(i);
  }

  // Return parent of elements[i]
  protected int parent(int i) {
    return elements.get((i - 1) / 2);
  }

  // Returns left child of elements[i]
  protected int left(int i) {

    return elements.get(2 * i + 1);
  }

  // Returns right child of elements[i]
  protected int right(int i) {

    return elements.get(2 * i + 2);
  }

  // Swaps contents of indices x and y
  protected void swap(int x, int y) {
    int temp = elements.get(x);
    elements.set(x, elements.get(y));
    elements.set(y, temp);
  }

  //  displays the content of the heap vector over 2 lines. First line is the index of the
  // parent of each element. Second line are the elements themselves
  // for example:
  public void print() {

    for (int i = 0; i < getSize(); i++) {
      if (i == 0) {
        System.out.print("  ");
      } else if (((i - 1) / 2) < 10) {
        System.out.print("     ");
      } else if (((i - 1) / 2) < 100) {
        System.out.print("    ");
      } else {
        System.out.print("   ");
      }

      if (i > 0 && i < getSize()) {
        System.out.print((i - 1) / 2);
      } else {
        System.out.print(-1);
      }
    }

    System.out.println();

    for (int i = 0; i < getSize(); i++) {
      if (i == 0) {
        if (elements.get(i) < 10) {
          System.out.print("   ");
        } else if (elements.get(i) < 100) {
          System.out.print("  ");
        } else {
          System.out.print("  ");
        }
      } else if (elements.get(i) < 10) {
        System.out.print("     ");
      } else if (elements.get(i) < 100) {
        System.out.print("    ");
      } else {
        System.out.print("   ");
      }
      System.out.print(elements.get(i));
    }
    System.out.println();
  }
}
