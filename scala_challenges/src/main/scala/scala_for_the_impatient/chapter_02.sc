// 1.
def signum(i: Int): Int = if (i < 0) -i else i
signum(-7)
signum(11)
signum(0)
signum(-2)
// 2.
val v = {}
// 3.
var x = ()
var y = 0
x = y = 1
// 4.
// for (int i = 10; i >= 0; i--) System.out.println(i);
for (i <- 10 to 0 by -1) println(i)
// 5.
def countdown(n: Int) {
  for (i <- n to 0 by -1) println(i)
}
countdown(10)
// 6.
var helloSum: Long = 1
for (c <- "Hello") helloSum *= c.toInt
helloSum
// 7.
"Hello".foldLeft(1L)(_ * _.toInt)
// 8.
def product(s: String) = s.foldLeft(1L)(_ * _.toInt)
product("Hello")
// 9.
def recursive_product(s: String): Long = {
  if (s == "") 1L else s(0).toInt * recursive_product(s.drop(1))
}
recursive_product("Hello")
// 10.
def power(base: Int, exponent: Int): Double = {
  if (exponent == 0) 1
  else {
    if (exponent < 0) 1 / power(base, -exponent)
    else {
      if (exponent % 2 == 0) {
        val temp = power(base, exponent / 2)
        temp * temp
      }
      else base * power(base, exponent - 1)
    }
  }
}
assert(math.pow(2, 2) == power(2, 2))
assert(math.pow(3, 4) == power(3, 4))
assert(math.pow(4, 5) == power(4, 5))
assert(math.pow(5, 6) == power(5, 6))
assert(math.pow(5, -6) == power(5, -6))
assert(math.pow(4, -2) == power(4, -2))
assert(math.pow(2, -2) == power(2, -2))
