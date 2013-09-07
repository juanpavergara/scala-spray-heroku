package co.com.soat.tarifa


import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http


object Boot extends App {

  implicit val system = ActorSystem()
  val handler = system.actorOf(Props[ServiciosSoat], "serviciossoat")

  val host = "0.0.0.0"
  val port = Option(System.getenv("PORT")).getOrElse("8080").toInt

  IO(Http) ! Http.Bind(handler, interface = host, port = port)

}