package scala_for_the_impatient

import scala.reflect.BeanProperty

/**
 * Created by tilmannbruckhaus on 1/11/15.
 */
class Student(@BeanProperty var name: String, @BeanProperty var id: Int) {
}

object Main extends App {
  //  public scala_for_the_impatient.Student(java.lang.String, int);
  val student1 = new Student("John McEnroe", 444)
  val student2 = new Student("Bjorn Borg", 777)

  //  public java.lang.String name();
  printf("Student 1 name: %s\n", student1.name)

  //  public void name_$eq(java.lang.String);
  student1.name = "Erich Honecker"

  //  public void setName(java.lang.String);
  student2.setName("Helmut Schmidt")

  //  public java.lang.String getName();
  printf("Student 2 name: %s\n", student2.getName)

  //  public int id();
  printf("Student 1 id: %d\n", student1.id)

  //  public void id_$eq(int);
  student2.id = 9876

  //  public void setId(int);
  student1.setId(121212)

  //  public int getId();
  printf("Student 2 id: %s\n", student2.getId)
}

/* Output:

[scala_challenges] pwd                                                                                                                                                            1:28:56  ☁  master ☂ ⚡ ✭
/Users/tilmannbruckhaus/dev/bruckhaus/challenges/scala_challenges
[scala_challenges] scala -classpath target/scala-2.10/classes scala_for_the_impatient.Main                                                                                        1:29:06  ☁  master ☂ ⚡ ✭
Student 1 name: John McEnroe
Student 2 name: Helmut Schmidt
Student 1 id: 444
Student 2 id: 9876
[scala_challenges]

 */