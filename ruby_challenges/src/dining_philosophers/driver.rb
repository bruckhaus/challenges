require_relative 'philosopher'
require_relative 'table'


begin
  names        = %w{Heraclitus Aristotle Epictetus Schopenhauer Popper}
  philosophers = names.map { |name| Philosopher.new(name) }
  table        = Table.new(philosophers.size)

  threads = philosophers.map.with_index do |philosopher, i|
    Thread.new { philosopher.dine(table, i) }
  end

  threads.each(&:join)

rescue Exception => e
  puts "\nException: #{e.message}"
  puts e.class
  philosophers.each(&:show_state)
  table.show_chopsticks
end
