__author__ = 'tilmann.bruckhaus'

from collections import defaultdict


def k_difference(numbers, k):
    seen = defaultdict(lambda: "default")
    count = 0
    for number in numbers:
        seen[number] = 1
        if seen[number + k] == 1:
            count += 1
        if seen[number - k] == 1:
            count += 1
    return count


if __name__ == '__main__':
    test_array = [0, 3, 9, 12, 27, 30, 24, 18, 21, 15, 12, 6, 12, 24]
    difference = 3
    pairs = k_difference(test_array, difference)
    print "The number of pairs with difference", difference, "in the array", test_array, "is", pairs
