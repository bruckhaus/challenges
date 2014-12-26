from collections import defaultdict

__author__ = 'tilmannbruckhaus'


class SummationOfPrimes:

    # Summation of primes
    # Problem 10
    # The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    # Find the sum of all the primes below two million.

    def __init__(self):
        self.prime_dict = defaultdict(lambda: True)

    def find(self):
        sum_of_primes = 0
        for i in range(2, 2000000):
            if not self.prime_dict[i]:
                continue
            sum_of_primes += i
            for j in range(i + i, 2000000, i):
                self.prime_dict[j] = False
        return sum_of_primes


if __name__ == '__main__':
    prime_sum = SummationOfPrimes().find()
    print 'The sum of all the primes below two million is', prime_sum
