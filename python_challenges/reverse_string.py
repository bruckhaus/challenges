__author__ = 'tilmannbruckhaus'


def reverse_string(input_string):
    output = input_string[::-1]
    return output

if __name__ == '__main__':
    s = 'This is my TEST String!'
    print "The reverse of string [", s, "] is [", reverse_string(s), "]"
