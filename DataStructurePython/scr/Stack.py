class Stack:

    def __init__(self):
        self.stack = []
        self.top_index = -1
        self.count = 0
        self.bf = None

    def isEmpty(self):
        return self.count == 0

    def size(self):
        return self.count

    def push(self, value):
        self.stack.append(None)
        self.stack[self.count] = value
        self.top_index += 1
        self.count += 1

    def pop(self):
        if self.isEmpty():
            print("Stack is empty")
            return None
        value = self.stack[self.top_index]
        self.top_index -= 1
        self.count -= 1
        return value

    def top(self):
        return self.stack[self.top_index]

    def display(self):
        for i in range(self.count):
            print(self.stack[i], end="--->")
        print(" end of stack ")

    def back(self):
        if self.isEmpty() or self.bf == -1:
            print("cant go back, Stack is empty")
            return None
        if self.bf == None or self.bf > self.top_index:
            self.bf = self.top_index
        value = self.stack[self.bf]
        self.bf -= 1
        return value

    def forward(self):
        if self.isEmpty():
            print("Stack is empty")
            return None
        if self.bf == None or self.bf > self.top_index:
            print("cant go forward")
            return
        if self.bf == -1:
            self.bf += 1
        value = self.stack[self.bf]
        self.bf += 1
        return value
