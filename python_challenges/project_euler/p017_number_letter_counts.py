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
                    60: "sixty", 70: "seventy", 80: "eighty", 90: "ninety",
                    100: "hundred", 1000: "thousand"}
    SEPARATORS = {1000: " ", 100: " and ", 10: "-"}

    def __init__(self, number):
        self.number = number
        self.phrase = ""

    def set_phrase(self):
        self.phrase = ""
        for order in [1000, 100, 10, 1]:
            self.process_digit(order)
        return self.phrase

    def process_digit(self, order):
        if self.number >= order:
            if self.number >= 100:
                digit = self.number / order
                self.number %= order
            elif self.number >= 20:
                digit = 10 * (self.number / order)
                self.number %= order
            else:
                digit = self.number
                self.number = 0
            self.phrase += NumberLetterCounts.NUMBER_WORDS[digit]
            if order >= 100:
                self.phrase += " " + NumberLetterCounts.NUMBER_WORDS[order]
            if self.number > 0:
                self.phrase += NumberLetterCounts.SEPARATORS[order]

    def letter_count(self):
        if self.phrase == '':
            self.set_phrase()
        return len(self.phrase.
                   replace(" ", "").
                   replace("-", ""))

    def find(self):
        total_letters = 0
        for i in range(1, self.number + 1):
            self.number = i
            self.set_phrase()
            letters = self.letter_count()
            if __name__ == '__main__':
                print i, ":", self.phrase, "(", letters, "letters )"
            total_letters += letters
        return total_letters


if __name__ == '__main__':
    limit = 1000
    letters = NumberLetterCounts(limit).find()
    print "If all the numbers from 1 to", limit, "inclusive were written out in words,", \
        "the number of letters used would be", letters
