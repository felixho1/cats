package ho.felix.monad
import cats._
import cats.implicits._
import cats.data._

object ApplicativeTest1 {
  def main(args: Array[String]): Unit = {
    val lifted_01 = Applicative[List].lift((x: Int) => x + 1) // lifted_01: List[Int] => List[Int] = cats.Functor$$Lambda$1133/928103158@6b6fde93
    val lifted_02_01 = (x: List[Int => Int]) => x.map(f => f(2)) //  scala.List[Int => Int] => List[Int]
    val lifted_02_02 =
      Applicative[List].lift((x: List[Int => Int]) => x.map(f => f(2))) // List[List[Int => Int]] => List[List[Int]]
    val lifted_02 = // lifted_02: List[List[Int]] = List(List(3))
      Applicative[List].lift((x: List[Int => Int]) => x.map(f => f(2)))(
        List(List((x: Int) => x + 1))
      )
    val fs = List(List((x: Int) => x + 1)) // List[List[Int => Int]]
    val fs_01 = fs.map(f => {
      val xxx1 = f(0) // which is the function (x: Int) => x + 1
      xxx1
    })
    val fs_02 = fs.map(f => f(0)) // Pattern: fs_02: List[Int => Int]
    println(fs_02)
    val fs_03 = fs.map(f => f(0)(3)) // Pattern: fs_03: List[Int]
    println(fs_03)
  }
}
