__author__ = 'tilmannbruckhaus'


class Pandigital:
    def __init__(self):
        self.p = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        self.N = 10

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

    def get(self):
        return ''.join([str(d) for d in self.p])
