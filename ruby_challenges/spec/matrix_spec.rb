require 'rspec'
require_relative '../src/matrix'

describe 'Matrix#solve' do
  it 'calculates legal paths through the matrix' do
    Matrix.new([[0]]).solve.should == 0
    Matrix.new([[1]]).solve.should == 1
    Matrix.new([[1, 1],
                [0, 1]]).solve.should == 1
    Matrix.new([[1, 1, 1],
                [1, 0, 1],
                [1, 1, 1]]).solve.should == 2
    Matrix.new([[1, 1, 1, 1],
                [1, 1, 0, 1],
                [1, 1, 1, 1],
                [1, 1, 1, 1]]).solve.should == 11
    Matrix.new([[1, 1, 1, 1, 1],
                [1, 1, 1, 0, 1],
                [1, 1, 1, 1, 1],
                [1, 1, 1, 1, 1]]).solve.should == 23
    Matrix.new([[1, 1, 1, 1],
                [1, 1, 1, 1],
                [1, 1, 1, 1]]).solve.should == 10
    Matrix.new([[1, 1, 1, 1],
                [1, 1, 0, 1],
                [1, 1, 1, 1]]).solve.should == 4
  end
end