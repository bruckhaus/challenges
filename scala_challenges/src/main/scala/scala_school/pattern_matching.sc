/**
 * Created by tilmannbruckhaus on 12/26/14.
 */

object TestWorksheet {

  val times = 1
  times match {
    case 1 => "one"
    case 2 => "two"
    case _ => "some other number"
  }

  times match {
    case i if i == 1 => "one"
    case i if i == 2 => "two"
    case _ => "some other number"
  }

  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0 => i - 1
      case i: Int => i + 1
      case d: Double if d < 0.0 => d - 0.1
      case d: Double => d + 0.1
      case text: String => text + "s"
    }
  }

  def calcType(calc: Calculator) = calc match {
    case _ if calc.brand == "hp" && calc.model == "20B" => "financial"
    case _ if calc.brand == "hp" && calc.model == "48G" => "scientific"
    case _ if calc.brand == "hp" && calc.model == "30B" => "business"
    case _ => "unknown"
  }

  val hp20b = Calculator("hp", "20B")
  val hp30b = Calculator("hp", "30B")
  case class Calculator(brand: String, model: String)
  val hp20b_2 = Calculator("hp", "20b")
  //> hp20b2  : testpackage.TestWorksheet.Calculator = Calculator(hp,20b)
  val hp30b_2 = Calculator("hp", "30b") //> hp30b  : testpackage.TestWorksheet.Calculator = Calculator(hp,30b)
  hp20b == hp20b_2 //> res0: Boolean = true
  hp20b == hp30b
  //> res1: Boolean = false
  def calcType2(calc: Calculator): String = calc match {
    case Calculator("hp", "20b") => "financial"
    case Calculator("hp", "30b") => "business"
    case Calculator("hp", "48g") => "scientific"
    case Calculator(_, _) => "unknown"
  } //> calcType: (calc: testpackage.TestWorksheet.Calculator)String
  calcType(hp20b) //> res2: String = financial
  calcType(hp30b) //> res3: String = business
}
