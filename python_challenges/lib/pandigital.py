__author__ = 'tilmannbruckhaus'


class Pandigital:
    def __init__(self, digits):
        self.p = digits
        self.N = len(self.p)

    def find(self, n):
        for i in range(n - 1):
            self.step()
        return self.get()

    def step(self):
        # The algorithm is described in E. W. Dijkstra, A Discipline of Programming, Prentice-Hall, 1997, p. 71
        i = self.N - 1
        while self.p[i-1] >= self.p[i]:
            i -= 1
        j = self.N
        while self.p[j - 1] <= self.p[i - 1]:
            j -= 1
        self.swap(i-1, j-1)  # swap values at positions (i-1) and (j-1)
        i += 1
        j = self.N
        while i < j:
            self.swap(i-1, j-1)
            i += 1
            j -= 1

    def swap(self, i, j):
        swap = self.p[j]
        self.p[j] = self.p[i]
        self.p[i] = swap

    def next(self):
        if not self.has_next():
            return False
        self.step()
        return self.get()

    def has_next(self):
        return self.p != [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]

    def get(self):
        return ''.join([str(d) for d in self.p])
