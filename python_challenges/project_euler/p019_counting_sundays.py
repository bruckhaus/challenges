__author__ = 'tilmannbruckhaus'


class CountingSundays:
    # Counting Sundays
    # Problem 19
    # You are given the following information, but you may prefer to do some research for yourself.
    #
    # 1 Jan 1900 was a Monday.
    # Thirty days has September,
    # April, June and November.
    # All the rest have thirty-one,
    # Saving February alone,
    # Which has twenty-eight, rain or shine.
    # And on leap years, twenty-nine.
    # A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
    # How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

    def __init__(self):
        pass

    @staticmethod
    def find(start_year=1901, end_year=2000):
        year = 1900
        month = 1
        day = 1
        sunday_count = 0
        while year <= end_year:
            if day == 0 and year >= start_year:
                sunday_count += 1
                if __name__ == '__main__':
                    print "The first of", month, year, "was a Sunday"
            day += CountingSundays.days_in_month(month, year)
            day %= 7
            month += 1
            if month > 12:
                month = 1
                year += 1
        return sunday_count

    @staticmethod
    def days_in_month(month, year):
        if month in [1, 3, 5, 7, 8, 10, 12]:
            return 31
        if month in [4, 6, 9, 11]:
            return 30
        if CountingSundays.is_leap_year(year):
            return 29
        else:
            return 28

    @staticmethod
    def is_leap_year(year):
        return (year % 4 == 0 and year % 100 != 0) or year % 400 == 0


if __name__ == '__main__':
    n = CountingSundays.find(1901, 2000)
    print "The number of Sundays that fell on the first of the month " + \
          "during the twentieth century (1 Jan 1901 to 31 Dec 2000) is", n
