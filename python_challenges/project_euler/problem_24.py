__author__ = 'tilmannbruckhaus'


class LexicographicPermutations:
    # Lexicographic permutations
    # Problem 24
    # A permutation is an ordered arrangement of objects.
    # For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
    # If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
    # The lexicographic permutations of 0, 1 and 2 are:
    #
    # 012   021   102   120   201   210
    #
    # What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

    def __init__(self):
        self.p = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        self.N = 10

    def find(self, n):
        for i in range(n - 1):
            self.step()
        return self.show()

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

    def show(self):
        s = ''
        for i in range(self.N):
            s += str(self.p[i])
        return s


if __name__ == '__main__':
    l = LexicographicPermutations().find(1000000)
    print "The millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9? is", l
