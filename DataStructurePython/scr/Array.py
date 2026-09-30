class Array:

    def __init__(self):
        self.items: list = []
        self.count: int = 0

    def is_empty(self):
        return self.count == 0

    def Append(self, item):
        self.items.append(item)
        self.count += 1

    def Traverse(self):
        for i in range(self.count):
            print(self.items[i])

    def Search(self, item):
        for i in self.items:
            if i == item:
                print(str(i) + " is found ")
                return True
        print(str(item) + " is not found")
        return False

    def getCount(self):
        return self.count

    def Insert(self, pos: int, newitem):
        if pos < 0 or pos > self.count:
            print("Invalid position")
            return

        self.items.append(
            None
        )  

        self.count += 1
        for i in range(self.count - 1, pos, -1):
            self.items[i] = self.items[i - 1]

        self.items[pos] = newitem
        return

    def Delete(self, pos: int):
        if pos < 0 or pos >= self.count - 1:
            print("Invalid position")
            return

        for i in range(pos, self.count - 1):
            self.items[i] = self.items[i + 1]

        self.count -= 1

    def Merge(self, other):
        if other.count == 0:
            print("The other array is empty")
            return

        x = self.count
        y = 1

        for i in other.items:
            if y > other.count:
                self.count += other.count
                return
            self.Insert(x, i)
            x += 1
            y += 1

    def __str__(self):
        for i in range(self.count):
            print(self.items[i])

        return "  "
