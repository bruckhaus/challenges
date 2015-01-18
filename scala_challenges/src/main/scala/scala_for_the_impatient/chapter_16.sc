// 1.
val e = <fred/>(0)
val e2 = <fred/>(0)(0)
e == e2
// copy:
val list = <ul><li>Fred</li><li>Wilma</li></ul>
val list2 = list.copy(label = "ol")
