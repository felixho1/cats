package ho.felix

import cats.Show

import cats.instances.int._
import cats.instances.string._
import cats.instances.option._ // for Eq
import cats.syntax.eq._ // === =!=
import cats.syntax.option._ // .some none
import cats.syntax.semigroup._ // for |+|
import cats.instances.map._ // for Monoid

object CatsTest1 {
    def main(args: Array[String]): Unit = {
        val showInt: Show[Int] = Show.apply[Int]
        val showString: Show[String] = Show.apply[String]
        val txt1 = showInt.show(123)
        123 === 123
        (Some(1): Option[Int]) === (None: Option[Int])
        val op1 = 1.some
        val op2 = none[Int]
        op1 === op2

        Option(1) |+| Option(2)
        val map1 = Map("a" -> 1, "b" -> 2)
        val map2 = Map("b" -> 3, "d" -> 4)
        map1 |+| map2
        // res3: Map[String,Int] = Map(b -> 5, d -> 4, a -> 1)
    }
}
