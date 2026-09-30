public class Slinkedlist {

    class Node
    {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void Append(int item)
    {
        Node n  =new Node(item);
        if (head==null)
            head=n;
        else
        {
            Node current =head;
            while(current.next!=null)
                current=current.next;

            current.next=n;

        }

    }
    public void InsertFirst(int item)
    {
        Node newNode = new Node(item); // Create a new node
        newNode.next = head;          // Link the new node to the current head
        head = newNode;               // Update the head to the new node
    }

    public void InsertatPosition(int item , int position)
    {
        Node newNode = new Node(item);
        // If inserting at the head (position 0)
        if (position == 0) {
            InsertFirst(item);
            return;
        }

        Node current = head;
        int index = 0;

        // Traverse to the position just before the specified position
        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        // If current is null, position is beyond the end of the list
        if (current == null) {
            System.out.println("Position is out of bounds.");
            return;
        }

        // Insert the new node
        newNode.next = current.next;
        current.next = newNode;
    }

    public void traverse()
    {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int size() {
        int count =0;
        Node current = head;
        while (current != null) {
            count ++;
            current = current.next;
        }
        return count;
    }


    public void delete(int item)
    {
        if (head == null) return; // empty list

        if (head.data == item)
        {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null)
        {
            if (current.next.data == item)
            {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    public int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    // Search for a value
    public Node search(int item) {
        Node current = head;
        while (current != null) {
            if (current.data == item) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    // Search for a position
    public Node possearch(int position) {
        Node current = head;
        while (position > 1) {
            position -= 1;
            current = current.next;
        }
        return current;
    }

    public void merge(Slinkedlist list2) {
        if (head == null) {
            head = list2.head;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = list2.head;
    }
    // Sort the linked list using Bubble Sort
    public void sort() {
        if (head == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
    // Reverse the linked list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }



//    public Slinkedlist mergesort(Slinkedlist list) {
//
//        Slinkedlist right = new Slinkedlist();
//        Slinkedlist left= new Slinkedlist();
//        Slinkedlist[] k = new Slinkedlist[2];
//
//        if (this.size()<=1)
//            return this;
//
//        k = this.mergesplit(list);
//        left = k[0].mergesort(k[0]);
//        right = k[1].mergesort(k[1]);
//
//        return merge(left, right);
//
//    }
//
//    public Slinkedlist[] mergesplit(Slinkedlist list) {
//
//        Slinkedlist right = new Slinkedlist() ;
//        Slinkedlist left = new Slinkedlist();
//
//        if (this.size()<=1) {
//            left = list;
//            right = null;
//            Slinkedlist[] k = {left, right};
//            return k;
//        }
//
//        int mid = (list.size() / 2) ;
//        Node a = possearch(mid);
//        right.head = a.next;
//        left =list;
//        a.next = null;
//        Slinkedlist[] k = {left, right};
//        return k;
//
//    }
//
//    public Slinkedlist merge(Slinkedlist l1,Slinkedlist l2) {
//        Slinkedlist x = new Slinkedlist();
//        x.head = null;
//        while (l1.head != null || l2.head != null){
//            if (l1.head == null) {
//                x.Append(l2.head.data);
//                l2.head = l2.head.next;
//            }
//            else if (l2.head == null) {
//                x.Append(l1.head.data);
//                l1.head = l1.head.next;
//            }
//            else if (l1.head.data>l2.head.data){
//                x.Append(l2.head.data);
//                l2.head =l2.head.next;
//            }
//            else if (l1.head.data<l2.head.data){
//                x.Append(l1.head.data);
//                l1.head =l1.head.next;
//            }
//        }
//        return x;
//    }

    public Slinkedlist mergesort(Slinkedlist list) {


        if (this.size()<=1)
            return this;

        Slinkedlist right = new Slinkedlist() ;
        Slinkedlist left = new Slinkedlist();
        MergeReturn x = new MergeReturn(left,right);
        x = this.mergesplit(list);
        left  = x.left().mergesort(x.left());
        right  = x.right().mergesort(x.right());

        return merge(left, right);

    }

    public MergeReturn mergesplit(Slinkedlist list) {

        Slinkedlist right = new Slinkedlist() ;
        Slinkedlist left = new Slinkedlist();

        if (this.size()<=1) {
            left = list;
            right = null;
            return new MergeReturn(left,right);
        }

        int mid = (list.size() / 2) ;
        Node a = possearch(mid);
        right.head = a.next;
        left =list;
        a.next = null;
        return new MergeReturn(left,right);
    }

    public Slinkedlist merge(Slinkedlist l1,Slinkedlist l2) {
        Slinkedlist x = new Slinkedlist();
        x.head = null;
        while (l1.head != null || l2.head != null){
            if (l1.head == null) {
                x.Append(l2.head.data);
                l2.head = l2.head.next;
            }
            else if (l2.head == null) {
                x.Append(l1.head.data);
                l1.head = l1.head.next;
            }
            else if (l1.head.data>l2.head.data){
                x.Append(l2.head.data);
                l2.head =l2.head.next;
            }
            else if (l1.head.data<l2.head.data){
                x.Append(l1.head.data);
                l1.head =l1.head.next;
            }
        }
        return x;
    }

}
