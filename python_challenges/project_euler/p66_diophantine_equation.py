# coding=utf-8
"""
Diophantine equation
Problem 66
Consider quadratic Diophantine equations of the form: x^2 – Dy^2 = 1
For example, when D=13, the minimal solution in x is 6492 – 13×1802 = 1.
It can be assumed that there are no solutions in positive integers when D is square.
By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:
32 – 2×22 = 1
22 – 3×12 = 1
92 – 5×42 = 1
52 – 6×22 = 1
82 – 7×32 = 1
Hence, by considering minimal solutions in x for D ≤ 7, the largest x is obtained when D=5.
Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.
"""
from math import sqrt, pow

BIG_D_MAX = 1000


class P66DiophantineEquation:

    def __init__(self):
        self.m = None
        self.d = None
        self.a = None
        self.num_m1 = None
        self.num_m2 = None
        self.den_m1 = None
        self.den_m2 = None

    def initialize(self, limit):
        self.m = 0
        self.d = 1
        self.a = limit
        self.num_m1 = 1
        self.den_m1 = 0

    def get_max_diophantine_x(self, big_d_max):
        result = 0
        p_max = 0
        for big_d in range(2, big_d_max + 1):
            limit = int(sqrt(big_d))
            if pow(limit, 2) == big_d:
                continue
            self.initialize(limit)
            numerator = self.a
            denominator = 1
            while numerator ** 2 - big_d * denominator ** 2 != 1:
                self.track_series_values(denominator, numerator)
                self.update_terms(big_d, limit)
                numerator = self.a * self.num_m1 + self.num_m2
                denominator = self.a * self.den_m1 + self.den_m2
            if numerator > p_max:
                p_max = numerator
                result = big_d
        return result

    def update_terms(self, big_d, limit):
        self.m = self.d * self.a - self.m
        self.d = (big_d - self.m * self.m) / self.d
        self.a = (limit + self.m) / self.d

    def track_series_values(self, denominator, numerator):
        self.num_m2 = self.num_m1
        self.den_m2 = self.den_m1
        self.num_m1 = numerator
        self.den_m1 = denominator


# We get the largest x as a minimal solution for D=661
e = P66DiophantineEquation()
d = e.get_max_diophantine_x(BIG_D_MAX)
print("The largest x for minimal Diophantine solutions up to %d is %d" % (BIG_D_MAX, d))
