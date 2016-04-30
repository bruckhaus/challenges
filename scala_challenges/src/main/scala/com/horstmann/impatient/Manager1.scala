
// File: Demo2.scala
package com.horstmann.impatient

class Manager1 {
  def raise(salary: Double, rate: Double) =
    salary * Utils1.percentOf(salary, rate)	// Can't refer to Utils directly
}
 