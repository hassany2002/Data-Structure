public class Linkedliststack {

    class Node
    {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top;
    int count;

    // Constructor to initialize the stack

    public Linkedliststack() {
        top = null ;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return  top == null;
    }

    // Push operation: Adds an element to the top of the stack
    public void push(int value) {
        Node newnode = new Node(value);

        if (this.isEmpty()) {
            top = newnode;
            count++;
        }else {
            newnode.next = top;
            top = newnode;
            count++;
        }

        System.out.println(value + " pushed to Linkedliststack" );
    }

    // Pop operation: Removes and returns the top element from the stack
    public int pop() {

        if (this.isEmpty()) {
            System.out.println( " Linkedliststack is Empty ");
            return -1;
        }

        Node newnode = top;
        top = top.next;
        count--;
        return newnode.data;


    }

    // Top operation: Returns the top element without removing it
    public int top() {
        return top.data;
    }

//     Display operation: Prints all elements of the stack
    public void display() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


}
