package mylib;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

  // TNode root: references the root of the tree
  TNode root;

  // Default constructor initializing root to null
  public BST() {
    setRoot(null);
  }

  // Overload constructor BST(int val) which takes in an integer value,
  // and creates a TNode and use it as root
  public BST(int val) {
    TNode rootNode = new TNode(val, 0, null, null, null);
    setRoot(rootNode);
  }

  // Overload constructor BST(TNode obj) which takes a TNode as an argument and use it as the
  // root of the tree. The TNode obj can have children which would make this tree object reference a
  // sub-tree structure
  public BST(TNode obj) {
    setRoot(obj);
  }

  // Setter and getter for root
  public TNode getRoot() {
    return this.root;
  }

  public void setRoot(TNode root) {
    this.root = root;
  }

  // Insert(TNode node) : inserts the node passed as argument into the tree
  public void insert(TNode node) {

    // Set pointer to root node
    TNode current = getRoot(), parent = null;

    // Search through tree
    while (current != null) {
      parent = current;
      if (current.getData() > node.getData()) {
        // If node to insert is lower than current, move current left
        current = current.getLeft();
      } else {
        // If node to insert is higher than current, move current right
        current = current.getRight();
      }
    }

    // If root is null, tree is empty and node is inserted as root
    if (getRoot() == null) {
      setRoot(node);
    } else if (parent.getData() > node.getData()) {
      // If node to insert is lower, insert to the left
      parent.setLeft(node);
      node.setParent(parent);
    } else {
      // Node to insert is higher, insert to the right
      parent.setRight(node);
      node.setParent(parent);
    }
  }

  // Insert(int val): creates a new node with data val to be inserted into the tree
  public void insert(int val) {

    TNode nodeToInsert = new TNode(val, 0, null, null, null);

    // Set pointer to root node
    TNode current = getRoot(), parent = null;

    // Search through tree
    while (current != null) {
      parent = current;
      if (current.getData() > nodeToInsert.getData()) {
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
    } else if (parent.getData() > nodeToInsert.getData()) {
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
  public void delete(int val) {

    TNode nodeToDelete = new TNode();
    TNode current = getRoot();

    // Tree is empty; node to delete not found
    if (getRoot() == null) {
      System.out.println("Object to delete not found, tree is empty.");
      return;
    }

    // Search through tree until node to delete and parent are found
    while (current != null) {

      if (current.getData() == nodeToDelete.getData()) {
        break;
      } else if (current.getData() > nodeToDelete.getData()) {
        // If node to delete is lower than current, move current left
        current = current.getLeft();
      } else {
        // If node to delete is higher than current, move current right
        current = current.getRight();
      }

      // Node to delete not found, return
      if (current == null) {
        System.out.println("Object to delete not found in BST tree.");
        return;
      }
    }

    // Case 1: If node to delete has no children (leaf node)
    if (current.getLeft() == null && current.getRight() == null) {
      // If current isn't root node
      if (current != getRoot())
        if (current.getParent().getLeft() != null
            && current.getParent().getLeft().getData() == nodeToDelete.getData()) {
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
      TNode smallest = current.getRight();
      while (smallest.getLeft() != null) {
        smallest = smallest.getLeft();
      }

      // Splice out smallest node

      // If node to delete right pointer is smallest
      if (smallest.getParent().getRight() != null
          && smallest.getParent().getRight().getData() == smallest.getData()) {

        // Set smallest parent node right pointer to smallest right child
        smallest.getParent().setRight(smallest.getRight());

        // If smallest is atleast one level down tree from node to delete
      } else {

        // Set smallest parent node left pointer to smallest right child
        smallest.getParent().setLeft(smallest.getRight());
      }
      // Copy smallest node Student data to node to delete
      current.setData(smallest.getData());

      // Set smallest right node parent pointer to smallest parent if it exists
      if (smallest.getRight() != null) {
        smallest.getRight().setParent(smallest.getParent());
      }
    }

    // Case 3: If node to delete has one child
    else {
      // Create child node
      TNode child;

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
  public void printInOrder(TNode current) {
    if (current != null) {
      printInOrder(current.getLeft());
      current.print();
      printInOrder(current.getRight());
    }
  }

  // prints the content of the tree in Breadth-First order, each level of the
  // tree will be printed on a separate line
  public void printBF() {
    // If tree is empty
    if (getRoot() == null) {
      return;
    } else {

      // Create a queue
      Queue<TNode> queue = new LinkedList<TNode>();

      // Enqueu root node
      queue.add(getRoot());

      while (queue.size() > 0) {
        // Remove node from queue
        TNode studentBNode = queue.remove();
        // Print removed node
        System.out.println(studentBNode.toString());
        if (studentBNode.getLeft() != null) {
          // Enqueue left child
          queue.add(studentBNode.getLeft());
        }
        if (studentBNode.getRight() != null) {
          // Enqueue right child
          queue.add(studentBNode.getRight());
        }
      }
    }
  }
}
