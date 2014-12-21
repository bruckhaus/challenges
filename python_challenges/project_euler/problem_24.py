__author__ = 'tilmannbruckhaus'

import os
import sys

current_path = os.path.dirname(os.path.abspath(__file__))
lib_path = os.path.join(current_path, '..')
sys.path.append(lib_path)

from lib.pandigital import Pandigital


class LexicographicPermutations:
    # Lexicographic permutations
    # Problem 24
    # A permutation is an ordered arrangement of objects.
    # For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
    # If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
    # The lexicographic permutations of 0, 1 and 2 are:
    #
    # 012   021   102   120   201   210
    #
    # What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

    def __init__(self):
        pass

    @staticmethod
    def find(steps):
        p = Pandigital()
        [p.step() for _ in range(steps - 1)]
        result = ''.join([str(d) for d in p.p])
        return result


if __name__ == '__main__':
    l = LexicographicPermutations().find(1000000)
    print "The millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9? is", l
