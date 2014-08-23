import pprint
import random


class SetGame:
    NUM_CARDS_IN_DECK = 81
    NUM_CARDS_IN_HAND = 12
    NUM_ATTRIBUTES = 4
    FILLS = ['empty', 'striped', 'full']
    COLORS = ['red', 'green', 'blue']
    SHAPES = ['diamond', 'squiggly', 'oval']
    COUNTS = [1, 2, 3]
    deck = []
    hand = []
    triplet = [0, 1, 2]

    def __init__(self):
        self.pp = pprint.PrettyPrinter(indent=4)

    def make_deck(self):
        for fill in self.FILLS:
            for color in self.COLORS:
                for shape in self.SHAPES:
                    for count in self.COUNTS:
                        card = [fill, color, shape, count]
                        self.deck.append(card)
        print "\nDeck:"
        self.pp.pprint(self.deck)

    def deal_hand(self):
        for i in range(self.NUM_CARDS_IN_HAND):
            r = random.randint(0, self.NUM_CARDS_IN_DECK - 1 - i)
            card = self.deck[r]
            self.hand.append(card)
            self.deck.remove(card)
        print "\nHand:"
        self.pp.pprint(self.hand)

    def all_same(self, p):
        t = self.triplet
        t1 = self.hand[t[0]]
        t2 = self.hand[t[1]]
        t3 = self.hand[t[2]]
        return t1[p] == t2[p] and t2[p] == t3[p]

    def all_different(self, p):
        t = self.triplet
        t1 = self.hand[t[0]]
        t2 = self.hand[t[1]]
        t3 = self.hand[t[2]]
        return t1[p] != t2[p] and t2[p] != t3[p] and t1[p] != t3[p]

    def check_match(self):
        t = self.triplet
        if t[0] == t[1] or t[1] == t[2]:
            return False
        if t[1] < t[0] or t[2] < t[1]:
            return False
        for p in range(self.NUM_ATTRIBUTES):
            if not (self.all_same(p) or self.all_different(p)):
                return False
        return True

    def next_triplet(self):
        for p in reversed(range(3)):
            if self.triplet[p] < self.NUM_CARDS_IN_HAND - 1:
                self.triplet[p] += 1
                return
            else:
                self.triplet[p] = 0
        self.triplet = None

    def show_triplet(self):
        print "    ", self.triplet
        print "        ", self.hand[self.triplet[0]]
        print "        ", self.hand[self.triplet[1]]
        print "        ", self.hand[self.triplet[2]]

    def check_hand(self):
        print "\nMatches:"
        while self.triplet:
            if self.check_match():
                self.show_triplet()
            self.next_triplet()

    def play(self):
        self.make_deck()
        self.deal_hand()
        self.check_hand()


SetGame().play()
