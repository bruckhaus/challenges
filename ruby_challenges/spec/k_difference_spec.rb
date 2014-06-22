require 'rspec'
require_relative '../src/k_difference'

describe 'k_difference' do
  it 'counts pairs with difference in an array of numbers' do
    k_difference([1, 2, 3], 1).should == 2
    k_difference([1, 5, 3, 4, 2], 2).should == 3
    k_difference([0, 1, 2, 3, 4, 5, 6, 7, 8, 9], 1).should == 9
    k_difference([363374326, 364147530, 61825163, 1073065718, 1281246024,
                  1399469912, 428047635, 491595254, 879792181, 1069262793], 1).should == 0
  end
end
