__author__ = 'tilmannbruckhaus'


class LargestPalindrome:

    # Largest palindrome product
    # Problem 4
    # A palindromic number reads the same both ways.
    # The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 x 99.
    # Find the largest palindrome made from the product of two 3-digit numbers.

    def __init__(self):
        pass

    @staticmethod
    def is_palindrome(i):
        return i == int(str(i)[::-1])

    @staticmethod
    def find(digits):
        largest = 0
        factors = [0, 0]
        start = 10 ** (digits - 1)
        end = 10 ** digits
        for i in range(start, end):
            for j in range(i, end):
                candidate = i * j
                if LargestPalindrome.is_palindrome(candidate):
                    if candidate > largest:
                        factors = [i, j]
                        largest = candidate
        print "The largest palindrome made from the product of two", digits, "digit numbers is", \
            factors[0], "*", factors[1], "=", largest
        return largest

if __name__ == '__main__':
    for size in range(1, 4):
        LargestPalindrome().find(size)
