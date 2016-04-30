__author__ = 'tilmannbruckhaus'


class DoubleBasePalindrome:
    """
    Double-base palindromes
    Problem 36
    The decimal number, 585 = 1001001001 (base 2 binary), is palindromic in both bases.

    Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

    (Please note that the palindromic number, in either base, may not include leading zeros.)
    """

    def __init__(self):
        pass

    @staticmethod
    def find(n):
        d = DoubleBasePalindrome
        double_sum = 0
        for i in range(n):
            if d.is_double_palindrome(i):
                double_sum += i
        return double_sum

    @staticmethod
    def is_double_palindrome(i):
        d = DoubleBasePalindrome
        return d.is_palindrome(i, 10) and d.is_palindrome(i, 2)

    @staticmethod
    def is_palindrome(i, base):
        d = DoubleBasePalindrome
        if base == 10:
            return str(i) == str(i)[::-1]
        elif base == 2:
            i_base_2 = d.base_2(i)
            return i_base_2 == i_base_2[::-1]
        else:
            return False

    @staticmethod
    def base_2(i):
        result = ''
        r = ''
        while i > 0:
            r = i % 2
            i /= 2
            result = str(r) + result
        return result


if __name__ == '__main__':
    limit = 1000000
    d = DoubleBasePalindrome.find(limit)
    print "The sum of all numbers, less than", limit, ", which are palindromic in base 10 and base 2 is", d
