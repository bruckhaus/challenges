__author__ = 'tilmannbruckhaus'


class SumOfMultiples:

    def __init__(self):
        pass

    @staticmethod
    def divisible_by_3_or_5(i):
        return i % 3 == 0 or i % 5 == 0

    @staticmethod
    def sum_of_multiples_of_3_or_5(limit):
        # If we list all the natural numbers below 10 that are multiples of 3 or 5,
        # we get 3, 5, 6 and 9. The sum of these multiples is 23.
        # Find the sum of all the multiples of 3 or 5 below 1000.
        multi_sum = 0
        for i in range(limit):
            if SumOfMultiples.divisible_by_3_or_5(i):
                multi_sum += i
        return multi_sum


if __name__ == '__main__':
    som = SumOfMultiples()
    for test_limit in [10, 1000]:
        result = som.sum_of_multiples_of_3_or_5(test_limit)
        print "The sum of multiples of 3 or 5 less than", test_limit, "is", result
