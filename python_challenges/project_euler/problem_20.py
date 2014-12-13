__author__ = 'tilmannbruckhaus'


class FactorialDigitSum:
    # Factorial digit sum
    # Problem 20
    # n! means n x (n - 1) x ... x 3 x 2 x 1
    #
    # For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
    # and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
    #
    # Find the sum of the digits in the number 100!

    def __init__(self):
        pass

    @staticmethod
    def find(n):
        factorial = 1
        for i in range(1, n + 1):
            factorial *= i
            if __name__ == '__main__':
                print i, factorial
        return FactorialDigitSum.digit_sum(factorial)

    @staticmethod
    def digit_sum(factorial):
        digit_sum = 0
        while True:
            if factorial <= 0:
                return digit_sum
            digit_sum += factorial % 10
            factorial /= 10


if __name__ == '__main__':
    f = FactorialDigitSum.find(100)
    print "The sum of the digits in the number 100! is", f
