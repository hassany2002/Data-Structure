public class BinerySearchTree  {


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

        if ( this.find(item) != null ){
            System.out.println(item + "alraady exist");
            return;
        }

        Node newnode = new Node(item);
        Node current =root;
        Node prev =null;

        if (count == 0){
            root = newnode;
            count ++;
            System.out.println( " " );
            System.out.println(newnode.data + "added");
            return;
        }



        while (current.left != null || current.right != null){
            if (item < current.data) {
                prev = current;
                current = current.left;
                if (current == null){
                    current = prev;
                    break;}
            }
            else{
                prev = current;
                current = current.right;
                if (current == null){
                    current = prev;
                    break;}
            }
        }


        if (item < current.data){
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
        System.out.print(C.data + "--->");
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


    public int remove(int item) {
        Node remove = this.find(item);
        Node PRE = this.findprev(item);
        String dirction = this.findprevlorr(item);

        if (remove == null ){
            System.out.println( " " );
            System.out.println(item + "not found");
            return -1;}

        else if(remove.left == null && remove.right == null) {
            int r = remove.data;
            if (dirction == "LEFT")
                PRE.left = null;
            else
                PRE.right = null;
            count --;
            System.out.println( " " );
            System.out.println(r + "removed");
            return r;
        }

        else if(remove.left == null || remove.right == null) {
            if (remove.left == null){
                int r = remove.data;
                remove.data = remove.right.data;
                remove.right = remove.right.right;
                count --;
                System.out.println( " " );
                System.out.println(r + "removed");
                return r;
            }else {
                int r = remove.data;
                remove.data = remove.left.data;
                remove.left = remove.left.left;
                count --;
                System.out.println( " " );
                System.out.println(r + "removed");
                return r;
            }
        }

        else {
            int r = remove.data;
            int s = this.findsmallestright(remove).data;
            this.remove(this.findsmallestright(remove).data);
            remove.data = s;
            System.out.println( " " );
            System.out.println(r + "removed");
            return r;
        }

    }


    public Node find(int item) {
        Node current =root;
        Node prev =null;

        if (current==null)
            return null;

        while (current.left != null || current.right != null){
            if (item == current.data)
                return current;
            if (item < current.data) {
                prev =current;
                current = current.left;
                if (current == null){
                    current = prev;
                    return null;}
            }
            else{
                prev =current;
                current = current.right;
                if (current == null){
                    current = prev;
                    return null;}
            }

        }

        if (item == current.data)
            return current;

        return null;
    }


    public Node findsmallestright(Node x) {

        Node current =x;

        if (current.right.left != null){
            current = current.left;
        }
        else
            current = current.right;

        return current;
    }

    public Node findprev(int item) {
        Node current =root;
        Node prev =null;

        while (current.left != null || current.right != null){
            if (item == current.data)
                return prev;
            if (item < current.data) {
                prev =current;
                current = current.left;
                if (current == null){
                    current = prev;
                    return null;}
            }
            else{
                prev =current;
                current = current.right;
                if (current == null){
                    current = prev;
                    return null;}
            }

        }

        if (item == current.data)
            return prev;

        return null;
    }

    public String findprevlorr(int item) {
        Node current =root;
        Node prev =null;
        String prevSTR =null;

        while (current.left != null || current.right != null){
            if (item == current.data)
                return prevSTR;
            if (item < current.data) {
                prev =current;
                prevSTR ="LEFT";
                current = current.left;
                if (current == null){
                    current = prev;
                    return null;}
            }
            else{
                prev =current;
                prevSTR ="RIGHT";
                current = current.right;
                if (current == null){
                    current = prev;
                    return null;}
            }

        }

        if (item == current.data)
            return prevSTR;

        return null;
    }

}
