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
from project_euler.problem_13 import LargeSum
from project_euler.problem_14 import LongestCollatzSequence
from project_euler.problem_15 import LatticePaths
from project_euler.problem_16 import PowerDigitSum
from project_euler.problem_17 import NumberLetterCounts
from project_euler.problem_18 import MaximumPathSum
from project_euler.problem_19 import CountingSundays
from project_euler.problem_20 import FactorialDigitSum
from project_euler.problem_21 import AmicableNumbers
from project_euler.problem_22 import NameScores
from project_euler.problem_23 import NonAbundantSums


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

    def test_problem_13(self):
        self.assertEquals('5537376229', LargeSum().digit_sum(10))
        self.assertEquals('5537376230', LargeSum().digit_sum(11))
        self.assertEquals('5537376230', LargeSum().digit_sum(20))
        self.assertEquals('5537376230', LargeSum().digit_sum(50))
        self.assertEquals('5537376230', LargeSum().find())

    def test_problem14(self):
        self.assertEquals(0, LongestCollatzSequence.collatz(1))
        self.assertEquals(1, LongestCollatzSequence.collatz(2))
        self.assertEquals(7, LongestCollatzSequence.collatz(3))
        self.assertEquals(20, LongestCollatzSequence.collatz(18))
        self.assertEquals(121, LongestCollatzSequence.collatz(129))
        self.assertEquals(181, LongestCollatzSequence.collatz(1161))
        self.assertEquals(508, LongestCollatzSequence.collatz(626331))
        self.assertEquals(524, LongestCollatzSequence.collatz(837799))
        self.assertEquals(474, LongestCollatzSequence.collatz(1234567890987654321))

    def test_problem15(self):
        self.assertAlmostEquals(6, LatticePaths.find(2), 1)
        self.assertAlmostEquals(20, LatticePaths.find(3), 1)
        self.assertAlmostEquals(70, LatticePaths.find(4), 1)
        self.assertAlmostEquals(252, LatticePaths.find(5), 1)
        self.assertAlmostEquals(924, LatticePaths.find(6), 1)
        self.assertAlmostEquals(184756, LatticePaths.find(10), 1)
        self.assertAlmostEquals(35345263800, LatticePaths.find(19), 1)
        self.assertAlmostEquals(137846528820, LatticePaths.find(20), 1)
        self.assertAlmostEquals(538257874440, LatticePaths.find(21), 1)

    def test_problem_16(self):
        self.assertEquals(1, PowerDigitSum.find(0))
        self.assertEquals(2, PowerDigitSum.find(1))
        self.assertEquals(4, PowerDigitSum.find(2))
        self.assertEquals(7, PowerDigitSum.find(10))
        self.assertEquals(31, PowerDigitSum.find(20))
        self.assertEquals(115, PowerDigitSum.find(100))
        self.assertEquals(679, PowerDigitSum.find(500))
        self.assertEquals(1366, PowerDigitSum.find(1000))

    def test_problem_17(self):
        self.assertEquals('one', NumberLetterCounts(1).set_phrase())
        self.assertEquals('two', NumberLetterCounts(2).set_phrase())
        self.assertEquals('seventeen', NumberLetterCounts(17).set_phrase())
        self.assertEquals('one hundred and fifteen', NumberLetterCounts(115).set_phrase())
        self.assertEquals('three hundred and forty-two', NumberLetterCounts(342).set_phrase())
        self.assertEquals('one thousand', NumberLetterCounts(1000).set_phrase())
        self.assertEquals(3, NumberLetterCounts(1).letter_count())
        self.assertEquals(3, NumberLetterCounts(2).letter_count())
        self.assertEquals(9, NumberLetterCounts(17).letter_count())
        self.assertEquals(20, NumberLetterCounts(115).letter_count())
        self.assertEquals(23, NumberLetterCounts(342).letter_count())
        self.assertEquals(11, NumberLetterCounts(1000).letter_count())
        self.assertEquals(3, NumberLetterCounts(1).find())
        self.assertEquals(6, NumberLetterCounts(2).find())
        self.assertEquals(90, NumberLetterCounts(17).find())
        self.assertEquals(1133, NumberLetterCounts(115).find())
        self.assertEquals(6117, NumberLetterCounts(342).find())
        self.assertEquals(21124, NumberLetterCounts(1000).find())

    def test_problem_18(self):
        self.assertEquals(3, MaximumPathSum([[3]]).find())
        self.assertEquals(10, MaximumPathSum([[3], [7, 4]]).find())
        self.assertEquals(14, MaximumPathSum([[3], [7, 4], [2, 4, 6]]).find())
        self.assertEquals(23, MaximumPathSum([[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]]).find())

    def test_problem_19(self):
        self.assertEquals(171, CountingSundays.find())

    def test_problem_20(self):
        self.assertEquals(1, FactorialDigitSum.find(0))  # 1
        self.assertEquals(1, FactorialDigitSum.find(1))  # 1
        self.assertEquals(2, FactorialDigitSum.find(2))  # 2
        self.assertEquals(3, FactorialDigitSum.find(5))  # 120
        self.assertEquals(27, FactorialDigitSum.find(10))  # 3628800
        self.assertEquals(225, FactorialDigitSum.find(47))
        self.assertEquals(648, FactorialDigitSum.find(100))

    def test_problem_21(self):
        self.assertEquals(0, AmicableNumbers.find(100))
        self.assertEquals(504, AmicableNumbers.find(400))
        self.assertEquals(2898, AmicableNumbers.find(2000))

    def test_problem_22(self):
        self.assertEquals(871198282, NameScores('../tests/resources/p022_names.txt').find())

    def test_problem_23(self):
        n = NonAbundantSums
        self.assertEquals([1, 2, 3, 4, 6, 8, 12], n.divisors(24))
        self.assertEquals([1, 2, 3, 4, 5, 6, 8, 10, 12, 15, 16, 20, 24, 30, 40, 48, 60, 80, 120], n.divisors(240))
        self.assertEquals([1, 7, 349], n.divisors(2443))
        self.assertEquals(False, n.abundant(23))
        self.assertEquals(True, n.abundant(24))
        self.assertEquals(False, n.abundant(25))
        self.assertEquals(False, n.abundant(2498))
        self.assertEquals(True, n.abundant(24444))
        # self.assertEquals(4179871, n.find())  # runs long: > 20 seconds on MacBook Air


if __name__ == '__main__':
    unittest.main()
