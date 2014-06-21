__author__ = 'tilmannbruckhaus'

import unittest
import reverse_string


class MaxDiffTest(unittest.TestCase):
    def test_max_diff(self):
        self.assertEqual("cba", reverse_string.reverse_string("abc"))
        self.assertEqual("!gnirtS TSET ym si sihT", reverse_string.reverse_string("This is my TEST String!"))
        self.assertEqual("", reverse_string.reverse_string(""))
        self.assertEqual("x", reverse_string.reverse_string("x"))

if __name__ == '__main__':
    unittest.main()