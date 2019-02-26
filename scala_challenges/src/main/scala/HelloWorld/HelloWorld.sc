object HelloWorld {
  def main(args: Array[String]): Unit = {
    val message: String = "Hello World!"
    println(message)
    message
  }
}

val message: String = HelloWorld.main(null).toString
val expected: String = "Hello World!"
assert(assertion = message == expected)
