// 1.
class Counter {
  private var value = 0

  def increment() {
    if (value + 1 > 0) value += 1
  }

  def current() = value
}

// 2.
class BankAccount {
  private var _balance: Double = 0.0

  def balance = _balance

  def deposit(amount: Double): Unit = {
    _balance += amount
  }

  def withdraw(amount: Double): Unit = {
    _balance -= amount
  }
}

val b = new BankAccount
println(b.balance)
b.deposit(1.25)
println(b.balance)
b.withdraw(0.75)
println(b.balance)
// 3.
class Time(val hours: Int, val minutes: Int) {
  def before(other: Time): Boolean = {
    hours < other.hours ||
      (hours == other.hours && minutes < other.minutes)
  }

  def check(other: Time): Unit = {
    printf("t1: %s, t2: %s, before: %s\n", this, other, this.before(other))
  }

  override def toString = "" + hours + ":" + minutes
}

val t1 = new Time(1, 23)
val t2 = new Time(1, 55)
val t3 = new Time(1, 55)
val t4 = new Time(1, 56)
val t5 = new Time(2, 4)
for (pair <- List(t1, t2, t3, t4, t5).combinations(2)) {
  pair(0).check(pair(1))
  pair(1).check(pair(0))
}
// 4.
class Time2(val hours: Int, val minutes: Int) {
  val minutesSinceMidnight: Int = hours * 60 + minutes
  def before(other: Time2): Boolean = minutesSinceMidnight < other.minutesSinceMidnight
  def check(other: Time2): Unit = {
    printf("t1: %s, t2: %s, before: %s\n", this, other, this.before(other))
  }
  override def toString = "" + hours + ":" + minutes
}
val t1b = new Time2(1, 23)
val t2b = new Time2(1, 55)
val t3b = new Time2(1, 55)
val t4b = new Time2(1, 56)
val t5b = new Time2(2, 4)
for (pair <- List(t1, t2, t3, t4, t5).combinations(2)) {
  pair(0).check(pair(1))
  pair(1).check(pair(0))
}
// 5.
import scala.reflect.BeanProperty
class Student {
  @BeanProperty var name: String = _
}
// 6.
class Person(var age: Int) {
  if (age < 0) this.age = 0
}
// 7.
class Person2(name: String) {
  def firstName: String = name.split(" ")(0)
  def lastName: String = name.split(" ")(1)
}
new Person2("Tilmann Bruckhaus").firstName
new Person2("Tilmann Bruckhaus").lastName
// 8.
class Car(val manufacturer: String,
          val model: String,
          val modelYear: Int = 0,
          var license: String = "") {
  override def toString = "" +
    "manufacturer: " + this.manufacturer +
    ", model: " + this.model +
    ", model year: " + this.modelYear +
    ", license: " + this.license
}
val car1 = new Car("Mercedes", "C250")
val car2 = new Car("Mercedes", "C250", 2014)
val car3 = new Car("Mercedes", "C250", license = "7 CFG 777")
val car4 = new Car("Mercedes", "C250", 2014, "7 CFG 777")
printf("car 1: %s\n", car1)
printf("car 2: %s\n", car2)
printf("car 3: %s\n", car3)
printf("car 4: %s\n", car4)
// 9.
"it's much shorter"
// 10.
class Employee(val name: String = "John Q. Public", var salary: Double = 0.0) {}
