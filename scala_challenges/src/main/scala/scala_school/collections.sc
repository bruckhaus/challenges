/**
 * Created by tilmannbruckhaus on 12/26/14.
 *
 */

// List:
val numbers = List(1, 2, 3, 4)

// Set:
Set(1, 1, 2)

// Tuple:
var hostPort = ("localhost", 80)
hostPort._1
hostPort._2
hostPort match {
  case ("localhost", port) => println("localhost port is: " + port)
  case (host, port) => println("any other host")
}
hostPort = ("twitter.com", 80)
hostPort match {
  case ("localhost", port) => println("localhost port is: " + port)
  case (host, port) => println("any other host")
}

// Map:
1 -> 2
Map(1 -> 2)
Map("foo" -> "bar")
Map(1 -> Map("foo" -> "bar"))
def TimesTwo(v: Int) = v * 2
Map("timesTwo" -> {
  TimesTwo(_)
})

// Option:
trait Option[T] {
  def isDefined: Boolean

  def get: T

  def getOrElse(t: T): T
}

val numberMap = Map(1 -> "one", 2 -> "two")
val r1 = numberMap.get(2)
val r2 = numberMap.get(3)
// We want to multiply the number by two, otherwise return 0.
val result = if (r2.isDefined) {
  r2.get * 2
} else {
  0
}
val result2 = r2.getOrElse(0) // * 2
val result3 = r1 match {
    case Some(n) => n * 2
    case None => 0
  }

// map:
numbers.map((i: Int) => i * 2)
def timesTwo(i: Int): Int = i * 2
numbers.map(timesTwo _)
// foreach:
numbers.foreach((i: Int) => i * 2)
val doubled = numbers.foreach((i: Int) => i * 2)
// filter:
numbers.filter((i: Int) => i % 2 == 0)
def isEven(i: Int): Boolean = i % 2 == 0
numbers.filter(isEven _)
numbers.filter(isEven)
// zip:
List(1, 2, 3).zip(List('a', 'b', 'c'))
// partition:
val numbers2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
numbers2.partition(_ % 2 == 0)
// find:
numbers2.find((i: Int) => i > 5)
// drop:
numbers2.drop(5)
numbers2.dropWhile(_ % 2 != 0)
numbers2.dropWhile(_ <= 4)
// foldLeft:
numbers2.foldLeft(0)((m: Int, n: Int) => m + n)
numbers2.foldLeft(0) { (m: Int, n: Int) => println("m:" + m + ", n:" + n); m + n}
numbers2.foldRight(0) { (m: Int, n: Int) => println("m:" + m + ", n:" + n); m + n}
// flatten:
List(List(1, 2), List(3, 4)).flatten
// flatMap:
val nestedNumbers = List(List(1, 2), List(3, 4))
nestedNumbers.flatMap(x => x.map(_ * 2))
nestedNumbers.map((x: List[Int]) => x.map(_ * 2)).flatten
// Generalized functional combinators:
def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
  numbers.foldRight(List[Int]()) { (x: Int, xs: List[Int]) =>
  fn(x) :: xs
  }
}
ourMap(numbers, timesTwo(_))
// Map?
val extensions = Map("Steve" -> 100, "Bob" -> 101, "Joe" -> 201)
extensions.filter((namePhone: (String, Int)) => namePhone._2 < 200)
extensions.filter({case (name, extension) => extension < 200})