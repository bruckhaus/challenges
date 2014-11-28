__author__ = 'tilmannbruckhaus'

import unittest
from project_euler.problem_1 import SumOfMultiples
from project_euler.problem_2 import Fibonacci
from project_euler.problem_3 import LargestPrimeFactor


class TestProjectEuler(unittest.TestCase):

    def test_problem1(self):
        self.assertEquals(23, SumOfMultiples.sum_of_multiples_of_3_or_5(10))
        self.assertEquals(2318, SumOfMultiples.sum_of_multiples_of_3_or_5(100))
        self.assertEquals(233168, SumOfMultiples.sum_of_multiples_of_3_or_5(1000))

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

if __name__ == '__main__':
    unittest.main()
