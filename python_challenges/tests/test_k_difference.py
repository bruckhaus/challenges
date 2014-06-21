__author__ = 'tilmann.bruckhaus'

import unittest
import k_difference


class TestKDifference(unittest.TestCase):
    def test_k_difference(self):
        self.assertEqual(2, k_difference.k_difference(1, [1, 2, 3]))
        self.assertEqual(3, k_difference.k_difference(2, [1, 5, 3, 4, 2]))
        self.assertEqual(9, k_difference.k_difference(1, [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]))
        self.assertEqual(0, k_difference.k_difference(1, [363374326, 364147530, 61825163, 1073065718, 1281246024,
                                                          1399469912, 428047635, 491595254, 879792181, 1069262793]))

if __name__ == '__main__':
    unittest.main()