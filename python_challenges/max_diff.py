__author__ = 'tilmannbruckhaus'


def max_diff(numbers):
    min_num = None
    max_diff = -1
    for i in numbers:
        if min_num is None or i < min_num:
            min_num = i
        diff = i - min_num
        if diff > max_diff and diff > 0:
            max_diff = diff
    return max_diff

if __name__ == '__main__':
    numbers = [2, 3, 10, 2, 4, 8, 1]
    result = max_diff(numbers)
    print "Maximum difference for numbers", numbers, "is", result
