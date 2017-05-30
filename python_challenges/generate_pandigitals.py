class GeneratePandigital:
    def __init__(self):
        pass

    @classmethod
    def generate_pandigitals(cls, n):
        return cls.generate_from_set(set(range(1, n + 1)))

    @classmethod
    def generate_from_set(cls, s):
        result = []
        if len(s) == 1:
            return [s.pop()]
        for digit in sorted(s):
            remainder = set(s)
            remainder.remove(digit)
            postfixes = cls.generate_from_set(remainder)
            for postfix in postfixes:
                result.append(int('' + str(digit) + str(postfix)))
        return result


if __name__ == "__main__":
    for i in range(1, 5):
        print "Digit numbers for", i, ": ", GeneratePandigital.generate_pandigitals(i)
