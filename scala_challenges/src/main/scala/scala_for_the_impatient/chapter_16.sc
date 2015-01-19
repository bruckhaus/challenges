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
import scala.xml.{XML, Atom, Text}
val e4 = <li>Fred</li> match { case <li>{Text(t)}</li> => t }
val e5 = <li>{"Fred"}</li> match { case <li>{t: Atom[String] @unchecked }</li> => t}
val e6 = <li>{Text("Fred")}</li> match { case <li>{Text(t) }</li> => t}
// 4.
val parser = (new org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl).newSAXParser
val url = "http://1bitentropy.wordpress.com/"
val root = XML.withSAXParser(parser).load(new java.net.URL(url))
val noAlt = root \\ "img" filter (h=>(h \ "@alt" toString) == "")
println(noAlt.mkString("\n"))
// 5.
val src = root \\ "@src"
println(src.mkString("\n"))
// 6.
val a = root \\ "a"
val a2 = root \\ "a" \\ "@href"
val a3 = root \\ "a" \\ "@title"
