require 'rspec'
require_relative '../src/reverse_string'

describe 'reverse_string' do
  it 'reverses the given string' do
    reverse_string('abc').should == 'cba'
    reverse_string('This is my TEST String!').should == '!gnirtS TSET ym si sihT'
    reverse_string('').should == ''
    reverse_string('x').should == 'x'
  end
end