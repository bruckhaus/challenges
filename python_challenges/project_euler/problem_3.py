__author__ = 'tilmannbruckhaus'

# Largest prime factor
# Problem 3
# The prime factors of 13195 are 5, 7, 13 and 29.
# What is the largest prime factor of the number 600851475143 ?


class LargestPrimeFactor:
    def __init__(self):
        pass

    @staticmethod
    def is_divisible(number, divisor):
        return number % divisor == 0

    @staticmethod
    def is_prime(number):
        result = True
        candidate = 2
        while candidate <= number ** 0.5:
            if LargestPrimeFactor.is_divisible(number, candidate):
                result = False
            candidate += 1
        print "is_prime(", number, "):", result
        return result

    @staticmethod
    def find(n):
        print "\nFinding largest prime factor of", n
        L = LargestPrimeFactor
        result = 1
        candidate = 2
        while candidate <= n ** 0.5:
            if L.is_divisible(n, candidate) and L.is_prime(candidate):
                factor = n / candidate
                if L.is_prime(factor):
                    return factor
                else:
                    result = candidate
                    n = factor
                print "found prime factor: ", result
            else:
                candidate += 1
        return result


if __name__ == '__main__':
    print LargestPrimeFactor.find(2)
    print LargestPrimeFactor.find(3)
    print LargestPrimeFactor.find(4)
    print LargestPrimeFactor.find(7)
    print LargestPrimeFactor.find(15)
    print LargestPrimeFactor.find(44)
    print LargestPrimeFactor.find(99)
    print LargestPrimeFactor.find(111)
    print LargestPrimeFactor.find(1577)
    print LargestPrimeFactor.find(19 * 37 * 83)
    print LargestPrimeFactor.find(600851475143)
