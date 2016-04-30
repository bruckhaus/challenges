package scala_school

/**
 * Created by tilmannbruckhaus on 12/26/14.
 *
 */

class Calculator(my_brand: String, my_model: String) {
  /**
   * A constructor.
   */
  val brand = my_brand
  val model = my_model
  val color: String = if (brand == "TI") {
    "blue"
  } else if (brand == "HP") {
    "black"
  } else {
    "white"
  }

  // An instance method.
  def add(m: Int, n: Int): Int = m + n
}

class ScientificCalculator(brand: String, model: String) extends Calculator(brand, model) {
  def log(m: Double, base: Double) = math.log(m) / math.log(base)
}
