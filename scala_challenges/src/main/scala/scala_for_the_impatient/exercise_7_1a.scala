package com {
package horstmann {
object Utils7a {
  def percentOf(value: Double, rate: Double) = value * rate / 100
}
package impatient {
class Employee7a {
  def raise(salary: Double, rate: Double) = salary * Utils7a.percentOf(salary, rate)
}
}
}
}