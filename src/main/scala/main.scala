package foo
import bar._
import models._

object main extends App {

  val foos: List[Foo] = List(F1(1))
  println(foos.map(Add[Foo].add))

}
