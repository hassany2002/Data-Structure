public class Stack {

    int[] items;
    int count;
    int size ;
    int top ;


    // Constructor to initialize the stack
    public Stack(int size) {
        this.size = size;
        items = new int[size];
        top = -1;
        count = 0;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return  count == 0;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return  count == items.length;
    }

    // Push operation: Add an element to the stack
    public void push(int value) {
        if (this.isFull()) {
            System.out.println( " stack is full ");
            return;
        }

        for (int i=count; i>0;i--)
            items[i] = items[i-1];

        items[0] = value;
        top = items[0];
        count++;

        System.out.println(value + " pushed to stack");
    }

    // Pop operation: Remove and return the top element
    public int pop() {
        if (this.isEmpty()) {
            return top;
        }

        if (count == 1) {
            items[0] = 0;
            int x = top;
            top = 0;
            count--;
            return x;
        }

        int x = top;
        top = items[0];

        for (int i=0; i<count-1 ;i++)
            items[i] = items[i+1];

        count--;
        return x;

    }

    // Top operation: Return the top element without removing it
    public int top() {
        return  top;
    }

    // Display operation: Print all elements of the stack
    public void display() {

        for (int i=0; i<count ;i++)
            System.out.print(items[i] + " -> ");
        System.out.println("  ");

    }

}
