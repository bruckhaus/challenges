__author__ = 'tilmann.bruckhaus'


def k_difference(n, k, numbers):
    dict = Dict.{}
    count = 0
    for number in numbers:
        dict[number] = 1
        if dict[number + k] == 1:
            count += 1
        if dict[number - k] == 1:
            count += 1
    print "result = ", count
    return count

assert 2 == k_difference(3, 1, [1, 2, 3])
assert 3 == k_difference(5, 2, [1, 5, 3, 4, 2])
assert 0 == k_difference(10, 1, [363374326, 364147530, 61825163, 1073065718, 1281246024,
                                 1399469912, 428047635, 491595254, 879792181, 1069262793])
