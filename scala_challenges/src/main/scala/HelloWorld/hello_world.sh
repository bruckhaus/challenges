#! /bin/sh
exec scala "$0" "$@"
!#
object HelloWorld {
  def main(args: Array[String]) {
    var suffix = args.mkString(" ")
    if (suffix != "") {suffix = ", " + suffix}
    println("Hello World" + suffix + "!")
  }
}
HelloWorld.main(args)
