import unittest
import pandigital


class TestPandigital(unittest.TestCase):
    def test_pandigital(self):
        self.assertEqual(7652413, pandigital.Pandigital().largest_prime())