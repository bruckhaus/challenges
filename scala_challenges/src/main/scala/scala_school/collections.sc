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

1 -> 2

// Maps:
Map(1 -> 2)
Map("foo" -> "bar")
Map(1 -> Map("foo" -> "bar"))
def TimesTwo(v: Int) = v * 2
Map("timesTwo" -> { TimesTwo(_) })

// Option:
trait Option[T] {
  def isDefined: Boolean
  def get: T
  def getOrElse(t: T): T
}
