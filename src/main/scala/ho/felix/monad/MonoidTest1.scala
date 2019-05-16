package ho.felix.monad
import scala.language.higherKinds
import cats._
import implicits._
import data._

object MonoidTest1 {

  def eitherFold[A, B](ei: Either[A, B]) = {
    ei.fold({ err =>
      println("error: " + err)
    }, { angka =>
      println("angka: " + angka)
    })
  }

  def main(args: Array[String]): Unit = {
    val s1 = Monoid[String].combine("hi", "There")
    val s2 = "hi" |+| "there"

    println("s1 [%s] s2 [%s]".format(s1, s2))

    val either1 = "Ini Salah".asLeft[Int]
    val either2 = 5.asRight[String]
    either2.fold({ err =>
      println("error: " + err)
    }, { angka =>
      println("angka: " + angka)
    })

    eitherFold(either1)
    eitherFold(either2)
  }
}
