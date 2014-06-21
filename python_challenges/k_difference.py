__author__ = 'tilmann.bruckhaus'

from collections import defaultdict


def k_difference(k, numbers):
    seen = defaultdict(lambda: "default")
    count = 0
    for number in numbers:
        seen[number] = 1
        if seen[number + k] == 1:
            count += 1
        if seen[number - k] == 1:
            count += 1
    print "result = ", count
    return count