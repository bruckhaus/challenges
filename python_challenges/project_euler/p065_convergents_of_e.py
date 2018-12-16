# coding=utf-8

"""
Convergents of e
Problem 65
The square root of 2 can be written as an infinite continued fraction.
√2 = 1 + 1 / (2 + 1  / (2 + 1 / (2 + 1 / (2 + ...
The infinite continued fraction can be written, √2 = [1;(2)], (2) indicates that 2 repeats ad infinitum.
In a similar way, √23 = [4;(1,3,1,8)]. It turns out that the sequence of partial values of continued fractions for
square roots provide the best rational approximations. Let us consider the convergents for √2.
1 + 1 / 2 = 3/2
1 + 1 / (2 + 1 / 2) = 7/5
1 + 1 / (2 + 1 / (2 + 1 / 2)) = 17/12
1 + 1 / (2 + 1 / (2 + 1 / (2 + 1 / 2) = 41/29
Hence the sequence of the first ten convergents for √2 are:
1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
What is most surprising is that the important mathematical constant,
e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
The first ten terms in the sequence of convergents for e are:
2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.
Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
See also https://www.mathblog.dk/project-euler-65-numerator-continued-fraction-e/
"""
UPPER_BOUND = 100


def digit_sum(n):
    digit_sum = 0
    n_digits = str(n)
    for digit in n_digits:
        digit_sum += int(digit)
    return digit_sum


def get_numerator_digit_sum(upper_bound):
    # Pattern of numerator of continued fraction for e is: n_k = a_k * n_k-1 + n_k-2
    n_k_1 = 1
    n_k = 2
    for i in range(2, upper_bound + 1):
        a_k = get_factor_increase(i)
        n_k_2 = n_k_1
        n_k_1 = n_k
        n_k = a_k * n_k_1 + n_k_2
    return digit_sum(n_k)


def get_factor_increase(i):
    # the continued fraction forms a regular pattern where every 3rd term factor increases by 2 and the rest are 1:
    return (2 * (i / 3)) if (i % 3 == 0) else 1


if __name__ == "__main__":
    digit_sum = get_numerator_digit_sum(UPPER_BOUND)
    print("The numerator digit sum of convergent %d of the continued fraction for e is %d." % (UPPER_BOUND, digit_sum))
