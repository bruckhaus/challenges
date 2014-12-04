__author__ = 'tilmannbruckhaus'

import unittest
from project_euler.problem_1 import SumOfMultiples
from project_euler.problem_2 import Fibonacci
from project_euler.problem_3 import LargestPrimeFactor
from project_euler.problem_4 import LargestPalindrome
from project_euler.problem_5 import SmallestMultiple
from project_euler.problem_6 import SumSquareDifference
from project_euler.problem_7 import TenThousandFirstPrime
from project_euler.problem_8 import LargestProductInSeries
from project_euler.problem_9 import SpecialPythagoreanTriplet
from project_euler.problem_10 import SummationOfPrimes
from project_euler.problem_11 import LargestProductInAGrid
from project_euler.problem_12 import HighlyDivisible


class TestProjectEuler(unittest.TestCase):
    def test_problem1(self):
        fixtures = [[10, 23], [100, 2318], [1000, 233168]]
        for fixture in fixtures:
            self.assertEquals(fixture[1], SumOfMultiples.sum_of_multiples_of_3_or_5(fixture[0]))

    def test_problem2(self):
        self.assertEquals(4613732, Fibonacci().even_sum(4000000))

    def test_problem_3(self):
        fixtures = [[2, 1],
                    [3, 1],
                    [4, 2],
                    [7, 1],
                    [15, 5],
                    [44, 11],
                    [99, 11],
                    [111, 37],
                    [1577, 83],
                    [19 * 37 * 83, 83],
                    [600851475143, 6857]]

        for fixture in fixtures:
            self.assertEquals(fixture[1], LargestPrimeFactor.find(fixture[0]))

    def test_problem_4(self):
        fixtures = [[1, 9], [2, 9009], [3, 906609]]
        for fixture in fixtures:
            self.assertEquals(fixture[1], LargestPalindrome.find(fixture[0]))

    def test_problem_5(self):
        self.assertEquals(232792560, SmallestMultiple.find())

    def test_problem_6(self):
        self.assertEquals(25164150, SumSquareDifference.find())

    def test_problem_7(self):
        self.assertEquals(104743, TenThousandFirstPrime.find())

    def test_problem_8(self):
        self.assertEquals(23514624000, LargestProductInSeries.find())

    def test_problem_9(self):
        self.assertEquals((200, 375, 425), SpecialPythagoreanTriplet.find())

    def test_problem_10(self):
        self.assertEquals(142913828922, SummationOfPrimes().find())

    def test_problem_11(self):
        self.assertEquals(70600674, LargestProductInAGrid().find())

    def test_problem_12(self):
        h = HighlyDivisible
        self.assertEquals([[2, 2], [7, 1]], h.factor(28))
        self.assertEquals(6, h.num_divisors([[2, 2], [7, 1]]))
        self.assertEquals(28, h.find(5))
        self.assertEquals([[17, 1]], h.factor(17))
        self.assertEquals(2, h.num_divisors([[17, 1]]))
        self.assertEquals([[5, 2]], h.factor(25))
        self.assertEquals(3, h.num_divisors([[5, 2]]))
        self.assertEquals([[2, 2], [3, 1], [5, 1]], h.factor(60))
        self.assertEquals(12, h.num_divisors([[2, 2], [3, 1], [5, 1]]))
        self.assertEquals([[2, 2], [5, 2]], h.factor(100))
        self.assertEquals(9, h.num_divisors([[2, 2], [5, 2]]))
        self.assertEquals([[2, 4], [3, 4], [5, 1], [7, 1]], h.factor(45360))
        self.assertEquals(100, h.num_divisors([[2, 4], [3, 4], [5, 1], [7, 1]]))
        self.assertEquals([[2, 2], [3, 2], [5, 3], [7, 1], [11, 1], [13, 1], [17, 1]], h.factor(76576500))
        self.assertEquals(576, h.num_divisors([[2, 2], [3, 2], [5, 3], [7, 1], [11, 1], [13, 1], [17, 1]]))


if __name__ == '__main__':
    unittest.main()
