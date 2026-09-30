class Node:
    def __init__(self, data):
        self.data = data
        self.left: Node = None
        self.right: Node = None

    def __str__(self):
        return str(self.data)


from Queue import Queue


class BineryTree:

    def __init__(self):
        self.root: Node = None
        self.count = 0
        print(" ----------------bt------------------  ")

    def Insert(self, value):
        if self.find(self.root, value):
            print("Item already exists in the tree")
            return
        new_node = Node(value)
        if self.root is None:
            self.root = new_node
            self.count += 1
            print(str(value) + " Item added to the tree")
            return

        queue = Queue()
        queue.enqueue(self.root)
        while not queue.isEmpty():
            current = queue.dequeue()
            if current.left is None:
                current.left = new_node
                self.count += 1
                print(str(value) + " Item added to the tree")
                return
            elif current.right is None:
                current.right = new_node
                self.count += 1
                print(str(value) + " Item added to the tree")
                return
            else:
                queue.enqueue(current.left)
                queue.enqueue(current.right)

    def traverse_inorder(self, root: Node):
        if root is None:
            return
        self.traverse_inorder(root.left)
        print(root.data, end=" -> ")
        self.traverse_inorder(root.right)

    def traversepreorder(self, root: Node):
        if root is None:
            return
        print(root.data, end=" -> ")
        self.traversepreorder(root.left)
        self.traversepreorder(root.right)

    def traversepostorder(self, root: Node):
        if root is None:
            return
        self.traversepostorder(root.left)
        self.traversepostorder(root.right)
        print(root.data, end=" -> ")

    def traverselevelorder(self, root: Node):
        if root is None:
            print("The tree is empty")
            return
        q = Queue()
        q.enqueue(root)
        while not q.isEmpty():
            current: Node = q.dequeue()
            print(current, end=" -> ")
            if current.left != None:
                q.enqueue(current.left)
            if current.right != None:
                q.enqueue(current.right)

    def size(self):
        return self.count

    def remove(self, root: Node, item):
        if root is None:
            return
        if item == self.root.data:
            if self.root.left is None and self.root.right is None:
                self.count = 0
                self.root = None
                return self.root
            else:
                x = self.root.left.data
                self.root.left = self.remove(self.root.left, self.root.left.data)
                self.root.data = x
                return self.root
        if item != root.data:
            root.left = self.remove(root.left, item)
            root.right = self.remove(root.right, item)
        else:
            if root.left is None and root.right is None:
                self.count -= 1
                root = None
                return None
            elif root.left is None and root.right is not None:
                self.count -= 1
                return root.right
            else:
                self.count -= 1
                return root.left
        return root

    def find(self, root: Node, item):
        if root is None:
            return False
        # base case:
        if root.data == item:
            return True
        if item != root.data:
            return self.find(root.left, item) or self.find(root.right, item)
