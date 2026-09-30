# Data Structures

This repository contains my implementations of common **Data Structures** using **Python** and **Java**.

The project is mainly for practicing and understanding how different data structures work and how they can be implemented from scratch.

##  Project Structure

```text
data-structure/
│
├── datastructure py/
│   ├── Stack.py
│   ├── Slinkedlist.py
│   ├── Queue.py
│   ├── PriorityQueue.py
│   ├── BineryTree.py
│   └── BinerySearchTree.py
│
└── datastructure java/
    └── data str/
        ├── Stack
        ├── Slinkedlist
        ├── Queue
        ├── PriorityQueue
        ├── BineryTree
        ├── BinerySearchTree
        └── DoublyLinkedList.java
```

##  Python

The Python folder contains implementations of:

* [Stack](https://github.com/hassany2002/data-structure/blob/main/datastructure%20py/Stack.py)
* [Singly Linked List](https://github.com/hassany2002/data-structure/blob/main/datastructure%20py/Slinkedlist.py)
* [Queue](https://github.com/hassany2002/data-structure/blob/main/datastructure%20py/Queue.py)
* [Priority Queue](https://github.com/hassany2002/data-structure/blob/main/datastructure%20py/PriorityQueue.py)
* [Binary Tree](https://github.com/hassany2002/data-structure/blob/main/datastructure%20py/BineryTree.py)
* [Binary Search Tree](https://github.com/hassany2002/data-structure/blob/main/datastructure%20py/BinerySearchTree.py)

##  Java

The Java folder contains implementations of the same main data structures, with an additional:

* Doubly Linked List — [DoublyLinkedList.java](https://github.com/hassany2002/data-structure/blob/main/datastructure%20java/data%20str/src/DoublyLinkedList.java)

##  Data Structures Covered

| Data Structure     | Python | Java |
| ------------------ | :----: | :--: |
| Stack              |    ✅   |   ✅  |
| Singly Linked List |    ✅   |   ✅  |
| Doubly Linked List |    ❌   |   ✅  |
| Queue              |    ✅   |   ✅  |
| Priority Queue     |    ✅   |   ✅  |
| Binary Tree        |    ✅   |   ✅  |
| Binary Search Tree |    ✅   |   ✅  |

##  Purpose

The purpose of this repository is to:

* Practice implementing data structures from scratch.
* Understand how data structures work internally.
* Improve problem-solving and programming skills.
* Practice the same concepts using both Python and Java.
* Build a collection of reusable data structure implementations.

##  Future Improvements

I plan to continue adding more data structures and algorithms as I learn them.

Possible additions include:

* Graph
* Heap
* Hash Table
* Sorting Algorithms
* Searching Algorithms
* Graph Algorithms

---

**Languages:** Python  | Java 


# examples
1- python stack
        s = Stack()
        s.push(5)
        s.push(15)
        s.push(30)
        s.push(50)
        s.display()
        print(" ----------------------------------  ")
        print("The top element is: " + str(s.top()))
        print(" ----------------------------------  ")
        print("The pop element is: " + str(s.pop()))
        s.display()
        print(" ----------------------------------  ")
        print("The size is: " + str(s.size()))

2- java BinerySearchTree
        BinerySearchTree q = new BinerySearchTree();
        q.Insert(5);
        q.Insert(3);
        q.Insert(7);
        q.Insert(9);
        q.Insert(1);
        q.Insert(9);
        System.out.println( "---------------------------------- ");
        System.out.println(q.count +" count ");
        System.out.println( "---------------------------------- ");
        q.traverse_inorder(q.root);
        System.out.println( " ----------------------------------");
        q.traversepreorder(q.root);
        System.out.println( "---------------------------------- ");
        q.traversepostorder(q.root);
        System.out.println( " ----------------------------------");
        q.traverselevelorder(q.root);
        System.out.println( "---------------------------------- ");
        q.remove(9);
        System.out.println(q.count+" count ");
        System.out.println( " ---------------------------------- ");
        q.traverse_inorder(q.root);
