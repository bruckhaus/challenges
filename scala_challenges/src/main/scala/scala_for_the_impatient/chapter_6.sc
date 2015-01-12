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
