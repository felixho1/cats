package ho.felix.monad
import cats.data.Reader
import cats.syntax.applicative._ // for pure

object ReaderTest1 {
  case class Cat(name: String, favoriteFood: String)

  val catName: Reader[Cat, String] =
    Reader(cat => cat.name)

  val greetKitty: Reader[Cat, String] =
    catName.map(name => s"Hello ${name}")

  case class Db(usernames: Map[Int, String], passwords: Map[String, String])

  val dbInst = Db(
    usernames = Map(1 -> "Ari", 2 -> "John"),
    passwords = Map("Ari" -> "AriPwd", "John" -> "JohnPwd"))

  type DbReader[A] = Reader[Db, A]

  def findUsername(userId: Int): DbReader[Option[String]] =
    Reader(db => db.usernames.get(userId))

//  def checkPassword(username: String, password: String): DbReader[Boolean] =
//    Reader(db => db.passwords.get(username).contains(password))
//
//  def checkLogin(userId: Int, password: String): DbReader[Boolean] =
//    for {
//      username <- findUsername(userId)
//      passwordOk <- username
//        .map(username => {
//          val t1 = checkPassword(username, password)
//          t1
//        })
//        .getOrElse(false.pure[DbReader])
//    } yield passwordOk

  def main(args: Array[String]): Unit = {
    //val ex1 = catName.run(Cat("Garfield", "lasagne"))
    val ex1 = catName(Cat("Garfield", "lasagne"))
    println(ex1)
    val ex2 = greetKitty.run(Cat("Heathcliff", "junk food"))
    println(ex2)
    val ex3 = findUsername(1)
    println(ex3(dbInst))
  }
}
