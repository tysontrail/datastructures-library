package mylib;

import java.util.LinkedList;
import java.util.Queue;

public class AVL extends BST {

  // References the root of the tree
  TNode root;

  // Default constructor initializing root to null
  public AVL() {
    this.root = null;
  }

  // Overload constructor AVL(int val) which takes in an integer value, and
  // creates a TNode and use it as root
  public AVL(int val) {
    setRoot(new TNode(val, 0, null, null, null));
  }

  // Overload constructor AVL(TNode obj) which takes a TNode as an
  // argument and use it as the root of the tree. If the TNode obj has children,
  // the constructor needs to create a balanced tree from passed tree by one of
  // the two following options: iteratively inserting nodes from the original tree
  // and balancing the new created AVL tree
  public AVL(TNode obj) {
    if (obj == null) {
      return;
    }

    // Set AVL root node data to passed bstRoot
    this.root = new TNode(obj.getData(), 0, null, null, null);

    // If obj has children, create AVL
    if (obj.getLeft() != null || obj.getRight() != null) {
      avlCreator(obj);
    }
  }

  public TNode getRoot() {
    return root;
  }

  // The setter function must check if the node has children, If children are found,
  // it must do the same as the overload constructor
  public void setRoot(TNode root) {
    if (root == null) {
      return;
    }

    this.root = root;

    // If obj has children, create AVL
    if (root.getLeft() != null || root.getRight() != null) {
      avlCreator(root);
    }
  }

  // AVL creator
  private void avlCreator(TNode bstRoot) {

    // Create a queue
    Queue<TNode> queue = new LinkedList<TNode>();

    // Enqueu root node
    queue.add(bstRoot);

    if (bstRoot.getLeft() != null) {
      // Enqueue left child
      queue.add(bstRoot.getLeft());
    }
    if (bstRoot.getRight() != null) {
      // Enqueue right child
      queue.add(bstRoot.getRight());
    }

    // Remove root node from queue
    queue.remove();

    while (queue.size() > 0) {

      // Remove node from queue
      TNode current = queue.remove();

      // Copy node data
      TNode avlNode = new TNode(current.getData(), 0, null, null, null);

      // Insert node into AVL
      insert(avlNode);

      if (current.getLeft() != null) {
        // Enqueue left child
        queue.add(current.getLeft());
      }
      if (current.getRight() != null) {
        // Enqueue right child
        queue.add(current.getRight());
      }
    }
  }

  // Inserts the node object to the tree in its correct position as a leaf
  public void insert(TNode nodeToInsert) {

    // Set pointer to root node
    TNode current = getRoot();
    TNode lastNode = null;
    TNode pivot = null;

    // Search through tree
    while (current != null) {
      lastNode = current;
      // Set pivot node if current balance isn't one
      if (current.getBalance() != 0) {
        pivot = current;
      }
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
      this.root = nodeToInsert;
    } else if (lastNode.getData() > nodeToInsert.getData()) {
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

  // Creates a new node with data val to be inserted into the tree
  public void insert(int val) {

    // Set pointer to root node
    TNode nodeToInsert = new TNode(val, 0, null, null, null);
    TNode current = getRoot();
    TNode lastNode = null;
    TNode pivot = null;

    // Search through tree
    while (current != null) {
      lastNode = current;
      // Set pivot node if current balance isn't one
      if (current.getBalance() != 0) {
        pivot = current;
      }
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
      this.root = nodeToInsert;
    } else if (lastNode.getData() > nodeToInsert.getData()) {
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

  public void rebalance(TNode nodeToInsert, TNode pivot) {

    TNode current, ancestor, son, grandson, temp;
    // Case 1 Adding to a subtree with all 0 balances

    // Adjust the balances for all nodes from the inserted node up to the root node
    // (i.e. all nodes on the search path)
    if (pivot == null) {
      nodeToInsert.setBalance(0);
      current = nodeToInsert.getParent();
      while (current != null) {
        if (current.getData() > nodeToInsert.getData()) {
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
    else if ((pivot.getBalance() == +1 && nodeToInsert.getData() < pivot.getData())
        || (pivot.getBalance() == -1 && nodeToInsert.getData() > pivot.getData())) {

      nodeToInsert.setBalance(0);

      current = nodeToInsert;
      // Adjust the balances for all nodes from the inserted node up to and
      // including the pivot node
      while (current.getData() != pivot.getData()) {
        current = current.getParent();
        if (current.getData() > nodeToInsert.getData()) {
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
      if (nodeToInsert.getData() < son.getData()) {
        // Do a right rotation (Clockwise) if the outside subtree is on the left (the pivot is
        // negative)

        // In the case of pivot being root, skip the ancestor part
        if (ancestor == null) {
          this.root = son;
          son.setParent(null);

        } else if (ancestor.getData() > nodeToInsert.getData()) {
          ancestor.setLeft(son);
          son.setParent(ancestor);

        } else {
          ancestor.setRight(son);
          son.setParent(ancestor);
        }

        // Swap
        temp = son.getRight();
        pivot.setLeft(temp);
        if (temp != null) {
          temp.setParent(pivot);
        }

        son.setRight(pivot);
        pivot.setParent(son);

        // Adjust balances of affected nodes
        // Set pivot and inserted node to 0
        pivot.setBalance(0);

        // Adjust the balances for all nodes above the inserted node,
        // up to the child of the son node

        current = nodeToInsert;
        while (current.getParent().getData() != son.getData()) {
          current = current.getParent();
          if (current.getData() > nodeToInsert.getData()) {
            current.decrementBalance();
          } else {
            current.incrementBalance();
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

          this.root = grandson;
          grandson.setParent(null);

          // if pivot < ancestor, set the ancestor’s left child pointer to
          // the grandson
        } else if (pivot.getData() < ancestor.getData()) {

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

        if (nodeToInsert.getData() < grandson.getData()) {
          pivot.setBalance(1);

        } else if (nodeToInsert == grandson) {
          pivot.setBalance(0);

        } else {
          pivot.setBalance(0);
          son.setBalance(-1);
        }

        // Adjust balances for all nodes above the inserted node up to the child
        // of the son or pivot
        current = nodeToInsert;
        if (ancestor == null) {
          while (current.getParent().getData() != son.getData()
              && current.getParent().getData() != pivot.getData()) {
            current = current.getParent();
            if (current.getData() > nodeToInsert.getData()) {
              current.decrementBalance();
            } else {
              current.incrementBalance();
            }
          }
        } else {
          while (current.getParent().getData() != son.getData()
              && current.getParent().getData() != pivot.getData()
              && current.getParent().getData() != ancestor.getData()) {
            current = current.getParent();
            if (current.getData() > nodeToInsert.getData()) {
              current.decrementBalance();
            } else {
              current.incrementBalance();
            }
          }
        }
        return;
      }

      // Right heavy
    } else if (pivot.getBalance() == 1) {
      ancestor = pivot.getParent();
      son = pivot.getRight();

      // outside case 3a
      if (nodeToInsert.getData() > son.getData()) {
        // Do a left rotation if the outside subtree

        // In the case of pivot being root, skip the ancestor part
        if (ancestor == null) {
          this.root = son;
          son.setParent(null);
        } else if (ancestor.getData() < nodeToInsert.getData()) {
          ancestor.setRight(son);
          son.setParent(ancestor);

        } else {
          ancestor.setLeft(son);
          son.setParent(ancestor);
        }
        // Swap nodes
        temp = son.getLeft();
        pivot.setRight(temp);
        if (temp != null) {
          temp.setParent(pivot);
        }

        son.setLeft(pivot);
        pivot.setParent(son);

        // Adjust balances of affected nodes
        // Set pivot and inserted node to 0
        pivot.setBalance(0);

        // Adjust the balances for all nodes above the inserted node,
        // up to the child of the son node
        current = nodeToInsert;
        while (current.getParent().getData() != son.getData()) {
          current = current.getParent();
          if (current.getData() > nodeToInsert.getData()) {
            current.decrementBalance();
          } else {
            current.incrementBalance();
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
        } else if (pivot.getData() > ancestor.getData()) {

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
        if (nodeToInsert.getData() > grandson.getData()) {
          pivot.setBalance(-1);
        } else if (nodeToInsert == grandson) {
          pivot.setBalance(0);
        } else {
          pivot.setBalance(0);
          son.setBalance(1);
        }

        // Adjust balances for all nodes above the inserted node up to the child
        // of the son or pivot
        current = nodeToInsert;
        if (ancestor == null) {
          while (current.getParent().getData() != son.getData()
              && current.getParent().getData() != pivot.getData()) {
            current = current.getParent();
            if (current.getData() > nodeToInsert.getData()) {
              current.decrementBalance();
            } else {
              current.incrementBalance();
            }
          }
        } else {
          while (current.getParent().getData() != son.getData()
              && current.getParent().getData() != pivot.getData()
              && current.getParent().getData() != ancestor.getData()) {
            current = current.getParent();
            if (current.getData() > nodeToInsert.getData()) {
              current.decrementBalance();
            } else {
              current.incrementBalance();
            }
          }
        }
        return;
      }
    }
  }
}
