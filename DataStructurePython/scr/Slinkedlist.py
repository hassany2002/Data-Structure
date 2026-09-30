class Node:
    def __init__(self, data):
        self.data = data
        self.next: Node = None


class Slinkedlist:
    def __init__(self):
        self.head: Node = None

    def Append(self, item):
        if self.head is None:
            self.head = Node(item)
            return
        current = self.head
        while current.next:
            current = current.next
        current.next = Node(item)

    def InsertFirst(self, item):
        if self.head is None:
            self.head = Node(item)
            return
        new_node = Node(item)
        new_node.next = self.head
        self.head = new_node

    def InsertatPosition(self, item, position: int):
        if position < 0 or position > self.length():
            print("Invalid position")
            return
        if position == 0:
            self.InsertFirst(item)
            return
        new_node = Node(item)
        index = 0
        current = self.head
        while index < position - 1:
            current = current.next
            index += 1
        new_node.next = current.next
        current.next = new_node

    def traverse(
        self,
    ):
        current = self.head
        while current:
            print(current.data, end=" -> ")
            current = current.next
        print("None")

    def delete(self, item):
        if self.length() == 0:
            print("The list is empty")
            return
        if self.head.data == item:
            self.head = self.head.next
            return
        current = self.head
        while current.next:
            if current.next.data == item:
                current.next = current.next.next
                return
            current = current.next
        print("Item not found")

    def deletepos(self, position: int):
        if position < 0 or position > self.length():
            print("Invalid position")
            return
        if self.length() == 0:
            print("The list is empty")
            return
        if position == 0:
            self.head = self.head.next
            return
        current = self.head
        index = 0
        while index < position - 1:
            current = current.next
            index += 1
        current.next = current.next.next

    def length(self):
        current = self.head
        count = 0
        while current:
            count += 1
            current = current.next
        return count

    def search(self, item):
        current = self.head
        while current:
            if current.data == item:
                return True
            current = current.next
        return False

    def merge(self, l: Slinkedlist):
        if l.head is None:
            print("The other list is empty")
            return
        current = self.head
        while current.next:
            current = current.next
        current.next = l.head

    def sort(self):
        if self.head is None:
            return
        current = self.head
        while current:
            index = current.next
            while index:
                if current.data > index.data:
                    current.data, index.data = index.data, current.data
                index = index.next
            current = current.next

    def reverse(self):
        pre = None
        current = self.head
        next_node = self.head.next
        self.head.next = None
        while next_node:
            pre = current
            current = next_node
            next_node = next_node.next
            current.next = pre
        current.next = pre
        self.head = current
