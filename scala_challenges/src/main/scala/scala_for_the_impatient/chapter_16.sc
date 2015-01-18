// copy:
val list = <ul><li>Fred</li><li>Wilma</li></ul>
val list2 = list.copy(label = "ol")
// 1.
val e = <fred/>(0)
val e2 = <fred/>(0)(0)
e == e2
// 2.
val e3 = <ul>
  <li>Opening bracket: [</li>
  <li>Closing bracket: ]</li>
  <li>Opening brace: {{</li>
  <li>Closing brace: }}</li>
</ul>
e3.getClass
// 3.

import java.net.URL
import com.sun.org.apache.xml.internal.resolver.tools.CatalogResolver

import scala.reflect.io.File
import scala.xml.{Elem, XML, Atom, Text}
val e4 = <li>Fred</li> match { case <li>{Text(t)}</li> => t }
val e5 = <li>{"Fred"}</li> match { case <li>{t: Atom[String] @unchecked }</li> => t}
val e6 = <li>{Text("Fred")}</li> match { case <li>{Text(t) }</li> => t}
// 4.
//val root = XML.load(new URL("http://horstmann.com/index.html"))
//val res = new CatalogResolver
//val doc = new factory.XMLLoader[Elem] {
//  override def adapter = new parsing.NoBindingFactoryAdapter(){
//    override def resolveEntity(publicId: String, systemId: String) = {
//      res.resolveEntity(publicId, systemId)
//    }
//  }
//}
//val path = "/Users/tilmannbruckhaus/dev/bruckhaus/challenges/scala_challenges/src/main/resources/"
//val root = XML.loadFile(path + "Cay Horstmann's Home Page.html")
//root \\ "img"
