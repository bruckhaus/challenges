require_relative '../src/utopian_tree/utopian_tree'

describe UtopianTree do
  include UtopianTree
  describe "#calculate_height" do
    it "reads from stdin and writes correct output to stdout" do
      calculate_height([2, 0, 1]).should == [1, 2]
      calculate_height([2, 3, 4]).should == [6, 7]
      calculate_height([4, 5, 7, 14, 25]).should == [14, 30, 255, 16382]
    end
  end
end
