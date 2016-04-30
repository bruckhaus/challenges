import os
import sys

current_path = os.path.dirname(os.path.abspath(__file__))
lib_path = os.path.join(current_path, '..')
sys.path.append(lib_path)

from lib.prime import Prime


class QuadraticPrimes:
    """
    Quadratic primes
    Problem 27
    Euler discovered the remarkable quadratic formula:

    n^2 + n + 41

    It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39.
    However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41,
    and certainly when n = 41, 41^2 + 41 + 41 is clearly divisible by 41.

    The incredible formula  n^2 - 79n + 1601 was discovered,
    which produces 80 primes for the consecutive values n = 0 to 79.
    The product of the coefficients, -79 and 1601, is -126479.

    Considering quadratics of the form:

    n^2 + an + b, where |a| < 1000 and |b| < 1000

    where |n| is the modulus/absolute value of n
    e.g. |11| = 11 and |-4| = 4
    Find the product of the coefficients, a and b, for the quadratic expression
    that produces the maximum number of primes for consecutive values of n, starting with n = 0.
    """

    def __init__(self):
        self.series = []
        self.coefficients = (0, 0)

    def find(self, limit=1000):
        longest = 0
        for a in range(-limit, limit):
            for b in range(-limit, limit):
                length = len(self.prime_series(a, b))
                if length > longest:
                    longest = length
                    self.coefficients = (a, b)
                    self.show_diagnostics()
        product = self.coefficients[0] * self.coefficients[1]
        return product

    def prime_series(self, a, b):
        q = QuadraticPrimes
        self.series = []
        x = 0
        value = q.quadratic_value(a, b, x)
        while Prime.is_prime(value):
            self.series.append(value)
            x += 1
            value = q.quadratic_value(a, b, x)
        return self.series

    @staticmethod
    def quadratic_value(a, b, x):
        return x ** 2 + a * x + b

    def show_diagnostics(self):
        if __name__ == '__main__':
            print "best coefficients:", self.coefficients, ", length:", len(self.series), ", series:", self.series


if __name__ == '__main__':
    q = QuadraticPrimes().find(1000)
    print "The product of the coefficients that produce the maximum number of primes is", q
