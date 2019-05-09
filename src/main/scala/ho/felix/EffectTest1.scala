package ho.felix
import cats.effect.IO
import scala.concurrent.{Future, ExecutionContext}
import scala.util.{Success, Failure}
import java.util.concurrent.ScheduledExecutorService
import scala.concurrent.duration._

object EffectTest1 {
  def convert[A](fa: => Future[A])(implicit ec: ExecutionContext): IO[A] =
    IO.async { cb =>
      // This triggers evaluation of the by-name param and of onComplete,
      // so it's OK to have side effects in this callback
      fa.onComplete {
        case Success(a) => cb(Right(a))
        case Failure(e) => cb(Left(e))
      }
    }

  def delayedTick(d: FiniteDuration)
                 (implicit sc: ScheduledExecutorService): IO[Unit] = {

    IO.cancelable { cb =>
      val r = new Runnable { def run() = cb(Right(())) }
      val f = sc.schedule(r, d.length, d.unit)

      // Returning the cancellation token needed to cancel
      // the scheduling and release resources early
      IO(f.cancel(false))
    }
  }

  def main(args: Array[String]): Unit = {

    val ioa = IO { println("hey!") }

    val program: IO[Unit] =
      for {
        _ <- ioa
        _ <- ioa
      } yield ()

    program.unsafeRunSync()
  }
}
