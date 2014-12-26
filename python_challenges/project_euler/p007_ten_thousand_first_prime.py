__author__ = 'tilmannbruckhaus'

from collections import defaultdict


class TenThousandFirstPrime:
    # 10001st prime
    # Problem 7
    # By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
    # What is the 10 001st prime number?

    LIMIT = 1000000
    TARGET = 10001
    prime_dict = defaultdict(lambda: True)

    def __init__(self):
        pass

    @staticmethod
    def find():
        prime_count = 0
        t = TenThousandFirstPrime

        for i in range(2, t.LIMIT):

            if not t.prime_dict[i]:
                continue

            prime_count += 1
            if prime_count == t.TARGET:
                return i

            for j in range(i + i, t.LIMIT, i):
                t.prime_dict[j] = False


if __name__ == '__main__':
    print "The 10,001st prime is", TenThousandFirstPrime.find()
