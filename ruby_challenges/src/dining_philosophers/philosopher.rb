class Philosopher
  def initialize(name)
    @name = name
    @state = 'sitting'
    @holds = 'no'
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
    @holds = 'no'
    @left_chopstick.take
    @holds = 'left'
    @right_chopstick.take
    @holds = 'left and right'
  end

  def drop_chopsticks
    @holds = 'left and right'
    @left_chopstick.drop
    @holds = 'right'
    @right_chopstick.drop
    @holds = 'no'
  end

  def show_state
    puts "#{@name} is #{@state} holding #{@holds} chopstick."
  end
end
