def reverse_string(string)
  result = ''
  string.split('').each { |character| result = character + result}
  puts "Reverse of #{string} is #{result}"
  result
end