__author__ = 'tilmann.bruckhaus'


class Hanoi:

    def __init__(self, disks):
        print "Playing \"Towers of Hanoi\" for ", disks, " disks:"
        self.disks = disks
        self.source_peg = []
        self.helper_peg = []
        self.target_peg = []
        self.set_up_pegs()
        self.show()

    def solve(self):
        self.move(self.disks, self.source_peg, self.target_peg, self.helper_peg)
        print "\nSolved."

    def move(self, peg_count, source_peg, target_peg, helper_peg):
        if peg_count >= 1:
            self.move(peg_count - 1, source_peg, helper_peg, target_peg)
            target_peg.append(source_peg.pop())
            self.show()
            self.move(peg_count - 1, helper_peg, target_peg, source_peg)

    def show(self):
        print "\nsource_pge: ", self.source_peg
        print "helper_pge: ", self.helper_peg
        print "target_pge: ", self.target_peg

    def set_up_pegs(self):
        for i in reversed(range(1, self.disks + 1)):
            self.source_peg.append(i)

if __name__ == '__main__':
    Hanoi(4).solve()