require_relative '../src/find_digits/find_digits'
describe FindDigits do
  describe '#find_digits' do
    it 'finds the number of digits that are divisors' do
      FindDigits.find_digits(12).should == 2          # 21 is divisible by 2 and 1, i.e., 2 of its digits
      FindDigits.find_digits(21).should == 1          # 1
      FindDigits.find_digits(44).should == 2          # 4, 4
      FindDigits.find_digits(999).should == 3         # 9, 9, 9
      FindDigits.find_digits(123456).should == 5      # 1, 2, 3, 4, 6
      FindDigits.find_digits(123467890).should == 3   # 1, 2, 7
    end
  end
end
