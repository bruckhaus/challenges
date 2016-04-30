class KnightsDialer

  def initialize
    @dial_pad = [[1, 2, 3],
                 [4, 5, 6],
                 [7, 8, 9],
                 ['*', 0, '#']]

    @dial_pad_coordinates = {1   => [0, 0], 2 => [0, 1], 3 => [0, 2],
                             4   => [1, 0], 5 => [1, 1], 6 => [1, 2],
                             7   => [2, 0], 8 => [2, 1], 9 => [2, 2],
                             '*' => [3, 0], 0 => [3, 1], '#' => [3, 2]}

    @knight_moves = [[-2, 1], [-2, -1], [-1, 2], [-1, -2], [1, 2], [1, -2], [2, 1], [2, -1]]
  end

  def solve
    count = 0
    10.times { |start| count += legal_numbers([start]) }
    puts "The knight can dial #{count} legal numbers."
  end

  def legal_numbers(prefix)
    return 0 if prefix.length > 7
    return 1 if prefix.length == 7
    count = 0
    @knight_moves.each do |move|
      next_digit = next_digit(prefix[-1], move)
      count += legal_numbers(prefix + [next_digit]) if next_digit
    end
    count
  end

  def next_digit(start, move)
    coordinates = @dial_pad_coordinates[start]
    row         = coordinates[0] + move[0]
    column      = coordinates[1] + move[1]
    return false if not_on_pad(row, column)
    next_digit = @dial_pad[row][column]
    return false if %w(* #).include? next_digit
    next_digit
  end

  def not_on_pad(row, column)
    column < 0 || column > 2 || row < 0 || row > 3
  end

end

KnightsDialer.new.solve if __FILE__ == $0
