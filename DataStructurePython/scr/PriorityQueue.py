class Min_PriorityQueue:

    def __init__(self):
        self.heap: list = []
        self.count: int = 0
        self.map: dict = {}
        print(" ----------------pq------------------  ")

    def isEmpty(self):
        return self.count == 0

    def insert(self, value):
        if self.Search(value) != False:
            print("Value already exists in the priority queue")
            return
        if self.isEmpty():
            self.heap.append(None)
            self.heap[self.count] = value
            self.map[value] = 0
            self.count += 1
            print(str(value) + " Value added")
            return
        self.heap.append(None)
        self.heap[self.count] = value
        self.map[value] = self.count
        self.count += 1
        self.swim(value)
        print(str(value) + " Value added")
        return

    def poll(self):
        if self.isEmpty():
            print("The priority queue is empty")
            return
        value = self.heap[0]
        self.heap[0] = self.heap[self.count - 1]
        self.count -= 1
        self.map[self.heap[0]] = 0
        self.sink(self.heap[0])
        self.map.__delitem__(value)
        return value

    def peek(self):
        if self.isEmpty():
            print("The priority queue is empty")
            return
        return self.heap[0]

    def swim(self, value):
        position = self.Search(value)
        if position == False:
            print("The value is not found in the priority queue")
            return
        while position > 0 and self.heap[position] < self.heap[(position - 1) // 2]:
            self.swap(position, (position - 1) // 2)
            position = (position - 1) // 2

    def sink(self, value):
        position = self.Search(value)
        if position is bool(False):
            print("The value is not found in the priority queue")
            return
        while position < self.count // 2 and (
            self.heap[position] > self.heap[2 * position + 1]
            or self.heap[position] > self.heap[2 * position + 2]
        ):
            if self.heap[2 * position + 1] < self.heap[2 * position + 2]:
                self.swap(position, 2 * position + 1)
                position = 2 * position + 1
            else:
                self.swap(position, 2 * position + 2)
                position = 2 * position + 2

    def swap(self, pos1, pos2):
        temp = self.heap[pos1]
        self.heap[pos1] = self.heap[pos2]
        self.heap[pos2] = temp
        self.map[self.heap[pos1]] = pos2
        self.map[self.heap[pos2]] = pos1

    def isinvarint(self):
        for i in range(self.count // 2):
            if (
                self.heap[i] > self.heap[2 * i + 1]
                or self.heap[i] > self.heap[2 * i + 2]
            ):
                return False
        return True

    def Search(self, item):
        try:
            # print(str(item) + " is found ")
            return self.map[item]
        except KeyError:
            # print(str(item) + " is not found")
            return False

    def remove(self, item):
        if self.isEmpty():
            print("The priority queue is empty")
            return
        if self.Search(item) == False:
            print("The item is not found in the priority queue")
            return
        index = self.search(item)
        value = self.heap[index]
        self.heap[index] = self.heap[self.count - 1]
        self.count -= 1
        self.map[self.heap[index]] = index
        self.sink(self.heap[index])
        self.swim(self.heap[index])
        self.map.__delitem__(value)
        return value

    def displaylevelorder(self):
        for i in range(self.count):
            print(self.heap[i], end=" __>")
        print("end of priority queue")
