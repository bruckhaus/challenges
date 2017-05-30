from unittest import TestCase

from generate_pandigitals import GeneratePandigital


class TestPandigital(TestCase):
    def test_get_digit_numbers(self):
        self.assertEquals([1], GeneratePandigital.generate_pandigitals(1))
        self.assertEquals([12, 21], GeneratePandigital.generate_pandigitals(2))
        self.assertEquals([123, 132, 213, 231, 312, 321], GeneratePandigital.generate_pandigitals(3))
        self.assertEquals([1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341, 2413, 2431,
                           3124, 3142, 3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321],
                          GeneratePandigital.generate_pandigitals(4))

    def test_generate(self):
        self.assertEquals([1], GeneratePandigital.generate_from_set({1}))
        self.assertEquals([12, 21], GeneratePandigital.generate_from_set({1, 2}))
        self.assertEquals([123, 132, 213, 231, 312, 321], GeneratePandigital.generate_from_set({1, 2, 3}))
        self.assertEquals([359, 395, 539, 593, 935, 953], GeneratePandigital.generate_from_set({3, 5, 9}))
        self.assertEquals([8], GeneratePandigital.generate_from_set({8}))
        self.assertEquals([123, 132, 213, 231, 312, 321], GeneratePandigital.generate_from_set({3, 2, 1}))
        self.assertEquals([567, 576, 657, 675, 756, 765], GeneratePandigital.generate_from_set({5, 6, 7}))
        self.assertEquals([28, 82], GeneratePandigital.generate_from_set({8, 2}))
