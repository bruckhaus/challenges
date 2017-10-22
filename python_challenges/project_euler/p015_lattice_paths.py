from scipy.misc import comb


class LatticePaths:
    # Lattice paths
    # Problem 15
    # Starting in the top left corner of a 2x2 grid, and only being able to move to the right and down,
    # there are exactly 6 routes to the bottom right corner.
    # How many such routes are there through a 20x20 grid?

    def __init__(self):
        pass

    @staticmethod
    def find(n):
        return comb(2 * n, n)


if __name__ == '__main__':
    p = LatticePaths.find(20)
    print "The number of paths through a 20x20 grid is %.0f" % p
