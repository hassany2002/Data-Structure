public class ArrayQueue <T> {

    T[] items;
    int size ;
    int first ;
    int last;

    // Constructor


    public ArrayQueue(int size ) {
        this.size = size;
        items = (T[]) new Object[size];
        first = -1;
        last = -1;
    }

    // Check if the queue is full
    public boolean isFull() {
        return last == size-1;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return first == -1 || first > last;

    }

    // Enqueue operation
    public void enqueue(T value) {
        if (this.isFull()){
            System.out.println( " Queue is full ");
            return;
        }
        if (this.isEmpty()) {
            first = 0;
            last = -1;
        }
        items[++last] = value;
    }

    // Dequeue operation
    public T dequeue() {
        if (this.isEmpty()){
            System.out.println( " stack is empty ");
            return null;
        }
       return items[first++] ;
    }

    // Peek at the front element
    public T peek() {
        if (this.isEmpty()){
            System.out.println( " stack is empty ");
            return null;
        }
        return items[first] ;
    }

    // Display all elements in the queue
    public void display() {
        if (this.isEmpty()){
            System.out.println( " stack is empty ");
            return ;
        }
        for (int i=first; i<last+1 ;i++)
            System.out.print(items[i] + " -> ");
        System.out.println("  ");

    }


}
