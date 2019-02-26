#!/bin/sh
exec scala "$0" "$@"
!#
object HelloWorld {
  def main(args: Array[String]): Unit =
    println("Hello World!")
}
HelloWorld.main(args)
