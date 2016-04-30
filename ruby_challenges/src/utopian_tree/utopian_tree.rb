module UtopianTree

  def calculate_height(input)
    num_cycles = input[0]
    cycle_list = input[1..-1]
    print "Utopian tree height for #{num_cycles} cycles #{cycle_list}: "
    output = calculate_cycle_heights(num_cycles, cycle_list)
    puts "#{output}"
    output
  end

  def calculate_cycle_heights(num_cycles, cycle_list)
    output = []
    num_cycles.times do |test|
      cycles = cycle_list.shift
      height = 1
      cycles.times { |cycle| cycle % 2 == 0 ? height *= 2 : height += 1 }
      output.push(height)
    end
    output
  end

end