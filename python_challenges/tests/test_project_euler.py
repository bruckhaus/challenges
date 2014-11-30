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

if __name__ == '__main__':
    unittest.main()
