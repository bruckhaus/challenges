from collections import defaultdict


class NonAbundantSums:
    # Non-abundant sums
    # Problem 23
    # A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
    # For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
    # which means that 28 is a perfect number.
    #
    # A number n is called deficient if the sum of its proper divisors is less than n
    # and it is called abundant if this sum exceeds n.
    #
    # As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
    # the smallest number that can be written as the sum of two abundant numbers is 24.
    # By mathematical analysis, it can be shown that all integers greater than 28123 can be written as
    # the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis
    # even though it is known that the greatest number that cannot be expressed as the sum of two abundant
    # numbers is less than this limit.
    #
    # Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

    LIMIT = 28123
    abundant_numbers = []
    abundant_sums = defaultdict(lambda: False)

    def __init__(self):
        pass

    @classmethod
    def find(cls):
        n = NonAbundantSums
        n.find_abundant()
        if __name__ == '__main__':
            print "number abundant:", len(cls.abundant_numbers)
        n.mark_sums()
        if __name__ == '__main__':
            print "number sums:", len(cls.abundant_sums)
        return n.sum_non_abundant()

    @classmethod
    def find_abundant(cls):
        n = NonAbundantSums
        for i in range(2, cls.LIMIT):
            if n.abundant(i):
                cls.abundant_numbers.append(i)

    @classmethod
    def mark_sums(cls):
        a = cls.abundant_numbers
        n = len(a)
        for i in range(n):
            if a[i] > cls.LIMIT / 2:
                break
            for j in range(i, n):
                if a[i] + a[j] > cls.LIMIT:
                    break
                cls.abundant_sums[a[i] + a[j]] = True

    @classmethod
    def sum_non_abundant(cls):
        n = NonAbundantSums
        non_abundant_sum = 0
        for i in range(1, cls.LIMIT):
            if not n.abundant_sums[i]:
                non_abundant_sum += i
        return non_abundant_sum

    @staticmethod
    def abundant(i):
        n = NonAbundantSums
        return sum(n.divisors(i)) > i

    @staticmethod
    def divisors(n):
        divisors = []
        for i in range(1, n / 2 + 1):
            if n % i == 0:
                divisors.append(i)
        return divisors


if __name__ == '__main__':
    n = NonAbundantSums.find()
    print "The sum of all the positive integers which cannot be written as the sum of two abundant numbers is", n
