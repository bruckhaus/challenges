import pprint
from unittest import TestCase
from set_game import SetGame

__author__ = 'tilmannbruckhaus'


class TestSetGame(TestCase):
    def test_make_deck(self):
        deck = SetGame().make_deck()
        self.assertEqual(81, len(deck))

    def test_deal_hand(self):
        game = SetGame()
        game.make_deck()
        hand = game.deal_hand()
        self.assertEqual(12, len(hand))

    def test_all_same(self):
        game = SetGame()
        game.hand = [['empty', 'blue', 'squiggly', 1],
                     ['striped', 'green', 'squiggly', 2],
                     ['empty', 'red', 'squiggly', 3]]
        game.triplet = [0, 1, 2]
        self.assertEqual(False, game.all_same(0))
        self.assertEqual(False, game.all_same(1))
        self.assertEqual(True, game.all_same(2))
        self.assertEqual(False, game.all_same(3))

    def test_all_different(self):
        game = SetGame()
        game.hand = [['empty', 'blue', 'squiggly', 1],
                     ['striped', 'green', 'squiggly', 2],
                     ['empty', 'red', 'squiggly', 3]]
        game.triplet = [0, 1, 2]
        self.assertEqual(False, game.all_different(0))
        self.assertEqual(True, game.all_different(1))
        self.assertEqual(False, game.all_different(2))
        self.assertEqual(True, game.all_different(3))

    def test_check_match(self):
        game = SetGame()
        game.hand = [['empty', 'blue', 'squiggly', 1],
                     ['striped', 'green', 'squiggly', 2],
                     ['empty', 'red', 'squiggly', 3]]
        game.triplet = [0, 1, 2]
        self.assertEqual(False, game.check_match())
        game.hand = [['empty', 'blue', 'squiggly', 1],
                     ['striped', 'green', 'squiggly', 2],
                     ['full', 'red', 'squiggly', 3]]
        self.assertEqual(True, game.check_match())

    def test_next_triplet(self):
        game = SetGame()
        count = 0
        while game.triplet:
            count += 1
            game.next_triplet()
        self.assertEqual(12 ** 3, count)

    def test_check_hand(self):
        game = SetGame()
        game.hand = [['full', 'green', 'squiggly', 3],
                     ['full', 'blue', 'squiggly', 2],
                     ['full', 'green', 'diamond', 1],
                     ['full', 'red', 'squiggly', 2],
                     ['empty', 'green', 'squiggly', 1],
                     ['striped', 'red', 'oval', 3],
                     ['full', 'blue', 'oval', 1],
                     ['empty', 'blue', 'squiggly', 3],
                     ['empty', 'blue', 'diamond', 1],
                     ['striped', 'red', 'diamond', 1],
                     ['full', 'red', 'squiggly', 3],
                     ['striped', 'red', 'oval', 1]]
        expected = [[2, 8, 9],
                    [4, 6, 9]]
        matches = game.check_hand()
        self.assertEqual(expected, matches)