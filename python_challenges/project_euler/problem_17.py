__author__ = 'tbruckhaus'


class NumberLetterCounts:
    # Number letter counts
    # Problem 17
    #
    # If the numbers 1 to 5 are written out in words: one, two, three, four, five,
    # then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
    #
    # If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
    # how many letters would be used?
    #
    # NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters
    # and 115 (one hundred and fifteen) contains 20 letters.
    # The use of "and" when writing out numbers is in compliance with British usage.

    NUMBER_WORDS = {1: "one", 2: "two", 3: "three", 4: "four", 5: "five",
                    6: "six", 7: "seven", 8: "eight", 9: "nine", 10: "ten",
                    11: "eleven", 12: "twelve", 13: "thirteen", 14: "fourteen", 15: "fifteen",
                    16: "sixteen", 17: "seventeen", 18: "eighteen", 19: "nineteen",
                    20: "twenty", 30: "thirty", 40: "forty", 50: "fifty",
                    60: "sixty", 70: "seventy", 80: "eighty", 90: "ninety"}

    def __init__(self):
        pass

    @staticmethod
    def find(n):
        nlc = NumberLetterCounts
        total_letters = 0
        for i in range(1, n + 1):
            words = nlc.in_words(i)
            letters = nlc.letter_count(words)
            if __name__ == '__main__':
                print i, ":", words, "(", letters, "letters )"
            total_letters += letters
        return total_letters

    @staticmethod
    def in_words(i):
        d = NumberLetterCounts.NUMBER_WORDS
        words = ''
        if i >= 1000:
            thousands = i / 1000
            i %= 1000
            words = d[thousands] + " thousand"
            if i > 0:
                words += " "
        if i >= 100:
            hundreds = i / 100
            i %= 100
            words += d[hundreds] + " hundred"
            if i > 0:
                words += " and "
        if i >= 20:
            tens = i / 10
            i %= 10
            words += d[tens * 10]
            if i > 0:
                words += "-"
        if i >= 1:
            words += d[i]
        return words

    @staticmethod
    def letter_count(phrase):
        return len(phrase.
                   replace(" ", "").
                   replace("-", ""))


if __name__ == '__main__':
    limit = 1000
    letters = NumberLetterCounts.find(limit)
    print "If all the numbers from 1 to", limit, "inclusive were written out in words,", \
        "the number of letters used would be", letters
