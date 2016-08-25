package models

sealed trait Foo { def i: Int }
case class F1(i: Int) extends Foo
case class F2(i: Int) extends Foo

