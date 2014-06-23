require 'rspec'
require_relative '../src/pandigital'

describe 'Pandigital' do
  describe '#is_prime' do
    it 'checks if the given number is a prime number' do
      primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
                43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
      (1..100).reject { |n| !is_prime(n) }.should == primes
    end
  end

  describe '#largest_pandigital' do
    it 'checks if the given number is a prime number' do
      Pandigital.new.list(4).sort.should ==
          [1234, 1243, 1324, 1342, 1423, 1432, 2134, 2143, 2314, 2341, 2413, 2431,
           3124, 3142, 3214, 3241, 3412, 3421, 4123, 4132, 4213, 4231, 4312, 4321]
    end
  end

  describe '#largest_prime' do
    it 'returns the largest pandigital prime' do
      Pandigital.new.largest_pandigital.should == 7652413
    end
  end
end
