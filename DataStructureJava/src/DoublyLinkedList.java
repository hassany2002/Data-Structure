public class DoublyLinkedList {

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }


    Node head;

    // Insertion at the end
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current; // Set previous pointer
    }
    // Traverse the list forward
    public void traverseForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Traverse the list backward
    public void traverseBackward() {
        Node current = head;
        if (current == null) return;
        // Go to the last node
        while (current.next != null) {
            current = current.next;
        }
        // Traverse backward
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.prev;
        }
        System.out.println("null");
    }
    // Insertion at a specific position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) { // Inserting at head
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            return;
        }
        Node current = head;
        int index = 0;
        // Traverse to the position just before the specified position
        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null) {
            System.out.println("Position is out of bounds.");
            return;
        }

        newNode.next = current.next;
        newNode.prev = current; // Set previous pointer
        if (current.next != null) {
            current.next.prev = newNode; // Set next node's previous pointer
        }
        current.next = newNode;
    }

    // Deletion by value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return; }

        Node current = head;
        // Check if the node to be deleted is the head node
        if (current.data == data) {
            if (current.next == null) { // Only one node
                head = null; // List becomes empty
            } else {
                head = current.next; // Move head to the next node
                head.prev = null; // Update previous of new head
            }
            return;
        }
        // Traverse the list to find the node to delete
        while (current != null) {
            if (current.data == data) {
                // Bypass the current node
                current.prev.next = current.next; // Link previous node to next node
                if (current.next != null) {
                    current.next.prev = current.prev; // Link next node to previous node
                }
                return;
            }
            current = current.next;
        }

        System.out.println("Value " + data + " not found.");
    }
    // Search for a value
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }



}
