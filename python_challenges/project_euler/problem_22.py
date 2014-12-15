import os

__author__ = 'tilmannbruckhaus'


class NameScores:
    # Names scores
    # Problem 22
    # Using names.txt (right click and 'Save Link/Target As...'),
    # a 46K text file containing over five-thousand first names,
    # begin by sorting it into alphabetical order.
    # Then working out the alphabetical value for each name,
    # multiply this value by its alphabetical position in the list
    # to obtain a name score.
    #
    # For example, when the list is sorted into alphabetical order,
    # COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
    # is the 938th name in the list.
    # So, COLIN would obtain a score of 938 x 53 = 49714.
    #
    # What is the total of all the name scores in the file?

    def __init__(self, file_path):
        self.file_path = os.path.join(os.path.dirname(__file__), file_path)
        with open(self.file_path) as f:
            self.lines = f.read().split(",")
        self.names = []
        for line in self.lines:
            self.names.append(line.strip('"'))


    def find(self):
        score_sum = 0
        rank = 0
        for name in sorted(self.names):
            rank += 1
            score_sum += rank * NameScores.score(name)
        return score_sum

    @staticmethod
    def score(name):
        score = 0
        for char in name:
            score += ord(char) - ord("A") + 1
        return score


if __name__ == '__main__':
    n = NameScores('../tests/resources/p022_names.txt').find()
    print "The total of all the name scores in the file is", n