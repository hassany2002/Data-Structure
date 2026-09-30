public class Array <T> {

    public T[] items;

    public int count;

    Array(int size) {
        items = (T[]) new Object[size];
        count = 0;
    }

    boolean isFull() {
        return (count == items.length);
    }

    void Append(T item) {
        if (isFull()) {
            System.out.println("Array is Full , Cannot insert new items");
            return;
        } else {
            items[count++] = item;
        }

    }

    void Traverse() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }

    boolean Search(T item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item)
                return true;
        }
        return false;

    }

    public int getCount() {
        return count;
    }

    void Insert(int pos, T newitem) {
        if (isFull()) {
            System.out.println("Array is Full , Cannot insert new items");
            return;
        }
        for (int i = count; i > pos; i--)
            items[i] = items[i - 1];

        items[pos] = newitem;
        count++;
    }

    void Delete(int pos) {
        for (int i = pos; i < count - 1; i++)
            items[i] = items[i + 1];

        count--;

    }

    Array Enlarge(int newsize) {
        if (newsize > items.length) {
            Array newarray = new Array(newsize);
            for (int i = 0, j = 0; i < count; i++, j++)
                newarray.items[j] = this.items[i];

            return newarray;
        } else
            return this;
    }

    T[] Merge(T[] other) {
        T[] largeArray = (T[]) new Object[items.length + other.length];
        int index = 0;
        for (int i = 0; i < count; i++, index++)
            largeArray[index] = items[i];

        for (int j = 0; j < other.length; j++, index++)
            largeArray[index] = other[j];

        this.items = largeArray;
        this.count = this.count + other.length ;

        return largeArray;
    }

    public Array String(Array a){
        for (int i = 0; i < count; i++){
            System.out.println(items[i]);
        }
        return this;
    }

}