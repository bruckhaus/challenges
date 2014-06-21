__author__ = 'tilmannbruckhaus'


def string_distance(input_string, sub_string):
    distance = 0
    start = input_string.find(sub_string)
    end = input_string.rfind(sub_string)
    if start >= 0:
        distance = end - start + len(sub_string)
    print "The greatest distance between occurrences of", sub_string, "in", input_string, "is", distance
    return distance