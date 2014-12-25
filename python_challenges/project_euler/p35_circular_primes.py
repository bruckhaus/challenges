import os
import sys

current_path = os.path.dirname(os.path.abspath(__file__))
lib_path = os.path.join(current_path, '..')
sys.path.append(lib_path)

from lib.prime import Prime

__author__ = 'tilmannbruckhaus'


class CircularPrimes:
    """
    Problem 35
    The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719,
    are themselves prime.
    There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
    How many circular primes are there below one million?
    """

    def __init__(self):
        pass

    @staticmethod
    def find(n):
        c = CircularPrimes
        count = 0
        for i in range(n):
            all_prime = True
            rotations = c.all_rotations(i)
            for rotation in rotations:
                if not Prime.is_prime(rotation):
                    all_prime = False
                    break
            if all_prime:
                count += 1
                if __name__ == '__main__':
                    print "found circular prime:", i, ", rotations:", rotations
        return count

    @staticmethod
    def all_rotations(n):
        r = str(n)
        rotations = []
        for i in range(len(str(n))):
            s = int(str(r)[i:] + str(r)[:i])
            rotations.append(s)
        return rotations


if __name__ == '__main__':
    n = 1000000
    c = CircularPrimes.find(n)
    print "The number of circular primes below", n, "is", c
