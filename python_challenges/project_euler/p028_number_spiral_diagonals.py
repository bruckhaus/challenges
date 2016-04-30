__author__ = 'tilmannbruckhaus'


class NumberSpiralDiagonals:
    """
    Number spiral diagonals
    Problem 28
    Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

    21 22 23 24 25
    20  7  8  9 10
    19  6  1  2 11
    18  5  4  3 12
    17 16 15 14 13

    It can be verified that the sum of the numbers on the diagonals is 101.

    What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
    """

    def __init__(self, n):
        self.size = n
        self.spiral = None
        self.x = None
        self.y = None
        self.direction = None
        self.create_spiral()
        self.populate_spiral()

    def create_spiral(self):
        n = self.size
        self.spiral = [x[:] for x in [[0] * n] * n]

    def populate_spiral(self):
        self.x = self.size - 1
        self.y = 0
        self.direction = (0, -1)
        i = self.size * self.size
        while i > 0:
            self.spiral[self.y][self.x] = i
            i -= 1
            self.move()

    def move(self):
        if not self.direction_valid():
            if self.direction == (0, -1):
                self.direction = (1, 0)
            elif self.direction == (1, 0):
                self.direction = (0, 1)
            elif self.direction == (0, 1):
                self.direction = (-1, 0)
            else:
                self.direction = (0, -1)
        self.y += self.direction[0]
        self.x += self.direction[1]

    def direction_valid(self):
        row = self.y + self.direction[0]
        col = self.x + self.direction[1]
        if row < 0 or col < 0 or row >= self.size or col >= self.size:
            return False
        else:
            return self.spiral[row][col] == 0

    def diagonal_sum(self):
        result = 0
        n = self.size
        for i in range(n):
            result += self.spiral[i][i] + self.spiral[n - i - 1][i]
        mid = (n - 1) / 2
        result -= self.spiral[mid][mid]
        return result


if __name__ == '__main__':
    n = NumberSpiralDiagonals(1001).diagonal_sum()
    print "The sum of the numbers on the diagonals in a 1001 by 1001 spiral is", n
