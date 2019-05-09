package ho.felix.monad

import cats.Monad
import cats.instances.list._ // for Monad
import cats.syntax.applicative._ // for pure
import cats.data.OptionT

object TransformTest1 {
  type ListOption[A] = OptionT[List, A]
  def main(args: Array[String]): Unit = {
    val result1: ListOption[Int] = OptionT(List(Option(10)))
    // result1: ListOption[Int] = OptionT(List(Some(10)))
    val result2: ListOption[Int] = 32.pure[ListOption]
    // result2: ListOption[Int] = OptionT(List(Some(32)))

  }
}
