import unittest
from project_euler.p001_sum_of_multiples import SumOfMultiples
from project_euler.p002_even_fibonacci import EvenFibonacci
from project_euler.p003_largest_prime_factor import LargestPrimeFactor
from project_euler.p004_largest_palindrome import LargestPalindrome
from project_euler.p005_smallest_multiple import SmallestMultiple
from project_euler.p006_sum_square_difference import SumSquareDifference
from project_euler.p007_ten_thousand_first_prime import TenThousandFirstPrime
from project_euler.p008_largest_product_in_series import LargestProductInSeries
from project_euler.p009_special_pythagorean_triple import SpecialPythagoreanTriplet
from project_euler.p010_summation_of_primes import SummationOfPrimes
from project_euler.p011_largest_product_in_a_grid import LargestProductInAGrid
from project_euler.p012_highly_divisible import HighlyDivisible
from project_euler.p013_large_sum import LargeSum
from project_euler.p014_longest_collatz_sequence import LongestCollatzSequence
from project_euler.p015_lattice_paths import LatticePaths
from project_euler.p016_power_digit_sum import PowerDigitSum
from project_euler.p017_number_letter_counts import NumberLetterCounts
from project_euler.p018_maximum_path_sum import MaximumPathSum
from project_euler.p019_counting_sundays import CountingSundays
from project_euler.p020_factorial_digit_sum import FactorialDigitSum
from project_euler.p021_amicable_numbers import AmicableNumbers
from project_euler.p022_name_scores import NameScores
from project_euler.p023_non_abundant_sums import NonAbundantSums
from project_euler.p024_lexicographic_permutations import LexicographicPermutations
from project_euler.p025_thousand_digit_fibonacci_number import ThousandDigitFibonacciNumber
from project_euler.p026_reciprocal_cycles import ReciprocalCycles
from project_euler.p027_quadratic_primes import QuadraticPrimes
from project_euler.p028_number_spiral_diagonals import NumberSpiralDiagonals
from project_euler.p029_distinct_powers import DistinctPowers
from project_euler.p030_digit_fifth_powers import DigitFifthPowers
from project_euler.p031_coin_sum import CoinSum
from project_euler.p032_pandigital_products import PandigitalProducts
from project_euler.p033_digit_cancelling_fractions import DigitCancellingFractions
from project_euler.p034_digit_factorials import DigitFactorials
from project_euler.p035_circular_primes import CircularPrimes
from project_euler.p036_double_base_palindromes import DoubleBasePalindrome
import project_euler.p065_convergents_of_e as p65


class TestProjectEuler(unittest.TestCase):
    def test_problem1(self):
        fixtures = [[10, 23], [100, 2318], [1000, 233168]]
        for fixture in fixtures:
            self.assertEquals(fixture[1], SumOfMultiples.sum_of_multiples_of_3_or_5(fixture[0]))

    def test_problem2(self):
        self.assertEquals(4613732, EvenFibonacci().even_sum(4000000))

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

    def test_problem_24(self):
        l = LexicographicPermutations
        self.assertEquals('0123456789', l().find(1))
        self.assertEquals('0123456798', l().find(2))
        self.assertEquals('0123456879', l().find(3))
        self.assertEquals('0123456897', l().find(4))
        self.assertEquals('0123456978', l().find(5))
        self.assertEquals('0123457896', l().find(10))
        self.assertEquals('0124658793', l().find(1000))

    def test_problem_25(self):
        t = ThousandDigitFibonacciNumber
        self.assertEquals(1, t.find(1))
        self.assertEquals(7, t.find(2))
        self.assertEquals(12, t.find(3))
        self.assertEquals(45, t.find(10))
        self.assertEquals(476, t.find(100))
        self.assertEquals(4782, t.find(1000))

    def test_problem_26(self):
        r = ReciprocalCycles
        self.assertEquals(7, r.find(10))
        self.assertEquals(97, r.find(100))
        self.assertEquals(499, r.find(500))
        self.assertEquals(983, r.find(1000))

    def test_problem_27(self):
        q = QuadraticPrimes()
        self.assertEquals(0, q.find(2))
        self.assertEquals(-21, q.find(10))
        self.assertEquals(-235, q.find(50))
        self.assertEquals(-1455, q.find(100))

    def test_problem_28(self):
        n = NumberSpiralDiagonals
        # --- test spiral creation:
        spiral = n(3)
        spiral.create_spiral()
        self.assertEquals([[0, 0, 0], [0, 0, 0], [0, 0, 0]], spiral.spiral)
        spiral.populate_spiral()
        self.assertEquals([[7, 8, 9], [6, 1, 2], [5, 4, 3]], spiral.spiral)
        # --- test spiral creation and sum of diagonal:
        self.assertEquals(25, n(3).diagonal_sum())
        self.assertEquals(101, n(5).diagonal_sum())
        self.assertEquals(89801, n(51).diagonal_sum())
        self.assertEquals(692101, n(101).diagonal_sum())

    def test_problem_29(self):
        d = DistinctPowers
        self.assertEquals(0, d.find(1))
        self.assertEquals(1, d.find(2))
        self.assertEquals(4, d.find(3))
        self.assertEquals(15, d.find(5))
        self.assertEquals(69, d.find(10))
        self.assertEquals(9183, d.find(100))

    def test_problem_30(self):
        d = DigitFifthPowers
        self.assertEquals(0, d.find(9))
        self.assertEquals(0, d.find(99))
        self.assertEquals(0, d.find(999))
        self.assertEquals(8301, d.find(9999))

    def test_problem_31(self):
        c = CoinSum
        self.assertEquals(1, c.find(1))
        self.assertEquals(2, c.find(2))
        self.assertEquals(2, c.find(3))
        self.assertEquals(4, c.find(5))
        self.assertEquals(11, c.find(10))
        self.assertEquals(451, c.find(50))

    def test_problem_32(self):
        p = PandigitalProducts
        self.assertEquals(0, p([1]).find())
        self.assertEquals(0, p([1, 2]).find())
        self.assertEquals(0, p([1, 2, 3]).find())
        self.assertEquals(12, p([1, 2, 3, 4]).find())
        self.assertEquals(52, p([1, 2, 3, 4, 5]).find())
        self.assertEquals(162, p([1, 2, 3, 4, 5, 6]).find())

    def test_problem_33(self):
        d = DigitCancellingFractions()
        self.assertEquals(100, d.find())
        self.assertEquals([(16, 64), (19, 95), (26, 65), (49, 98)], d.find_fractions())
        self.assertEquals(True, d.is_curious((16, 64)))
        self.assertEquals(False, d.is_curious((20, 30)))
        self.assertEquals(False, d.is_curious((22, 44)))
        self.assertEquals(1, d.get_first_as_int("1"))
        self.assertEquals(2, d.get_first_as_int("23"))
        self.assertEquals(True, d.one_set_empty(set(), set()))
        self.assertEquals(True, d.one_set_empty(set(), {2}))
        self.assertEquals(True, d.one_set_empty({1}, set()))
        self.assertEquals(False, d.one_set_empty({1}, {2}))

    def test_problem_34(self):
        d = DigitFactorials
        self.assertEquals(0, d.find(100))
        self.assertEquals(145, d.find(1000))
        self.assertEquals(40730, d.find(50000))

    def test_problem_35(self):
        c = CircularPrimes
        self.assertEquals(4, c.find(10))
        self.assertEquals(13, c.find(100))
        self.assertEquals(25, c.find(1000))
        self.assertEquals(33, c.find(10000))

    def test_problem_36(self):
        d = DoubleBasePalindrome
        self.assertEquals(25, d.find(10))
        self.assertEquals(157, d.find(100))
        self.assertEquals(1772, d.find(1000))
        self.assertEquals(18228, d.find(10000))

    def test_problem_65(self):
        self.assertEquals(0, p65.get_factor_increase(0))
        self.assertEquals(1, p65.get_factor_increase(1))
        self.assertEquals(1, p65.get_factor_increase(2))
        self.assertEquals(2, p65.get_factor_increase(3))
        self.assertEquals(1, p65.get_factor_increase(4))
        self.assertEquals(1, p65.get_factor_increase(5))
        self.assertEquals(4, p65.get_factor_increase(6))
        self.assertEquals(1, p65.get_factor_increase(7))
        self.assertEquals(66, p65.get_factor_increase(99))
        self.assertEquals(1, p65.get_factor_increase(100))
        self.assertEquals(1, p65.get_factor_increase(101))
        self.assertEquals(68, p65.get_factor_increase(102))
        self.assertEquals(1, p65.get_factor_increase(103))
        self.assertEquals(1, p65.get_factor_increase(104))
        self.assertEquals(70, p65.get_factor_increase(105))
        self.assertIsInstance(p65.get_numerator_digit_sum(-1), int)
        self.assertIsInstance(p65.get_numerator_digit_sum(0), int)
        self.assertEquals(p65.get_numerator_digit_sum(1), 2)
        self.assertEquals(p65.get_numerator_digit_sum(10), 17)
        self.assertEquals(p65.get_numerator_digit_sum(100), 272)
        self.assertEquals(p65.get_numerator_digit_sum(1000), 4034)
        self.assertEquals(p65.get_numerator_digit_sum(1234), 5033)


if __name__ == '__main__':
    unittest.main()
