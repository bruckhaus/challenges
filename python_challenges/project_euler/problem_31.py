# coding=utf-8
class CoinSum:
    """
    Coin sums
    Problem 31
    In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
    It is possible to make £2 in the following way:

    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
    How many different ways can £2 be made using any number of coins?
    """

    def __init__(self):
        pass

    @staticmethod
    def find(n, this_coin=-1, last_coin=-1):
        c = CoinSum
        if n < 0 or c.illegal(this_coin, last_coin):
            return 0
        elif n == 0:
            return 1
        else:
            return c.find(n - 1, 1, this_coin) + \
                   c.find(n - 2, 2, this_coin) + \
                   c.find(n - 5, 5, this_coin) + \
                   c.find(n - 10, 10, this_coin) + \
                   c.find(n - 20, 20, this_coin) + \
                   c.find(n - 50, 50, this_coin) + \
                   c.find(n - 100, 100, this_coin) + \
                   c.find(n - 200, 200, this_coin)

    @staticmethod
    def illegal(this_coin, last_coin):
        return (this_coin > -1) and \
               (last_coin > -1) and \
               (this_coin < last_coin)


if __name__ == '__main__':
    c = CoinSum.find(200)
    print "The number of different ways £2 can be made using any number of coins is", c
