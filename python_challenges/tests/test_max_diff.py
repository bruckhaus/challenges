__author__ = 'tilmannbruckhaus'

import unittest
import max_diff


class MaxDiffTest(unittest.TestCase):
    def test_max_diff(self):
        self.assertEqual(8, max_diff.max_diff([2, 3, 10, 2, 4, 8, 1]))
        self.assertEqual(2, max_diff.max_diff([7, 9, 5, 6, 3, 2]))
        self.assertEqual(-1, max_diff.max_diff([5, 4, 3, 2, 1]))
        self.assertEqual(1, max_diff.max_diff([1, 2]))
        self.assertEqual(1, max_diff.max_diff([111, 112]))
        self.assertEqual(-1, max_diff.max_diff([]))

if __name__ == '__main__':
    unittest.main()