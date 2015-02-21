//1. Write an example program to demonstrate that
//package com.horstmann.impatient
//is not the same as
//package com
//package horstmann
//package impatient

// File: Demo1.scala
package com.horstmann.impatient

class Employee1 {
  def raise(salary: Double, rate: Double) = salary * Utils1.percentOf(salary, rate)
}
