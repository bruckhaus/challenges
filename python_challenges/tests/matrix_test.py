__author__ = 'tilmann.bruckhaus'

import unittest
import matrix


class MatrixTest(unittest.TestCase):
    def test_traverse(self):
        self.assertEqual(0, matrix.Matrix([[0]]).traverse())
        self.assertEqual(1, matrix.Matrix([[1]]).traverse())
        self.assertEqual(1, matrix.Matrix([[1, 1],
                                           [0, 1]]).traverse())
        self.assertEqual(2, matrix.Matrix([[1, 1, 1],
                                           [1, 0, 1],
                                           [1, 1, 1]]).traverse())
        self.assertEqual(11, matrix.Matrix([[1, 1, 1, 1],
                                            [1, 1, 0, 1],
                                            [1, 1, 1, 1],
                                            [1, 1, 1, 1]]).traverse())
        self.assertEqual(23, matrix.Matrix([[1, 1, 1, 1, 1],
                                            [1, 1, 1, 0, 1],
                                            [1, 1, 1, 1, 1],
                                            [1, 1, 1, 1, 1]]).traverse())
        self.assertEqual(10, matrix.Matrix([[1, 1, 1, 1],
                                            [1, 1, 1, 1],
                                            [1, 1, 1, 1]]).traverse())
        self.assertEqual(4, matrix.Matrix([[1, 1, 1, 1],
                                           [1, 1, 0, 1],
                                           [1, 1, 1, 1]]).traverse())