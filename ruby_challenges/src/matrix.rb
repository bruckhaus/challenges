require 'pp'

class Matrix

  def initialize(values)
    puts "\nCalculating paths for matrix:"
    @values = values
    show
  end

  def solve
    (0..(@values.length - 1)).each do |row|
      (0..(@values[row].length - 1)).each do |column|
        unless @values[row][column] == 0
          unless row == 0 and column == 0
            if row == 0
              @values[row][column] = @values[row][column - 1]
            elsif column == 0
              @values[row][column] = @values[row - 1][column]
            else
              @values[row][column] = @values[row - 1][column] + @values[row][column - 1]
            end
          end
        end
      end
    end
    puts 'Path analysis:'
    show
    result = @values[-1][-1]
    puts "Number of paths: #{result}"
    result
  end

  def show
    (0..(@values.length - 1)).each do |row|
      pp @values[row]
    end
  end

end