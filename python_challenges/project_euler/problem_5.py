__author__ = 'tilmannbruckhaus'

# Smallest multiple
# Problem 5
# 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
# What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
# Answer: 232792560


class SmallestMultiple:
    def __init__(self):
        pass

    @staticmethod
    def find():
        # One candidate solution is the product of 1 * 2 * 3 * ... * 19 * 20.
        # However, since 20 = 2 * 10 the product of 1 * 2 * 3 * ... * 19 is divisible by 20.
        # Similarly, we can eliminate several other factors, and are left with:
        candidate = 5 * 7 * 9 * 11 * 13 * 16 * 17 * 19
        if SmallestMultiple.is_solution(candidate):
            return candidate

    @staticmethod
    def is_solution(n):
        print "checking:", n
        for divisor in range(1, 21):
            if n % divisor != 0:
                return False
        return True


if __name__ == '__main__':
    solution = SmallestMultiple.find()
    print "The smallest positive number that is evenly divisible by all of the numbers from 1 to 20 is", solution
