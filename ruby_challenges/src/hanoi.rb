class Hanoi

  def initialize(disks)
    @disks = disks
    @peg1  = []
    @peg2  = []
    @peg3  = []
    set_up(disks)
    puts "Playing Towers of Hanoi for #{@disks} disks:"
    show_pegs
  end

  def solve
    move(@disks, @peg1, @peg2, @peg3)
    puts "\nSolved."
  end

  def move(disks, peg1, peg2, peg3)
    if disks > 0
      move(disks - 1, peg1, peg3, peg2)
      peg3.push(peg1.pop)
      show_pegs
      move(disks - 1, peg2, peg1, peg3)
    end
  end

  def set_up(disks)
    disks.downto(1) do |disk|
      @peg1.push(disk)
    end
  end

  def show_pegs
    puts "\npeg 1: #@peg1"
    puts "peg 2: #{@peg2}"
    puts "peg 3: #{@peg3}"
  end

end

Hanoi.new(3).solve