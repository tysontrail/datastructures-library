package com.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class AVL extends BST {

  AVLNode root;

  public AVL() {
    setRoot(null);
  }

  public AVLNode getRoot() {
    return root;
  }

  public void setRoot(AVLNode root) {
    this.root = root;
  }

  // Inserts the node object to the tree in its correct position as a leaf
  public void insert(AVLNode nodeToInsert) {

    // Set pointer to root node
    AVLNode current = getRoot();
    AVLNode lastNode = null;
    AVLNode pivot = null;

    // Search through tree
    while (current != null) {
      lastNode = current;
      // Set pivot node if current balance isn't one
      if (current.getBalance() != 0) {
        pivot = current;
      }
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
    } else if (lastNode.getStudent().compareTo(nodeToInsert.getStudent()) > 0) {
      // If node to insert is lower, insert to the left
      lastNode.setLeft(nodeToInsert);
      nodeToInsert.setParent(lastNode);
    } else {
      // Node to insert is higher, insert to the right
      lastNode.setRight(nodeToInsert);
      nodeToInsert.setParent(lastNode);
    }

    rebalance(nodeToInsert, pivot);
  }

  public void rebalance(AVLNode nodeToInsert, AVLNode pivot) {

    AVLNode current, ancestor, son, grandson, temp;
    // Case 1 Adding to a subtree with all 0 balances

    // Adjust the balances for all nodes from the inserted node up to the root node
    // (i.e. all nodes on the search path)
    if (pivot == null) {
      nodeToInsert.setBalance(0);
      current = nodeToInsert.getParent();
      while (current != null) {
        if (current.getStudent().compareTo(nodeToInsert.getStudent()) > 0) {
          current.decrementBalance();
        } else {
          current.incrementBalance();
        }
        current = current.getParent();
      }
      return;
    }

    // Case 2: a pivot exists, and a node is added to the shorter subtree

    // Pivot == +1 and inserted node < pivot node OR
    // Pivot == -1 and inserted node > pivot node
    // Adjust the balances for all nodes from the inserted node up to and including the pivot node
    else if ((pivot.getBalance() == +1
            && nodeToInsert.getStudent().compareTo(pivot.getStudent()) < 0)
        || (pivot.getBalance() == -1
            && nodeToInsert.getStudent().compareTo(pivot.getStudent()) > 0)) {

      nodeToInsert.setBalance(0);

      current = nodeToInsert;

      while (current.getStudent().compareTo(pivot.getStudent()) != 0) {
        current = current.getParent();
        if (current.getStudent().compareTo(nodeToInsert.getStudent()) > 0) {
          current.decrementBalance();
        } else {
          current.incrementBalance();
        }
      }
      return;
    }
    // Case 3 A pivot exists
    // Essentially, the tree gets unbalanced even more, The pivot’s balance changes to ± 2
    // The shape of the tree must be adjusted after doing the insertion

    // left heavy
    else if (pivot.getBalance() == -1) {
      ancestor = pivot.getParent();
      son = pivot.getLeft();

      // Outside case 3a
      if (nodeToInsert.getStudent().compareTo(son.getStudent()) < 0) {
        // Do a right rotation (Clockwise) if the outside subtree is on the left (the pivot is
        // negative)

        // In the case of pivot being root, skip the ancestor part
        if (ancestor == null) {
          setRoot(son);
          son.setParent(null);

        } else if (ancestor.getStudent().compareTo(nodeToInsert.getStudent()) > 0) {
          ancestor.setLeft(son);
          son.setParent(ancestor);

        } else {
          ancestor.setRight(son);
          son.setParent(ancestor);
        }

        // Swap
        temp = son.getRight();
        pivot.setLeft(temp);

        son.setRight(pivot);
        pivot.setParent(son);

        // Adjust balances of affected nodes
        // Set pivot and inserted node to 0
        pivot.setBalance(0);
        nodeToInsert.setBalance(0);
        if (nodeToInsert.getParent() != son) {
          if (nodeToInsert.getStudent().compareTo(nodeToInsert.getParent().getStudent()) < 0)
            nodeToInsert.getParent().setBalance(-1);
          else {
            nodeToInsert.getParent().setBalance(+1);
          }
        }

        return;

        // Case 3b: adding a node to the inside subtree
        // Adding to the left tree on the inside, LR Rotation
      } else {
        grandson = son.getRight();

        // Left rotation at son

        // Set pivots left child pointer to grandson node
        pivot.setLeft(grandson);
        grandson.setParent(pivot);

        // Set son's right child pointer to grandson's right subtree
        // (if it exists) otherwise set to null
        if (grandson.getLeft() != null) {
          son.setRight(grandson.getLeft());
          son.getRight().setParent(son);
        } else {
          son.setRight(null);
        }

        // Set grandson's left child pointer to son node
        grandson.setLeft(son);
        son.setParent(grandson);

        // Right rotation through pivot

        // If there is no ancestor, set the root pointer to grandson;
        if (ancestor == null) {

          setRoot(grandson);
          grandson.setParent(null);

          // if pivot < ancestor, set the ancestor’s left child pointer to
          // the grandson
        } else if (pivot.getStudent().compareTo(ancestor.getStudent()) < 0) {

          ancestor.setLeft(grandson);
          grandson.setParent(ancestor);

          // else set the left child pointer
        } else {

          ancestor.setRight(grandson);
          grandson.setParent(ancestor);
        }

        // Set pivot’s left child pointer to grandson’s right subtree
        // (if it exists), else set to null
        if (grandson.getRight() != null) {

          pivot.setLeft(grandson.getRight());
          pivot.getLeft().setParent(pivot);

        } else {
          pivot.setLeft(null);
        }

        // Set grandson’s right child pointer to pivot
        grandson.setRight(pivot);
        pivot.setParent(grandson);

        // Adjust balances of affected nodes

        // Set inserted node to 0
        nodeToInsert.setBalance(0);

        if (nodeToInsert.getStudent().compareTo(grandson.getStudent()) < 0) {
          pivot.setBalance(1);

        } else if (nodeToInsert == grandson) {
          pivot.setBalance(0);

        } else {
          pivot.setBalance(0);
          son.setBalance(-1);
        }

        current = nodeToInsert;
        while (current != null || current.getParent() != son) {
          current = current.getParent();
          if (current.getStudent().compareTo(nodeToInsert.getStudent()) > 0) {
            current.decrementBalance();
          } else {
            current.incrementBalance();
          }
        }
        return;
      }

      // Right heavy
    } else if (pivot.getBalance() == 1) {
      ancestor = pivot.getParent();
      son = pivot.getRight();

      // outside case 3a
      if (nodeToInsert.getStudent().compareTo(son.getStudent()) > 0) {
        // Do a left rotation if the outside subtree

        // In the case of pivot being root, skip the ancestor part
        if (ancestor == null) {
          setRoot(son);
          son.setParent(null);
        } else if (ancestor.getStudent().compareTo(nodeToInsert.getStudent()) < 0) {
          ancestor.setRight(son);
          son.setParent(ancestor);

        } else {
          ancestor.setLeft(son);
          son.setParent(ancestor);
        }
        // Swap nodes
        temp = son.getLeft();
        pivot.setRight(temp);

        son.setLeft(pivot);
        pivot.setParent(son);

        // Adjust balances of affected nodes
        // Set pivot and inserted node to 0
        pivot.setBalance(0);
        nodeToInsert.setBalance(0);
        if (nodeToInsert.getParent() != son) {
          if (nodeToInsert.getStudent().compareTo(nodeToInsert.getParent().getStudent()) < 0)
            nodeToInsert.getParent().setBalance(-1);
          else {
            nodeToInsert.getParent().setBalance(+1);
          }
        }
        return;

        // Inside case 3b
        // Adding to the right tree on the inside, RL Rotation
      } else {
        grandson = son.getLeft();

        // Right rotation at son

        // Set pivot’s right child pointer to grandson node
        pivot.setRight(grandson);
        grandson.setParent(pivot);

        // Set son’s left child pointer to grandson’s right subtree
        // (if it exists) otherwise set to null
        if (grandson.getRight() != null) {
          son.setLeft(grandson.getRight());
          son.getLeft().setParent(son);
        } else {
          son.setLeft(null);
        }

        // Set grandson’s right child pointer to son node
        grandson.setRight(son);
        son.setParent(grandson);

        // Left rotation through pivot

        // If there is no ancestor, set the root pointer to grandson;
        if (ancestor == null) {

          setRoot(grandson);
          grandson.setParent(null);

          // if pivot > ancestor, set the ancestor’s right child pointer to
          // the grandson
        } else if (pivot.getStudent().compareTo(ancestor.getStudent()) > 0) {

          ancestor.setRight(grandson);
          grandson.setParent(ancestor);

          // else set the left child pointer
        } else {

          ancestor.setLeft(grandson);
          grandson.setParent(ancestor);
        }

        // Set pivot’s right child pointer to grandson’s left subtree
        // (if it exists), else set to null
        if (grandson.getLeft() != null) {

          pivot.setRight(grandson.getLeft());
          pivot.getRight().setParent(pivot);

        } else {
          pivot.setRight(null);
        }

        // Set grandson’s left child pointer to pivot
        grandson.setLeft(pivot);
        pivot.setParent(grandson);

        // Adjust balances of affected nodes

        // Set inserted node to 0
        nodeToInsert.setBalance(0);

        // If inserted node > grandson set pivot to 1
        if (nodeToInsert.getStudent().compareTo(grandson.getStudent()) > 0) {
          pivot.setBalance(-1);
        } else if (nodeToInsert == grandson) {
          pivot.setBalance(0);
        } else {
          pivot.setBalance(0);
          son.setBalance(1);
        }
        return;
      }
    }
  }

  // Writes the tree content using breadth-first left-right traversal to a file
  // with the string output2 as its name. make sure the file is well formatted by
  // using fixed-width based on the character limits provided in the first format
  // table in the exercise, and you must include the letter “I” at the start of
  // each line
  public void printBreadthToFile(AVLNode root_node, String output2) {
    // If tree is empty
    if (root_node == null) {
      return;
    }

    try {
      // Create new print write object to write to output1
      PrintWriter writer = new PrintWriter(output2);

      // Create a queue
      Queue<AVLNode> queue = new LinkedList<AVLNode>();

      // Enqueu root node
      queue.add(root_node);

      while (queue.size() > 0) {
        // Remove node from queue
        AVLNode avlNode = queue.remove();
        // Print removed node
        writer.println("I" + avlNode.toString() + " " + avlNode.getBalance());
        if (avlNode.getLeft() != null) {
          // Enqueue left child
          queue.add(avlNode.getLeft());
        }
        if (avlNode.getRight() != null) {
          // Enqueue right child
          queue.add(avlNode.getRight());
        }
      }
      // Close writer object
      writer.close();

    } catch (FileNotFoundException e) {
      System.out.println("File not found exception output2.");
    }
  }
}
