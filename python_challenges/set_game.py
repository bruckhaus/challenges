import pprint as pp
import random


class SetGame:
    interactive_mode = False
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
        pass

    def play(self):
        self.make_deck()
        self.deal_hand()
        self.check_hand()

    def make_deck(self):
        self.deck = []
        for fill in self.FILLS:
            for color in self.COLORS:
                for shape in self.SHAPES:
                    for count in self.COUNTS:
                        card = [fill, color, shape, count]
                        self.deck.append(card)
        if self.interactive_mode:
            print "\nDeck:"
            pp.pprint(self.deck)
        return self.deck

    def deal_hand(self):
        for i in range(self.NUM_CARDS_IN_HAND):
            r = random.randint(0, self.NUM_CARDS_IN_DECK - 1 - i)
            card = self.deck[r]
            self.hand.append(card)
            self.deck.remove(card)
        if self.interactive_mode:
            print "\nHand:"
            pp.pprint(self.hand)
        return self.hand

    def check_hand(self):
        matches = []
        if self.interactive_mode:
            print "\nMatches:"
        while self.triplet:
            if self.check_match():
                matches.append(self.triplet[:])
                if self.interactive_mode:
                    self.show_triplet()
            self.next_valid_triplet()
        return matches

    def check_match(self):
        for p in range(self.NUM_ATTRIBUTES):
            if not (self.all_same(p) or self.all_different(p)):
                return False
        return True

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

    def show_triplet(self):
        print "    ", self.triplet
        print "        ", self.hand[self.triplet[0]]
        print "        ", self.hand[self.triplet[1]]
        print "        ", self.hand[self.triplet[2]]

    def next_valid_triplet(self):
        while True:
            self.next_triplet()
            if (not self.triplet) or self.is_triplet_valid():
                break

    def next_triplet(self):
        for p in reversed(range(3)):
            if self.triplet[p] < self.NUM_CARDS_IN_HAND - 1:
                self.triplet[p] += 1
                return
            else:
                self.triplet[p] = 0
        self.triplet = None

    def is_triplet_valid(self):
        t = self.triplet
        # can't choose same card twice:
        if t[0] == t[1] or t[1] == t[2]:
            return False
        # order of cards is not significant: allow only smallest sort order of each combination and reject others:
        if t[0] > t[1] or t[1] > t[2]:
            return False
        return True


if __name__ == '__main__':
    game = SetGame()
    game.interactive_mode = True
    game.play()
