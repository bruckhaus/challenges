// 1.
var r = scala.util.Random
val n = 15
var a1 = new Array[Int](n)
for (i <- 0 until n) a1(i) = r.nextInt(n + 1)
// 1. alternatives
for (i <- 0 until n) yield r.nextInt(n + 1)
val a2 = Range(0, 15).map(_ => r.nextInt(n + 1)).toArray
val a3 = (0 until 15).map(_ => r.nextInt(n + 1)).toArray
// 2.
var temp: Int = 0
for (i <- 1 until (n, 2)) {
  temp = a3(i)
  a3(i) = a3(i - 1)
  a3(i - 1) = temp
}
a3
// 3.
for (i <- 1 to (n, 2); j <- i until(i - 2, -1) if j < a3.length) yield a3(j)
a3.grouped(2).flatMap(_.reverse).toArray
// 4.
val a4 = (0 until n).map(_ => r.nextInt(2 * n + 1) - n).toArray
a4.filter(_ > 0) ++ a4.filter(_ <= 0)
// 5.
a3.sum
1.0 * a3.sum / a3.length
// 6.
a3.sorted.reverse
a3.toBuffer.sorted.reverse
// 7.
a3.distinct
// 8.
// 9.
java.util.TimeZone.getAvailableIDs.filter(_.startsWith("America")).
  map(_.stripPrefix("America/")).sorted
// 10.
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer
import java.awt.datatransfer._
val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
val result: Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
