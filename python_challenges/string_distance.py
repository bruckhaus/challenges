__author__ = 'tilmannbruckhaus'


def string_distance(query, doc_string):
    distance = 0
    start = doc_string.find(query)
    end = doc_string.rfind(query)
    if start >= 0:
        distance = end - start + len(query)
    return distance

if __name__ == '__main__':
    sub_string = 'match'
    input_string = 'Some matching thing in the middle matches the sub-string'
    result = string_distance(sub_string, input_string)
    print "The greatest distance between occurrences of [", sub_string, "] in [", input_string, "] is", result
