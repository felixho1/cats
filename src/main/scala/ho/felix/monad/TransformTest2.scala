package ho.felix.monad
import cats._
import cats.implicits._
import cats.data._

import scala.util.Try

case class Cat(name: String, alive: Boolean)

object TransformTest2 {
  def isAlive // isAlive: data.Reader[Cat, OptionT[List, Cat]]
  = Reader { (u: Cat) =>
    {
      if (u.alive) OptionT(u.asRight[Throwable].toOption :: Nil)
      else
        OptionT(Try(throw new Exception("Dead!")).asLeft[Cat].toOption :: Nil)
    }
  }
  def lookup = // lookup: OptionT[List, Cat]
    OptionT(
      Cat("miao", true).some :: Cat("guk", false).some :: Cat("meow", true).some :: Nil
    )

  def main(args: Array[String]): Unit = {
    val test1 = for { //  test1: OptionT[List, Cat]
      cat <- lookup //  cat: Cat
      checked <- isAlive(cat) // checked: Cat
    } yield checked
    println(test1) // OptionT(List(Some(Cat(miao,true)), None, Some(Cat(meow,true))))
  }
}
