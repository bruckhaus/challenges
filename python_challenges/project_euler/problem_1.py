__author__ = 'tilmannbruckhaus'


def divisible_by_3_or_5(i):
    divisible = i % 3 == 0 or i % 5 == 0
    # print("natural number:", i, "is divisible:", divisible)
    return divisible


def sum_of_multiples_of_3_or_5(limit):
    # If we list all the natural numbers below 10 that are multiples of 3 or 5,
    # we get 3, 5, 6 and 9. The sum of these multiples is 23.
    # Find the sum of all the multiples of 3 or 5 below 1000.
    multi_sum = 0
    for limit in range(limit):
        if divisible_by_3_or_5(limit):
            multi_sum += limit
    return multi_sum

for test_limit in [10, 1000]:
    print sum_of_multiples_of_3_or_5(test_limit)
