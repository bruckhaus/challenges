__author__ = 'tilmannbruckhaus'


class SumSquareDifference:

    # Sum square difference
    # Problem 6
    # The sum of the squares of the first ten natural numbers is,
    # 12 + 22 + ... + 102 = 385
    # The square of the sum of the first ten natural numbers is,
    # (1 + 2 + ... + 10)2 = 552 = 3025
    # Hence the difference between the sum of the squares of the first ten natural numbers
    # and the square of the sum is 3025 - 385 = 2640.
    # Find the difference between the sum of the squares of the first one hundred natural numbers
    # and the square of the sum.

    LIMIT = 100

    def __init__(self):
        pass

    @staticmethod
    def find():
        limit = SumSquareDifference.LIMIT
        return SumSquareDifference.square_of_sum(limit) - SumSquareDifference.sum_of_squares(limit)

    @staticmethod
    def sum_of_squares(n):
        result = 0
        for i in range(1, n + 1):
            result += i ** 2
        return result

    @staticmethod
    def square_of_sum(n):
        result = 0
        for i in range(1, n + 1):
            result += i
        return result ** 2

if __name__ == '__main__':
    print SumSquareDifference.find()
