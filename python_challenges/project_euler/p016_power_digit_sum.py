__author__ = 'tbruckhaus'


class PowerDigitSum:
    # Power digit sum
    # Problem 16
    #
    # 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
    #
    # What is the sum of the digits of the number 21000?

    def __init__(self):
        pass

    @staticmethod
    def find(n):
        return PowerDigitSum.get_digit_sum(2 ** n)

    @staticmethod
    def get_digit_sum(n):
        digit_sum = 0
        while n > 0:
            digit_sum += n % 10
            n /= 10
        return digit_sum


if __name__ == '__main__':
    s = PowerDigitSum.find(1000)
    print "The sum of the digits of the number 2^1000 is", s
