require 'rspec'
require_relative '../src/string_distance'

describe 'string_distance' do
  it 'finds the distance between occurrences of a sub-string in a given string' do
    fixtures = [['baba', 'ba', 4],
                ['ab', 'ab', 2],
                ['x', 'x', 1],
                ['', '', 0],
                ['abc', 'xyz', 0],
                ['', 'a', 0],
                ['123456789012', '12', 12],
                ['Some matching thing in the middle matches the sub-string', 'match', 34],
                ['Some matching thing in the middle matches the sub-string', 'ing', 46],
                ['ba, ba, black sheep, have you any wool?', 'ba', 6],
                ['ba, ba, black sheep, have you any wool? ba', 'ba', 42],
                ['ba, ba, black sheep, have you any wool? ba', 'bam', 0],
                ['abaababababbbbabaaababababbabbbbb', 'a', 28]]
    fixtures.each { |f| string_distance(f[0], f[1]).should == f[2] }
  end
end