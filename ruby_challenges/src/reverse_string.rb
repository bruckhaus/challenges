def reverse_string(string)
  # reverse string without using Ruby's String#reverse
  result = ''
  string.split('').each { |character| result = character + result}
  puts "Reverse of #{string} is #{result}"
  result
end