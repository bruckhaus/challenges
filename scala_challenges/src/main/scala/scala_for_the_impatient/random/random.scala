package scala_for_the_impatient.random

class random {

  var seed = 12345.6789
  var previous = seed
  var next = seed
  val a = 1664525
  val b = 1013904223
  val n = 32
  val power_of_2 = math.pow(2, n)

  def nextInt(): Int = nextDouble().toInt
  
  def nextDouble(): Double = {
    next = (previous * a + b) % power_of_2
    previous = next
    next
  }

  def setSeed(seed: Int): Unit = {
    this.seed = seed
    previous = this.seed
  }
}

object Main extends App {
  var r = new random
  print("r1: " + r.nextDouble() + "\n")
  print("r2: " + r.nextDouble() + "\n")
  r.setSeed(5566.7788.toInt)
  print("r1: " + r.nextDouble() + "\n")
  print("r2: " + r.nextDouble() + "\n")
}
