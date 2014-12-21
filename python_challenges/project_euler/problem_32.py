# coding=utf-8
__author__ = 'tilmannbruckhaus'

import os
import sys

current_path = os.path.dirname(os.path.abspath(__file__))
lib_path = os.path.join(current_path, '..')
sys.path.append(lib_path)

from lib.pandigital import Pandigital


class PandigitalProducts:
    """
    Pandigital products
    Problem 32
    We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
    for example, the 5-digit number, 15234, is 1 through 5 pandigital.

    The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier,
    and product is 1 through 9 pandigital.

    Find the sum of all products whose multiplicand/multiplier/product identity
    can be written as a 1 through 9 pandigital.

    HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
    """

    def __init__(self, digits=None):
        if digits is None:
            digits = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        self.digits = digits
        self.pandigital = None
        self.factor_1 = None
        self.factor_2 = None
        self.product = None
        self.products = set()
        self.all_products = set()

    def find(self):
        p = Pandigital(self.digits)
        self.pandigital = p.get()
        while True:
            self.check_products()
            self.all_products |= self.products
            if p.has_next():
                self.pandigital = p.next()
            else:
                break
        return sum(self.all_products)

    def check_products(self):
        p = self.pandigital
        l = len(self.pandigital)
        for factor_1_len in range(1, l):
            l1 = factor_1_len
            self.factor_1 = self.get_int(p[:l1])
            for factor_2_len in range(l1 + 1, l):
                l2 = factor_2_len
                self.factor_2 = self.get_int(p[l1:l2])
                self.product = self.get_int(p[l2:])
                if self.is_match():
                    self.products.add(self.product)
                    self.show()
        return self.products

    def is_match(self):
        return (self.product > 0) and (self.factor_1 * self.factor_2 == self.product)

    @staticmethod
    def get_int(l):
        return int("".join([str(d) for d in l]))

    def show(self):
        if __name__ == '__main__':
            expected = self.factor_1 * self.factor_2
            print "pandigital:", self.pandigital, \
                ", factor 1:", self.factor_1, \
                ", factor 2:", self.factor_2, \
                ", product", self.product, \
                "(", expected, "-", self.is_match(), ")" \
                ", products:", self.products, \
                ", all products:", self.all_products


if __name__ == '__main__':
    p = PandigitalProducts([1, 2, 3, 4, 5, 6, 7, 8, 9]).find()
    print "The sum of all products whose product identity can be written as a 1 through 9 pandigital is", p
