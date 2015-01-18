// 1.
object Conversions {
  def inchesToCentimeters(inches: Double): Double = {
    inches * 2.51
  }

  def gallonsToLiters(gallons: Double): Double = {
    gallons * 3.8
  }

  def milesToKilometers(miles: Double): Double = {
    miles * 1.6
  }
}

var centimeters: Double = Conversions.inchesToCentimeters(4.4)
assert(math.abs(11.044 - centimeters) < 0.1)
var liters: Double = Conversions.gallonsToLiters(5.6)
assert(math.abs(21.279 - liters) < 0.01)
var kilometers: Double = Conversions.milesToKilometers(7.8)
assert(math.abs(12.48 - kilometers) < 0.01)

// 2.
class UnitConversions(factor: Double) {
  def convert(value: Double) = value * factor
}

object InchesToCentimeters extends UnitConversions(2.54)

object GallonsToLiters extends UnitConversions(3.78541178)

object MilesToKilometers extends UnitConversions(1.609344)

centimeters = InchesToCentimeters.convert(4.4)
assert(math.abs(11.176 - centimeters) < 0.1)
liters = GallonsToLiters.convert(5.6)
assert(math.abs(21.198 - liters) < 0.01)
kilometers = MilesToKilometers.convert(7.8)
assert(math.abs(12.5528832 - kilometers) < 0.01)

// 3.
object Origin extends java.awt.Point

println(Origin)

// 4.
class Point(var x: Double, var y: Double) {
  override def toString = "x: " + this.x + ", y: " + this.y + "\n"
}

object Point {
  def apply(x: Double, y: Double) = new Point(x, y)
}

print(Point(5.1, 2.3))

// 5.
object reverse_args extends App {
  println(args.reverse.mkString(" "))
}

// 6.
object Suits extends Enumeration {
  val Suits = Value
  val Spades = Value("♠ - spades")
  val Hearts = Value("♥ - hearts")
  val Diamonds = Value("♦ - diamonds")
  val Clubs = Value("♣ - clubs")
}

println(Suits.values)
// 7.
def is_red(suit: Suits.Value): Boolean = {
  suit == Suits.Hearts || suit == Suits.Diamonds
}
for (suit <- Suits.values)
  print(suit + " is red: " + is_red(suit) + "\n")

// 8.
object RGBCube extends Enumeration {
  val black = Value(0x000000, "Black")
  val red = Value(0xff0000, "Red")
  val green = Value(0x00ff00, "Green")
  val blue = Value(0x0000ff, "Blue")
  val yellow = Value(0xffff00, "Yellow")
  val magenta = Value(0xff00ff, "Magenta")
  val cyan = Value(0x00ffff, "Cyan")
  val white = Value(0xffffff, "White")
}

for (c <- RGBCube.values) println("0x%06x: %s".format(c.id, c))
