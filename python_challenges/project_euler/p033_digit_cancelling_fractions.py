import math

__author__ = 'tilmannbruckhaus'


class DigitCancellingFractions:
    """
    Digit cancelling fractions
    Problem 33
    The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it
    may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

    We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

    There are exactly four non-trivial examples of this type of fraction, less than one in value,
    and containing two digits in the numerator and denominator.

    If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
    """

    def __init__(self):
        self.fractions = []
        self.cancelled_fractions = []
        self.numerator = None
        self.denominator = None

    def find(self):
        self.find_fractions()
        self.find_product()
        self.lowest_terms()
        return self.denominator

    def find_fractions(self):
        self.fractions = []
        for i in range(12, 99):
            for j in range(i + 1, 99):
                fraction = (i, j)
                if self.is_curious(fraction):
                    self.fractions.append(fraction)
        return self.fractions

    def find_product(self):
        self.numerator = 1
        self.denominator = 1
        for fraction in self.cancelled_fractions:
            self.numerator *= fraction[0]
            self.denominator *= fraction[1]

    def lowest_terms(self):
        factor = 2
        while True:
            if self.numerator % factor == 0 and self.denominator % factor == 0:
                self.numerator /= factor
                self.denominator /= factor
            else:
                factor += 1
            if factor > self.numerator:
                break

    def is_curious(self, fraction):
        d = DigitCancellingFractions
        i_int = fraction[0]
        j_int = fraction[1]
        if i_int % 10 == 0 or j_int % 10 == 0:
            return False
        original_fraction = 1.0 * i_int / j_int
        i_set, j_set = self.get_sets(i_int, j_int)
        if i_set & j_set == set():
            return False
        i_set, j_set = self.cancel_sets(i_set, j_set)
        if d.one_set_empty(i_set, j_set):
            return False
        i_cancelled = d.get_first_as_int(i_set)
        j_cancelled = d.get_first_as_int(j_set)
        cancelled_fraction = 1.0 * i_cancelled / j_cancelled
        found = cancelled_fraction == original_fraction
        if found:
            self.cancelled_fractions.append([i_cancelled, j_cancelled])
        return found

    def show(self):
        print "fractions:", self.fractions
        print "cancelled fractions:", self.cancelled_fractions
        print "lowest terms: ", self.numerator, self.denominator

    @staticmethod
    def get_first_as_int(s):
        return int(list(s)[0])

    @staticmethod
    def one_set_empty(set_1, set_2):
        if set_1 == set([]):
            return True
        if set_2 == set([]):
            return True
        return False

    @staticmethod
    def get_sets(i_int, j_int):
        i_str = str(i_int)
        j_str = str(j_int)
        i_set = set()
        i_set.add(i_str[0])
        i_set.add(i_str[1])
        j_set = set()
        j_set.add(j_str[0])
        j_set.add(j_str[1])
        return i_set, j_set

    @staticmethod
    def cancel_sets(i_set, j_set):
        temp_set = i_set - j_set
        j_set = j_set - i_set
        i_set = temp_set
        return i_set, j_set


if __name__ == '__main__':
    d = DigitCancellingFractions()
    result = d.find()
    d.show()
    print "The value of the denominator of the product of the four digit-canceling fractions is", result
