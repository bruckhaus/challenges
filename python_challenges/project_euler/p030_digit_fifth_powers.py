import math


class DigitFifthPowers:
    """
    Digit fifth powers
    Problem 30
    Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

    1634 = 1^4 + 6^4 + 3^4 + 4^4
    8208 = 8^4 + 2^4 + 0^4 + 8^4
    9474 = 9^4 + 4^4 + 7^4 + 4^4
    As 1 = 1^4 is not a sum it is not included.

    The sum of these numbers is 1634 + 8208 + 9474 = 19316.

    Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
    """

    def __init__(self):
        pass

    @staticmethod
    def find(n):
        d = DigitFifthPowers
        number_sum = 0
        for i in range(2, n + 1):
            number = d.power_sum(i)
            if i == number:
                if __name__ == '__main__':
                    print "i:", i, "number:", number
                number_sum += i
        return number_sum

    @staticmethod
    def power_sum(n):
        power_sum = 0
        for digit in str(n):
            power_sum += math.pow(int(digit), 5)
        return power_sum

    @staticmethod
    def find_limit():
        d = DigitFifthPowers
        digits = 0
        while True:
            digits += 1
            number = d.max_num(digits)
            power = d.power_sum(number)
            if power < number:
                return number

        return number

    @staticmethod
    def max_num(digits):
        return int("".join(["9"] * digits))


if __name__ == '__main__':
    d = DigitFifthPowers
    limit = d.find_limit()
    print "limit:", limit
    s = d.find(limit)
    print "The sum of all the numbers that can be written as the sum of fifth powers of their digits is", s
