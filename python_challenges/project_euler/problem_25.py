__author__ = 'tbruckhaus'


class ThousandDigitFibonacciNumber:
    # 1000-digit Fibonacci number
    # Problem 25
    #
    # The Fibonacci sequence is defined by the recurrence relation:
    #
    #     Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.
    #
    # Hence the first 12 terms will be:
    #
    #     F1 = 1
    #     F2 = 1
    #     F3 = 2
    #     F4 = 3
    #     F5 = 5
    #     F6 = 8
    #     F7 = 13
    #     F8 = 21
    #     F9 = 34
    #     F10 = 55
    #     F11 = 89
    #     F12 = 144
    #
    # The 12th term, F12, is the first term to contain three digits.
    #
    # What is the first term in the Fibonacci sequence to contain 1000 digits?

    def __init__(self):
        pass

    @staticmethod
    def find(digits):
        last = 0
        this = 1
        term = 1
        while len(str(this)) < digits:
            term += 1
            new = last + this
            last = this
            this = new
        return term

if __name__ == '__main__':
    t = ThousandDigitFibonacciNumber.find(1000)
    print "The first term in the Fibonacci sequence to contain 1000 digits is", t
