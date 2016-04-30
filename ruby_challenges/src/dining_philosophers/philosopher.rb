class Philosopher
  def initialize(name)
    @name = name
    @state = 'sitting'
    @sticks = 'no'
  end

  def dine(table, position)
    @left_chopstick  = table.left_chopstick_at(position)
    @right_chopstick = table.right_chopstick_at(position)

    loop do
      think
      eat
    end
  end

  def think
    @state = 'thinking'
    show_state
  end

  def eat
    @state = 'hungry'
    take_chopsticks
    @state = 'eating'
    show_state
    drop_chopsticks
  end

  def take_chopsticks
    @sticks = 'no'
    @left_chopstick.take
    @sticks = 'left'
    @right_chopstick.take
    @sticks = 'left and right'
  end

  def drop_chopsticks
    @sticks = 'left and right'
    @left_chopstick.drop
    @sticks = 'right'
    @right_chopstick.drop
    @sticks = 'no'
  end

  def show_state
    puts "#{@name} is #{@state} holding #{@sticks} chopstick."
  end
end
