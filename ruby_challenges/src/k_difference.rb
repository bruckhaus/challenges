def k_difference(numbers, k)
  print "Count of pairs with difference #{k} in set #{numbers}: "
  count = 0
  seen = {}
  numbers.each do |number|
    count += 1 if seen[number - k]
    count += 1 if seen[number + k]
    seen[number] = true
  end
  puts count
  count
end