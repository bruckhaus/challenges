__author__ = 'tilmannbruckhaus'


class AmicableNumbers:
    # Amicable numbers
    # Problem 21
    # Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
    # If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called
    # amicable numbers.
    #
    # For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
    # The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
    #
    # Evaluate the sum of all the amicable numbers under 10000.

    def __init__(self):
        pass

    @staticmethod
    def find(n):
        amicable_sum = 0
        for i in range(1, n):
            if AmicableNumbers.is_amicable(i):
                amicable_sum += i
        return amicable_sum

    @staticmethod
    def is_amicable(n):
        # example: n = 220
        divisors_a = AmicableNumbers.get_divisors(n)  # 1, 2, 4, 5, 10, 11, 22, 44, 55, 110
        sum_a = sum(divisors_a)  # 284
        divisors_b = AmicableNumbers.get_divisors(sum_a)  # 1, 2, 4, 71, 142
        sum_b = sum(divisors_b)  # 220
        return sum_b == n and sum_b != sum_a

    @staticmethod
    def get_divisors(n):
        divisors = []
        for i in range(1, n):
            if n % i == 0:
                divisors.append(i)
        return divisors


if __name__ == '__main__':
    a = AmicableNumbers.find(10000)
    print "The sum of all the amicable numbers under 10,000 is", a
