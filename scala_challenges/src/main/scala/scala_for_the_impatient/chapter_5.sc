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
