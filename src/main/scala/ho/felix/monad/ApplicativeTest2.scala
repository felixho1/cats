package ho.felix.monad
import cats._
import cats.implicits._
import cats.data._

sealed abstract class ConfigError
final case class MissingConfig(field: String) extends ConfigError
final case class ParseError(field: String) extends ConfigError

case class Config(map: Map[String, String])

case class HuffConfig(clusterName: String,
                      clusterPort: Int,
                      clusterAddress: String,
                      hostname: String,
                      listeningPort: Int)

object ApplicativeTest2 {
  def main(args: Array[String]): Unit = {
//    val x = Apply[List[String]].map2
  }

//  def getHuffConfig(config: Config): ValidatedNel[ConfigError, HuffConfig] =
//    Apply[ValidatedNel[ConfigError, ?]]
//      .map5(
//        config.parse[String]("DL_CLUSTER_NAME").toValidatedNel,
//        config.parse[Int]("DL_CLUSTER_PORT").toValidatedNel,
//        config.parse[String]("DL_CLUSTER_ADDRESS").toValidatedNel,
//        config.parse[String]("DL_HTTP_ADDRESS").toValidatedNel,
//        config.parse[Int]("DL_HTTP_PORT").toValidatedNel
//      ) {
//        case (
//            clusterName,
//            clusterPort,
//            clusterAddress,
//            hostname,
//            listeningPort
//            ) =>
//          HuffConfig(
//            clusterName,
//            clusterPort,
//            clusterAddress,
//            hostname,
//            listeningPort
//          )
//      }
}
