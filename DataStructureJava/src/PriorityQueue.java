import java.util.HashMap;
import java.util.Map;

//    min PriorityQueue
public class PriorityQueue {

    int[] heap;
    int size;
    int count;
    Map<Integer, Integer> x = new HashMap();


    // Constructor
    public PriorityQueue(int size) {
        this.size = size;
        heap = new int[size];
        for (int i = 0; i < size; i++) {
            heap[i] = -1;
        }
        count = 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return count == size;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return heap.length == 0;
    }

    // Enqueue operation
    public void insert(int value) {
        if (this.isFull()) {
            System.out.println(" PriorityQueue is full ");
            return;
        }

        heap[count] = value;
        x.put(heap[count], count);
        count += 1;
        System.out.println(value + " added ");
        this.swim(value);
    }

    // Dequeue operation
    public int poll() {
        if (isEmpty()) {
            System.out.println(" PriorityQueue is empty ");
            return -1;
        }

        int temp = heap[0];
        heap[0] = heap[count - 1];
        heap[count - 1] = 100;
        x.remove(temp, 0);
        x.replace(heap[0], 0);
        count -= 1;
        this.sink(heap[0]);

        return temp;
    }

    // Peek at the front element
    public int peek() {
        return heap[0];
    }

    public void swim(int value) {
        int pos = this.Search(value);
        int i = pos;
        for (i = pos; i > 0; ) {
            if (heap[i] < heap[(i - 1) / 2]) {
                int temp = heap[i];
                heap[i] = heap[(i - 1) / 2];
                heap[(i - 1) / 2] = temp;
                x.replace(heap[i], i);
                x.replace(heap[(i - 1) / 2], (i - 1) / 2);
                i = (i - 1) / 2;
                continue;
            }
            break;
        }
    }


    public void sink(int value) {
        int pos = this.Search(value);
        int i = pos;
        for (i = pos; i < size / 2; ) {
            if (heap[i] > heap[2 * i + 1] && heap[i] > heap[2 * i + 2]) {
                if (heap[2 * i + 1] > heap[2 * i + 2]) {
                    int temp = heap[i];
                    heap[i] = heap[2 * i + 2];
                    heap[2 * i + 2] = temp;
                    x.replace(heap[i], i);
                    x.replace(heap[2 * i + 2], 2 * i + 2);
                    i = 2 * i + 2;

                } else {
                    int temp = heap[i];
                    heap[i] = heap[2 * i + 1];
                    heap[2 * i + 1] = temp;
                    x.replace(heap[i], i);
                    x.replace(heap[2 * i + 1], 2 * i + 1);
                    i = 2 * i + 1;
                }
                continue;
            } else if (heap[i] > heap[2 * i + 1]) {
                int temp = heap[i];
                heap[i] = heap[2 * i + 1];
                heap[2 * i + 1] = temp;
                x.replace(heap[i], i);
                x.replace(heap[2 * i + 1], 2 * i + 1);
                i = 2 * i + 1;
                continue;
            } else if (heap[i] > heap[2 * i + 2]) {
                int temp = heap[i];
                heap[i] = heap[2 * i + 2];
                heap[2 * i + 2] = temp;
                x.replace(heap[i], i);
                x.replace(heap[2 * i + 2], 2 * i + 2);
                i = 2 * i + 2;
                continue;
            }
            break;
        }
    }

    public boolean isinvarint() {
        for (int i = 0; i < 3; i++) {
            if (heap[i] > heap[2 * i + 1] || heap[i] > heap[2 * i + 2])
                return false;
        }
        return true;
    }

    Integer Search(int item) {
        if (x.get(item) != null)
            return (x.get(item));
        return -1;
    }

    public int remove(int item) {
        if (isEmpty()) {
            System.out.println(" PriorityQueue is empty ");
            return -1;
        }

        int pos = this.Search(item);
        if (pos == -1) {
            System.out.println(" item  not here  ");
            return -1;
        }
        int temp = heap[pos];
        heap[pos] = heap[count - 1];
        heap[count - 1] = 100;
        x.remove(temp, pos);
        x.replace(heap[pos], pos);
        count -= 1;
        this.swim(heap[pos]);
        this.sink(heap[pos]);

        return temp;
    }


    // Display all elements in the queue
    public void display() {
        if (this.isEmpty()) {
            System.out.println(" PriorityQueue is empty ");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                System.out.print("        ");
                System.out.print(heap[i]);
            }
            if (i == 1 || i == 2) {
                System.out.print("     ");
                System.out.print(heap[i]);
            }
            if (i > 2) {
                System.out.print("  ");
                System.out.print(heap[i]);
            }
            if (i == 0 || i == 2 || i == 6)
                System.out.println("  ");
        }
        System.out.println("  ");

    }


    int m = 0;
    public void distance(int x) {
        if (x >= 1)
            m=11;
        if (x >= 3)
            m=9;
        if (x == 0)
            System.out.print("              ");
        else {
            for (int i = x; i < m; i++) {
                System.out.print(" ");
            }
        }
        m = 0;
    }

    public void display2() {
        if (this.isEmpty()) {
            System.out.println(" PriorityQueue is empty ");
            return;
        }
        for (int i = 0; i < count; i++) {
            this.distance(i);
            System.out.print(heap[i]);

            if (i == 0 || i == 2 || i == 6)
                System.out.println("  ");
        }
        System.out.println("  ");
    }

}





