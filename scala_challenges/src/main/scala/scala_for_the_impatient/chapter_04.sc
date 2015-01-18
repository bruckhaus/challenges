// 1.
val prices = Map("Beans" -> 1.29, "Corn" -> 1.99, "Beets" -> 2.39, "Pineapple" -> 2.29)
for ((k, v) <- prices) yield (k, v * 0.9)
// 2.

import java.io.File

var hosts: File = new File("/etc/hosts")
val in = new java.util.Scanner(hosts)
var next_word: String = ""
var wordCount = scala.collection.mutable.Map[String, Int]()
while (in.hasNext) {
  next_word = in.next()
  wordCount(next_word) = wordCount.getOrElse(next_word, 0) + 1
}
for ((k, v) <- wordCount) printf("%s: %s\n", k, v)
// 3.
var wordCount2 = Map("" -> 0)
val in2 = new java.util.Scanner(hosts)
while (in2.hasNext) {
  next_word = in2.next()
  wordCount2 = wordCount2 + (next_word -> (wordCount2.getOrElse(next_word, 0) + 1))
}
for ((k, v) <- wordCount2) printf("%s: %s\n", k, v)
// 4.
var wordCount3 = scala.collection.immutable.SortedMap("" -> 0)
val in3 = new java.util.Scanner(hosts)
while (in3.hasNext) {
  next_word = in3.next()
  wordCount3 = wordCount3 + (next_word -> (wordCount3.getOrElse(next_word, 0) + 1))
}
for ((k, v) <- wordCount3) printf("%s: %s\n", k, v)
// 5.
import scala.collection.JavaConversions.mapAsScalaMap
var wordCount4: scala.collection.mutable.Map[String, Int] =
  new java.util.TreeMap[String, Int]
val in4 = new java.util.Scanner(hosts)
while (in4.hasNext) {
  next_word = in4.next()
  val count: Int = wordCount4.getOrElse(next_word, 0) + 1
  wordCount4 = wordCount4 + (next_word -> count)
}
for ((k, v) <- wordCount4) printf("%s: %s\n", k, v)
// 6.
val weekDays = scala.collection.mutable.LinkedHashMap(
  "Monday" -> java.util.Calendar.MONDAY)
weekDays += ("Tuesday" -> java.util.Calendar.TUESDAY)
weekDays += ("Wednesday" -> java.util.Calendar.WEDNESDAY)
weekDays += ("Thursday" -> java.util.Calendar.THURSDAY)
weekDays += ("Friday" -> java.util.Calendar.FRIDAY)
weekDays += ("Saturday" -> java.util.Calendar.SATURDAY)
weekDays += ("Sunday" -> java.util.Calendar.SUNDAY)
for ((k, v) <- weekDays) printf("%s: [%s]\n", k, v)
// 7.
import scala.collection.JavaConverters._
val props = System.getProperties.asScala
val longest = props.keysIterator.reduceLeft((x, y) =>
  if (x.length > y.length) x else y)
val width = longest.length
printf("longest: %s, width: %d\n", longest, width)
props.keySet.toList.sortWith(_ < _).foreach { k =>
  println(k + (" " * (width - k.length)) + " = " + props(k))
}
// 8.
def minMax(values: Array[Int]): (Int, Int) = {
  (values.min, values.max)
}
var myArray: Array[Int] = Array(4, 5, 4, 55, 12, 43, -8, -8, 12, 15, -4)
minMax(myArray)
// 9.
def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) = {
  (values.filter(_ < v).length,
    values.filter(_ == v).length,
    values.filter(_ > v).length)
}
lteqgt(myArray, 12)
// 10.
"Hello".zip("World")
val q1Grades = "ABAABCA"
val q2Grades = "AAABBBB"
val subjectGrades = q1Grades.zip(q2Grades)
subjectGrades.mkString
