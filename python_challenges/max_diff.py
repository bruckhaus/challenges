__author__ = 'tilmannbruckhaus'


def max_diff(numbers):
    print "Maximum difference for numbers", numbers, ":",
    min_num = None
    result = -1
    for i in numbers:
        if min_num is None or i < min_num:
            min_num = i
        diff = i - min_num
        if diff > result and diff > 0:
            result = diff
    print result
    return result