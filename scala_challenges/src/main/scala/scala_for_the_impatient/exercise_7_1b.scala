package com.horstmann.impatient

object Utils7b {
  def percentOf(value: Double, rate: Double) = value * rate / 100
}
class Employee7b {
  def raise(salary: Double, rate: Double) = salary * Utils7b.percentOf(salary, rate)
}