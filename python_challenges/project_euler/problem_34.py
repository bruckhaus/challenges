import math

__author__ = 'tilmannbruckhaus'


class DigitFactorials:
    """
    Digit factorials
    Problem 34
    145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

    Find the sum of all numbers which are equal to the sum of the factorial of their digits.

    Note: as 1! = 1 and 2! = 2 are not sums they are not included.
    """

    def __init__(self):
        pass

    @staticmethod
    def find(n):
        d = DigitFactorials
        digit_factorial_sum = 0
        for i in range(3, n):
            if d.is_digit_factorial(i):
                if __name__ == '__main__':
                    print "found digit factorial:", i
                digit_factorial_sum += i
            if __name__ == '__main__':
                if i % 1000000 == 0:
                    print i
        return digit_factorial_sum

    @staticmethod
    def is_digit_factorial(i):
        factorial_sum = 0
        for digit in str(i):
            factorial_sum += math.factorial(int(digit))
        return factorial_sum == i


if __name__ == '__main__':
    d = DigitFactorials.find(10000000)
    print "The sum of all numbers which are equal to the sum of the factorial of their digits is", d
