class Pandigital
  def initialize
    @positions  = [0] * 9
    @length     = 1
    @max_length = 9
  end

  def largest_prime
    # Find the largest pandigital prime number.
    # Only pandigital numbers of length 4 or 7 can be prime.
    # [http://www.mathblog.dk/project-euler-41-pandigital-prime/]
    largest_pandigital = -1
    [4, 7].each do |checked_length|
      puts "Checking pandigital numbers of length #{checked_length}"
      @length    = checked_length
      @positions = [0] * 9
      candidate  = current
      while @length == checked_length
        if candidate > largest_pandigital
          if is_prime(candidate)
            largest_pandigital = candidate
          end
        end
        candidate = next_pandigital
      end
    end
    largest_pandigital
  end

  def current
    digits  =* (1..9)
    current = 0
    (0..@length - 1).each do |position|
      current *= 10
      current += digits[@positions[position]]
      digits.delete_at(@positions[position])
    end
    current
  end

  def next_pandigital
    return -1 if @length > @max_length
    (0..@length-1).each do |position|
      if position + @positions[position] < @length - 1
        @positions[position] += 1
        return current
      else
        @positions[position] = 0
      end
    end
    @length    += 1
    @positions = [0] * 9
    return current if @length <= @max_length
    -1
  end

  def list(length)
    @length     = length
    @max_length = length
    @positions  = [0] * 9
    list        = []
    pandigital  = current
    while pandigital != -1 do
      list.push(pandigital)
      pandigital = next_pandigital
    end
    list
  end

end

def is_prime(number)
  return false if number == 1
  return true if number == 2
  return true if number == 3
  return false if number & 1 == 0
  return false if divisible_by_3(number)
  divisor = 5
  while divisor <= Math.sqrt(number)
    return false if number % divisor == 0
    divisor += 2
  end
  true
end

def divisible_by_3(number)
  string    = number.to_s
  digit_sum = string.split('').inject(0) { |sum, c| sum + c.to_i }
  return divisible_by_3(digit_sum) if digit_sum > 11
  [3, 6, 9].include?(digit_sum)
end
