__author__ = 'tbruckhaus'


class ReciprocalCycles:
    """
    Reciprocal cycles
    Problem 26

    A unit fraction contains 1 in the numerator.
    The decimal representation of the unit fractions with denominators 2 to 10 are given:

        1/2 	= 	0.5
        1/3 	= 	0.(3)
        1/4 	= 	0.25
        1/5 	= 	0.2
        1/6 	= 	0.1(6)
        1/7 	= 	0.(142857)
        1/8 	= 	0.125
        1/9 	= 	0.(1)
        1/10	= 	0.1

    Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle.
    It can be seen that 1/7 has a 6-digit recurring cycle.

    Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
    """

    def __init__(self):
        pass

    @staticmethod
    def find(n):
        r = ReciprocalCycles
        denominator = -1
        longest = -1
        for i in range(1, n):
            length = r.cycle_length(i)
            if length > longest:
                longest = length
                denominator = i
        return denominator

    @staticmethod
    def cycle_length(n):
        if __name__ == '__main__':
            print "\ncycle length of", n
        remainders = []
        r = 1
        while r != 0:
            if __name__ == '__main__':
                print r,
            r = (10 * r) % n
            if r in remainders:
                break
            else:
                remainders.append(r)
        length = len(remainders)
        if __name__ == '__main__':
            print "\ncycle length:", length
        return length


if __name__ == '__main__':
    limit = 1000
    r = ReciprocalCycles.find(limit)
    print "The value of d <", limit, \
        "for which 1/d contains the longest recurring cycle in its decimal fraction part is", r
