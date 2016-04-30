require_relative '../src/knights_dialer/knights_dialer'

describe KnightsDialer do

  let(:kd) { KnightsDialer.new }

  describe '#legal_numbers' do
    it 'determines the number of legal 7-digit phone numbers with the given prefix' do
      kd.legal_numbers([1]).should == 136
      kd.legal_numbers([1, 2]).should == 52
      kd.legal_numbers([1, 2, 3]).should == 26
      kd.legal_numbers([1, 2, 3, 4]).should == 16
      kd.legal_numbers([1, 2, 3, 4, 5]).should == 0
      kd.legal_numbers([1, 2, 3, 4, 5, 6]).should == 3
      kd.legal_numbers([1, 2, 3, 4, 5, 6, 7]).should == 1
      kd.legal_numbers([1, 2, 3, 4, 5, 6, 7, 8]).should == 0
    end
  end

  describe '#next_digit' do
    it 'returns a digit based on a starting key and a knight move' do
      kd.next_digit(1, [-2, -1]).should == false
      kd.next_digit(1, [-2, 1]).should == false
      kd.next_digit(1, [-1, -2]).should == false
      kd.next_digit(1, [-1, 2]).should == false
      kd.next_digit(1, [1, -2]).should == false
      kd.next_digit(1, [1, 2]).should == 6
      kd.next_digit(1, [2, -1]).should == false
      kd.next_digit(1, [2, 1]).should == 8

      kd.next_digit(4, [-1, 2]).should == 3
      kd.next_digit(4, [1, 2]).should == 9
      kd.next_digit(4, [2, 1]).should == 0
    end
  end

  describe '#not_on_pad' do
    it 'returns true if the coordinates given are outside of the phone pad' do
      kd.not_on_pad(0, 0).should == false
      kd.not_on_pad(1, 0).should == false
      kd.not_on_pad(2, 0).should == false
      kd.not_on_pad(3, 0).should == false
      kd.not_on_pad(3, 1).should == false
      kd.not_on_pad(3, 2).should == false
      kd.not_on_pad(3, 3).should == true
      kd.not_on_pad(-1, 1).should == true
      kd.not_on_pad(-1, 9).should == true
    end
  end

end
