/**
 * Created by tilmannbruckhaus on 12/26/14.
 *
 */

// List:
val numberList = List(1, 2, 3, 4)

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

1 -> 2

// Maps:
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

val x = 9

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
numberList.map((i: Int) => i * 2)

def timesTwo(i: Int): Int = i * 2
numberList.map(timesTwo _)
