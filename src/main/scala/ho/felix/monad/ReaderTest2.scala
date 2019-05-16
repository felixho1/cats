package ho.felix.monad
import cats._
import implicits._
import cats.data._

object ReaderTest2 {
  case class Config(setting: String, value: String)
  def getSetting = Reader { (config: Config) =>
    config.setting
  }
  def getValue = Reader {
    { config: Config =>
      config.value
    }
  }

  def main(args: Array[String]): Unit = {
    val cf1 = // Reader[Config,Config] // Pattern: cf1: Kleisli[cats.Id, ReaderTest2.Config, ReaderTest2.Config]
      for {
        s <- getSetting // both of them same type of input
        v <- getValue
      } yield Config(s, v)
  }
}
