package bar

import models._
import shapeless._

trait Add[A] {
  def add(a1: A): Int
}

object Add {
  def apply[A: Add] = implicitly[Add[A]]
  implicit object f1 extends Add[F1] {
    def add(a1: F1) = a1.i + 1
  }
  implicit object f2 extends Add[F2] {
    def add(a1: F2) = a1.i + 1
  }
  implicit object cnil extends Add[CNil] {
    def add(t: CNil) = throw new RuntimeException("Hell NO!")
  }

  implicit def coproduct[H, C <: Coproduct](implicit tcHead: Add[H], tcTtail: Add[C]): Add[H :+: C] =
    new Add[H :+: C] {
      def add(t: H :+: C) = t match {
        case Inl(head) => tcHead.add(head)
        case Inr(tail) => tcTtail.add(tail)
      }
    }

  implicit def generic[A, G](implicit gen: Generic.Aux[A, G], sg: Lazy[Add[G]]): Add[A] =
    new Add[A] {
      def add(a: A) = sg.value.add(gen.to(a))
    }
}

