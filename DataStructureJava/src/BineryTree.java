public class BineryTree {

    class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;
    int count =0;

    public void Insert(int item) {

        Node newnode = new Node(item);
        Node current =root;

        if (count == 0){
            root = newnode;
            count ++;
            System.out.println( " " );
            System.out.println(newnode.data + "added");
            return;
        }

        while ((current.left != null && current.right != null) || current.right != null){
            if ((current.left != null && current.right != null)) {
                current = current.right;
            }
            else{
                current = current.left;
            }
        }

        if ((current.left == null && current.right == null) ){
            current.left = newnode;
            count ++;
            System.out.println( " " );
            System.out.println(newnode.data + "added");
            return;
        }
        else {
            current.right = newnode;
            count ++;
            System.out.println( " " );
            System.out.println(newnode.data + "added");
            return;
        }
    }

    public void traverse_inorder(Node root) {
        Node C = root;
        if (C == null)
            return;
        this.traverse_inorder(C.left);
        this.traverse_inorder(C.right);
    }

    public void traversepreorder(Node root) {
        Node C = root;
        if (C == null)
            return;
        System.out.print(C.data + "--->");
        this.traverse_inorder(C.left);
        this.traverse_inorder(C.right);
    }

    public void traversepostorder(Node root) {
        Node C = root;
        if (C == null)
            return;
        this.traverse_inorder(C.left);
        this.traverse_inorder(C.right);
        System.out.print(C.data + "--->");
    }

    public void traverselevelorder(Node root) {
        ArrayQueue q = new ArrayQueue(count);

        if (root == null){
            System.out.print( "EMPTY");
            return;}

        q.enqueue(root);

        while (!q.isEmpty()) {
            Node x = (Node) q.dequeue();
            System.out.print(x.data + "--->");
            if (x.left != null) {
                q.enqueue(x.left);
            }
            if (x.right != null) {
                q.enqueue(x.right);
            }
        }
    }

    public int size() {
        return count;
    }

    public Node remove(Node root ,int item) {
        Node current= root;

        if (current == null )
            return null;

        else if (current.data != item) {
            current.left = this.remove(current.left ,item);
            current.right= this.remove(current.right ,item);
        }

        else {
            // Case 1: leaf
            if (current.left == null && current.right == null) {
                count--;
                return null;
            }

            // Case 2: only right child
            if (current.left == null) {
                count--;
                return current.right;
            }

            // Case 3: only left child
            if (current.right == null) {
                count--;
                return current.left;
            }
            // Case 4: both children
            count--;
            return current.left;
        }

        return root;

    }

    public Node find(int item) {
        Node current =root;

        ArrayQueue q = new ArrayQueue(count);

        q.enqueue(current);

        if (current == null) {
            return null;
        }

        while (!q.isEmpty()) {
            Node x = (Node) q.dequeue();
            if (x.data == item) {
                return x;
            }
            if (x.left != null) {
                q.enqueue(x.left);
            }
            if (x.right != null) {
                q.enqueue(x.right);
            }
        }
        return null;
    }

}
