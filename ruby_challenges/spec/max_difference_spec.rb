require 'rspec'
require_relative '../src/max_difference'

describe 'k_difference' do
  it 'should calculate the maximum difference for an array of numbers' do
    max_difference([2, 3, 10, 2, 4, 8, 1]).should == 8
    max_difference([7, 9, 5, 6, 3, 2]).should == 2
    max_difference([5, 4, 3, 2, 1]).should == -1
    max_difference([1, 2]).should == 1
    max_difference([111, 112]).should == 1
    max_difference([]).should == -1
  end
end