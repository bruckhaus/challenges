__author__ = 'tbruckhaus'


class SpecialPythagoreanTriplet:

    # Special Pythagorean triplet
    # Problem 9
    #
    # A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
    # a2 + b2 = c2
    #
    # For example, 32 + 42 = 9 + 16 = 25 = 52.
    #
    # There exists exactly one Pythagorean triplet for which a + b + c = 1000.
    # Find the product abc.

    def __init__(self):
        pass

    @staticmethod
    def find():
        a = 1
        b = 2
        c = 1000 - a - b
        while True:
            # print "checking", a, b, c
            if a ** 2 + b ** 2 == c ** 2:
                return a, b, c
            b += 1
            if a + b + b + 1 > 1000:
                a += 1
                b = a + 1
            c = 1000 - a - b

if __name__ == '__main__':
    triplet = SpecialPythagoreanTriplet.find()
    print "The Pythagorean triplet for which a + b + c = 1000 is", triplet
