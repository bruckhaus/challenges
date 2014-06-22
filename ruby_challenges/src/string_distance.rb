def string_distance(string, sub_string)
  result = recursive_string_distance(string, sub_string)
  puts "Largest distance of occurrences of #{sub_string} in #{string}: #{result}"
  result
end

def recursive_string_distance(string, sub_string)
  # Using recursion rather than built-in functions.
  # Organizing code for clarity in favor of performance.

  string_length     = string.length
  sub_string_length = sub_string.length
  first             = string[0..sub_string_length-1]
  last              = string[-sub_string_length..-1]

  return 0 if string_length < sub_string_length
  return recursive_string_distance(string[1..-1], sub_string) unless first == sub_string
  return recursive_string_distance(string[0..-2], sub_string) unless last == sub_string
  string_length
end