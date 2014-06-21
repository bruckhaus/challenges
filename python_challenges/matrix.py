__author__ = 'tilmann.bruckhaus'


class Matrix:
    def __init__(self, values):
        self.values = values

    def traverse(self):
        print "\nInput"
        self.show()
        self.compute_paths()
        print "Paths:"
        self.show()
        return self.values[-1][-1]

    def compute_paths(self):
        for row in range(len(self.values)):
            for column in range(len(self.values[row])):
                if row == 0 and column == 0:
                    if self.values[row][column] == 1:
                        self.values[row][column] = 1
                    else:
                        self.values[row][column] = 0
                elif row == 0:
                    if self.values[row][column] == 1:
                        self.values[row][column] = self.values[row][column - 1]
                    else:
                        self.values[row][column] = 0
                elif column == 0:
                    if self.values[row][column] == 1:
                        self.values[row][column] = self.values[row - 1][column]
                    else:
                        self.values[row][column] = 0
                else:
                    if self.values[row][column] == 1:
                        self.values[row][column] = self.values[row - 1][column] + self.values[row][column - 1]
                    else:
                        self.values[row][column] = 0

    def show(self):
        for row in range(len(self.values)):
            print self.values[row]