class Node:
    def __init__(self, data):
        self.data = data
        self.left: Node = None
        self.right: Node = None

    def __str__(self):
        return str(self.data)


from Queue import Queue


class BinerySearchTree:

    def __init__(self):
        self.root: Node = None
        self.count = 0
        print(" ----------------bst------------------  ")

    def Insert(self, node: Node, item):
        if self.find(self.root, item):
            print("Item already exists in the tree")
            return
        if self.count == 0:
            self.root = Node(item)
            print(str(item) + " Item added to the tree")
            self.count += 1
            return self.root
        new_node = Node(item)
        # base case:
        if node is None:
            self.count += 1
            node = new_node
            print(str(item) + " Item added to the tree")
            return node
        else:
            if item < node.data:
                node.left = self.Insert(node.left, item)
            else:
                node.right = self.Insert(node.right, item)
        return node

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
        if item < root.data:
            root.left = self.remove(root.left, item)
        elif item > root.data:
            root.right = self.remove(root.right, item)
        else:
            if root.left is None and root.right is None:
                self.count -= 1
                root = None
                return None
            elif root.left is None and root.right is not None:
                self.count -= 1
                return root.right
            elif root.right is None and root.left is not None:
                self.count -= 1
                return root.left
            else:
                smallest = self.findsmallestright(root)
                root.data = smallest.data
                root.right = self.remove(root.right, smallest.data)
        return root

    def find(self, root: Node, item):
        if root is None:
            return False
        # base case:
        if root.data == item:
            return True
        if item < root.data:
            return self.find(root.left, item)
        else:
            return self.find(root.right, item)

    def findsmallestright(self, node):
        smallest = node.right
        while smallest.left:
            smallest = smallest.left
        return smallest
