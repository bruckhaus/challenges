def max_difference(numbers)
  min = nil
  max = -1
  numbers.each do |number|
    if min == nil or number < min
      min = number
    end
    diff = number - min
    if diff > 0 and diff > max
      max = diff
    end
  end
  max
end