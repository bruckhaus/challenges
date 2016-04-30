from lib.prime import Prime


class Pandigital:
    def __init__(self):
        self.positions = 9 * [0]
        self.max_length = 9
        self.length = 1

    def largest_prime(self):
        """
        All pandigital numbers of length 2, 3, 5, 6, 8, and 9 are non-prime.
        The reason being that the sum of their digits is divisible by 3 and so these numbers are divisible by 3.
        Hence, only pandigital numbers of length 4 or 7 can be prime.
        """
        largest_pandigital_prime = -1
        for check_length in [4, 7]:
            self.length = check_length
            candidate = self.current()
            while self.length == check_length:
                if candidate > largest_pandigital_prime:
                    if Prime.is_prime(candidate):
                        largest_pandigital_prime = candidate
                candidate = self.next()
        return largest_pandigital_prime

    def current(self):
        """
        As we construct the pandigital number, we use an array of distinct digits.
        We choose from the digits list position by position as indicated by the positions list.
        As we construct the pandigital number we remove digits we used.
        Example: if positions == [2, 0, 0] we generate 312.  For [1, 1, 0] we generate 231.
        """
        digits = range(1, 10)
        result = 0
        for i in range(0, self.length):
            result *= 10
            result += digits[self.positions[i]]
            digits.pop(self.positions[i])
        return result

    def next(self):
        """
        Generate next pandigital number:
        The positions list tracks in what order we choose from the digits list.
        To generate the next legal positions list we increment digits in each position in turn.
        We must check if incrementing the current position would exceed the legally available digits.
        If incrementing is not legal we move to the next position.
        Once all pandigital numbers of one length have been generated we increment the length of generated numbers.
        After all pandigital numbers of legal length have been generated we return -1 to signal completion.
        """
        while self.length <= self.max_length:
            for i in range(0, self.length - 1):
                if i + self.positions[i] < self.length - 1:
                    self.positions[i] += 1
                    return self.current()
                else:
                    self.positions[i] = 0
            if self.length == self.max_length:
                return -1
            self.length += 1
            self.positions = 9 * [0]
            return self.current()
