class Queue:

    def __init__(self):
        self.Queue = []
        self.front = -1
        self.rear = -1
        self.count = 0

    def isEmpty(self):
        return self.count == 0 or self.front > self.rear

    def size(self):
        return self.count

    def enqueue(self, value):
        if self.isEmpty():
            self.front = 0
            self.rear = -1
        self.Queue.append(None)
        self.rear += 1
        self.Queue[self.rear] = value
        self.count += 1

    def dequeue(self):
        if self.isEmpty():
            print("Queue is empty")
            return None
        value = self.Queue[self.front]
        self.front += 1
        self.count -= 1
        return value

    def peek(self):
        if self.isEmpty():
            print("Queue is empty")
            return None
        return self.Queue[self.front]

    def display(self):
        if self.isEmpty():
            print("Queue is empty")
            return
        for i in range(self.front, self.rear + 1):
            print(self.Queue[i], end="--->")
        print(" end of Queue ")
