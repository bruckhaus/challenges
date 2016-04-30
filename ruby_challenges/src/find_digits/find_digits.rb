class FindDigits

  def self.run
    num_tests = gets.to_i
    num_tests.times do |test|
      number = gets.to_i
      divisors = find_digits(number)
      puts divisors
    end
  end

  def self.find_digits(number)
    divisors = 0
    digits   = number.to_s.split('').map(&:to_i)
    digits.each do |digit|
      next if digit == 0
      divisors += 1 if number % digit == 0
    end
    divisors
  end

end

FindDigits.run if __FILE__ == $0
