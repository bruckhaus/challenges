import hello_world.HelloWorld

object HelloWorld {
  def main(args: Array[String]): String = {
    val message: String = "Hello World!"
    println(message)
    message
  }
}

val message = HelloWorld.main(null)
val expected: String = "Hello World!"

assert(message == expected)
