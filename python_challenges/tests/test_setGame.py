from unittest import TestCase
from set_game import SetGame

__author__ = 'tilmannbruckhaus'


class TestSetGame(TestCase):
    def test_make_deck(self):
        deck = SetGame().make_deck()
        self.assertEqual(81, len(deck))  # expected number of cards: 3 shapes * 3 fills * 3 colors * 3 counts
        self.assertEqual(81, len(make_set(deck)))  # cards are unique

    def test_deal_hand(self):
        game = SetGame()
        game.make_deck()
        self.assertEqual(81, len(game.deck))  # expected number of cards in deck
        hand = game.deal_hand()
        self.assertEqual(12, len(hand))
        self.assertEqual(12, len(make_set(hand)))  # cards are unique
        self.assertEqual(69, len(game.deck))  # cards in hand were removed from deck
        # removed just those cards from deck that were dealt into hand:
        self.assertEqual(81, len(make_set(game.deck + hand)))

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
        game.triplet = [0, 1, 2]
        game.hand = [['empty', 'blue', 'squiggly', 1],
                     ['striped', 'green', 'squiggly', 2],
                     ['empty', 'red', 'squiggly', 3]]
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
        self.assertEqual(12 ** 3, count)  # each of 3 positions can hold any of 12 cards (with replacement)

    def test_next_valid_triplet(self):
        game = SetGame()
        count = 0
        game.next_valid_triplet()
        while game.triplet:
            count += 1
            game.next_valid_triplet()
        self.assertEqual(220, count)  # 12 choose 3 == 220

    def test_check_hand(self):
        game = SetGame()
        game.hand = [['full', 'green', 'squiggly', 3],
                     ['full', 'blue', 'squiggly', 2],
                     ['full', 'green', 'diamond', 1],  # card 2
                     ['full', 'red', 'squiggly', 2],
                     ['empty', 'green', 'squiggly', 1],  # card 4
                     ['striped', 'red', 'oval', 3],
                     ['full', 'blue', 'oval', 1],  # card 6
                     ['empty', 'blue', 'squiggly', 3],
                     ['empty', 'blue', 'diamond', 1],  # card 8
                     ['striped', 'red', 'diamond', 1],  # card 9
                     ['full', 'red', 'squiggly', 3],
                     ['striped', 'red', 'oval', 1]]
        expected = [[2, 8, 9],
                    [4, 6, 9]]
        matches = game.check_hand()
        self.assertEqual(expected, matches)


# Helper functions:

def make_set(list_input):
    string_list = [str(item) for item in list_input]
    result_set = set(string_list)
    return result_set