# Java ☕️ Data Structures Library
This is a Java library that provides implementations for several linear data structures including singly linked list, doubly linked list, circular linked list, circular doubly linked list, stack based singly linked list, and queue based singly linked list. Additionally, this library includes tree structures like binary search tree, AVL tree, and heap structures including vector-based min and max heaps. This library was developed as a collaborative effort, with KBaldwin2 (https://github.com/KBaldwin2) as a contributor.

## Usage 🦾
To use this library, simply include the relevant classes in your Java project. Each data structure is implemented in a separate class, and different node classes are also provided. The following is a brief overview of the classes provided in this library:

### Linear Data Structures
- SLL: A class that implements a singly linked list, where each node has a reference to the next node in the list.
- DLL: A class that implements a doubly linked list, where each node has a reference to the next and previous nodes in the list.
- CSLL: A class that implements a circular linked list, where the last node in the list has a reference to the first node.
- CDLL: A class that implements a circular doubly linked list, where the last node in the list has a reference to the first node and the first node has a reference to the last node.
- StackLL: A class that implements a stack data structure based on a singly linked list.
- QueueLL: A class that implements a queue data structure based on a singly linked list.
### Tree Structures
- BST: A class that implements a binary search tree, where each node has at most two children, and the left child is always less than the parent and the right child is always greater than the parent.
- AVL: A class that implements an AVL tree, which is a self-balancing binary search tree. This means that the heights of the left and right subtrees of each node differ by at most one. It extends BST.
### Heap Structures
- Heap: A class that implements a vector-based heap, extended by MinH and MaxH
- MinH: A class that implements a vector-based min heap, which is a binary tree where each node has a value that is less than or equal to the values of its children.
- MaxH: A class that implements a vector-based max heap, which is a binary tree where each node has a value that is greater than or equal to the values of its children.
### Node Classes
- DNode: A linear node class that is used for unidirectional linear structures without relying on the previous node.
- TNode: A general tree node class that can be used for both binary search tree and AVL tree.
Each class provides methods for inserting, deleting, and searching for nodes in the data structure.

## Contributing 🤝 
If you would like to contribute to this project, feel free to fork the repository and make your changes. Once you have made your changes, submit a pull request and we will review your changes.

## License 📝
This project is licensed under the MIT License. See the LICENSE file for more information.
