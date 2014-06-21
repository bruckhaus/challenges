__author__ = 'tilmannbruckhaus'

import unittest
import string_distance


class TestStringDistance(unittest.TestCase):
    def test_string_distance(self):

        fixtures = [["baba", "ba", 4],
                    ["ab", "ab", 2],
                    ["x", "x", 1],
                    ["", "", 0],
                    ["abc", "xyz", 0],
                    ["", "a", 0],
                    ["123456789012", "12", 12],
                    ["Some matching thing in the middle matches the sub-string", "match", 34],
                    ["Some matching thing in the middle matches the sub-string", "ing", 46],
                    ["ba, ba, black sheep, have you any wool?", "ba", 6],
                    ["ba, ba, black sheep, have you any wool? ba", "ba", 42],
                    ["ba, ba, black sheep, have you any wool? ba", "bam", 0],
                    ["abaababababbbbabaaababababbabbbbb", "a", 28]]

        for fixture in fixtures:
            self.assertEquals(fixture[2], string_distance.string_distance(fixture[0], fixture[1]))

if __name__ == '__main__':
    unittest.main()