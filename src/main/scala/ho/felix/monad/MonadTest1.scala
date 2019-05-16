package ho.felix.monad
import scala.language.higherKinds
import cats._
import implicits._
import data._

object MonadTest1 {

  def first =
    Reader((x: Int) => Monad[List].ifM(List(true, true))(x :: Nil, Nil))
  def second =
    Reader((x: Int) => Monad[List].ifM(List(true, true))(x :: Nil, Nil))

  def main(args: Array[String]): Unit = {
    val li1 = List(1, 2, 3)
    val li2 = li1 >>= (value => List(value + 3)) // flatMap. The container type must be same
    println(li2) // List(4, 5, 6)

    val mon1 = Monad[List].lift((x: Int) => x + 1) // List[Int] => List[Int]
    println(mon1(List(5, 6, 7))) // List(6, 7, 8)

    val mon2 = Monad[List].pure(4) // List[Int] = List(4)

    println(first(5))
    println(second(5))
  }
}
