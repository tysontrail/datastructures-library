package com.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BST {

  StudentBNode root;

  public BST() {
    setRoot(null);
  }

  public StudentBNode getRoot() {
    return root;
  }

  public void setRoot(StudentBNode root) {
    this.root = root;
  }

  // Inserts the node object to the tree in its correct position as a leaf
  public void insert(StudentBNode nodeToInsert) {

    // Set pointer to root node
    StudentBNode current = getRoot(), parent = null;

    // Search through tree
    while (current != null) {
      parent = current;
      if (current.getStudent().compareTo(nodeToInsert.getStudent()) > 0) {
        // If node to insert is lower than current, move current left
        current = current.getLeft();
      } else {
        // If node to insert is higher than current, move current right
        current = current.getRight();
      }
    }

    // If root is null, tree is empty and node is inserted as root
    if (getRoot() == null) {
      setRoot(nodeToInsert);
    } else if (parent.getStudent().compareTo(nodeToInsert.getStudent()) > 0) {
      // If node to insert is lower, insert to the left
      parent.setLeft(nodeToInsert);
      nodeToInsert.setParent(parent);
    } else {
      // Node to insert is higher, insert to the right
      parent.setRight(nodeToInsert);
      nodeToInsert.setParent(parent);
    }
  }

  // Finds the node equivalent to the node_to_delete in the tree and removes it.
  // If an object of that value is not found then it prints to the user that the
  // object was not found
  public void delete(StudentBNode nodeToDelete) {

    StudentBNode current = getRoot();

    // Tree is empty; node to delete not found
    if (getRoot() == null) {
      System.out.println("Object to delete not found, tree is empty.");
      return;
    }

    // Search through tree until node to delete and parent are found
    while (current != null) {

      if (current.getStudent().compareTo(nodeToDelete.getStudent()) == 0) {
        break;
      } else if (current.getStudent().compareTo(nodeToDelete.getStudent()) > 0) {
        // If node to delete is lower than current, move current left
        current = current.getLeft();
      } else {
        // If node to delete is higher than current, move current right
        current = current.getRight();
      }

      // Node to delete not found, return
      if (current == null) {
        System.out.println("Object to delete not found.");
        return;
      }
    }

    // Case 1: If node to delete has no children (leaf node)
    if (current.getLeft() == null && current.getRight() == null) {
      // If current isn't root node
      if (current != getRoot())
        if (current.getParent().getLeft() != null
            && current.getParent().getLeft().getStudent().compareTo(nodeToDelete.getStudent())
                == 0) {
          // If node to delete is left pointer from parent, set to null
          current.getParent().setLeft(null);
        } else {
          // Node to delete is right pointer from parent, set to null
          current.getParent().setRight(null);
        }
      else {
        // If node to delete is only node in tree, set root to null
        setRoot(null);
      }
    }

    // Case 2: If node to delete has two children
    else if (current.getLeft() != null && current.getRight() != null) {

      // Find the smallest node in the right subtree of the node to delete
      StudentBNode smallest = current.getRight();
      while (smallest.getLeft() != null) {
        smallest = smallest.getLeft();
      }

      // Splice out smallest node

      // If node to delete right pointer is smallest
      if (smallest.getParent().getRight() != null
          && smallest.getParent().getRight().getStudent().compareTo(smallest.getStudent()) == 0) {

        // Set smallest parent node right pointer to smallest right child
        smallest.getParent().setRight(smallest.getRight());

        // If smallest is atleast one level down tree from node to delete
      } else {

        // Set smallest parent node left pointer to smallest right child
        smallest.getParent().setLeft(smallest.getRight());
      }
      // Copy smallest node Student data to node to delete
      current.setStudent(smallest.getStudent());

      // Set smallest right node parent pointer to smallest parent if it exists
      if (smallest.getRight() != null) {
        smallest.getRight().setParent(smallest.getParent());
      }
    }

    // Case 3: If node to delete has one child
    else {
      // Create child node
      StudentBNode child;

      // Assign child node
      if (current.getLeft() != null) {
        child = current.getLeft();
      } else {
        child = current.getRight();
      }

      // If node to be delete is not root node
      if (current != getRoot()) {
        if (current.getLeft() != null) {
          // If left child
          child.setParent(current.getParent());
          current.getParent().setLeft(child);
        } else {
          // If right child
          child.setParent(current.getParent());
          current.getParent().setRight(child);
        }
      } else {
        setRoot(child);
      }
    }
  }

  // Prints the tree content in order to the terminal using the print function
  // inside each node
  public void print(StudentBNode current) {
    if (current != null) {
      print(current.getLeft());
      current.print();
      print(current.getRight());
    }
  }

  // Writes the tree content in ascending to a file with the string output1 as
  // its name. make sure the file is well formatted by using fixed-width based
  // on the character limits provided in the first format table in the exercise
  public void printInOrderToFile(StudentBNode root_node, String output1) {
    try {
      // Create new print write object to write to output1
      PrintWriter writer = new PrintWriter(output1);

      // Create new current node from root
      StudentBNode current = root_node;

      // Call recursive write function with passed current node and writer object
      write(current, writer);

      // Close writer object
      writer.close();

    } catch (FileNotFoundException e) {
      System.out.println("File not found exception output1.");
      System.exit(0);
    }
  }

  // Recursively writes the tree content in ascending order left to right
  public void write(StudentBNode current, PrintWriter w) {
    if (current != null) {
      write(current.getLeft(), w);
      w.println(current);
      write(current.getRight(), w);
    }
  }

  // Writes the tree content using breadth-first left-right traversal to a file
  // with the string output2 as its name. make sure the file is well formatted by
  // using fixed-width based on the character limits provided in the first format
  // table in the exercise, and you must include the letter “I” at the start of
  // each line
  public void printBreadthToFile(StudentBNode root_node, String output2) {
    // If tree is empty
    if (root_node == null) {
      return;
    }

    try {
      // Create new print write object to write to output1
      PrintWriter writer = new PrintWriter(output2);

      // Create a queue
      Queue<StudentBNode> queue = new LinkedList<StudentBNode>();

      // Enqueu root node
      queue.add(root_node);

      while (queue.size() > 0) {
        // Remove node from queue
        StudentBNode studentBNode = queue.remove();
        // Print removed node
        writer.println("I" + studentBNode.toString());
        if (studentBNode.getLeft() != null) {
          // Enqueue left child
          queue.add(studentBNode.getLeft());
        }
        if (studentBNode.getRight() != null) {
          // Enqueue right child
          queue.add(studentBNode.getRight());
        }
      }
      // Close writer object
      writer.close();

    } catch (FileNotFoundException e) {
      System.out.println("File not found exception output2.");
    }
  }
}
