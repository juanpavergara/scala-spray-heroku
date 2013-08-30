package co.com.soat.tarifa


import spray.can.server.SprayCanHttpServerApp
import akka.actor.Props


object Boot extends App with SprayCanHttpServerApp {

  // create and start our service actor
  val service = system.actorOf(Props[ServiciosSoat], "serviciossoat")

  val host = "0.0.0.0"
  val port = Option(System.getenv("PORT")).getOrElse("8080").toInt

  // create a new HttpServer using our handler tell it where to bind to
  newHttpServer(service) ! Bind(interface = host, port = port

}