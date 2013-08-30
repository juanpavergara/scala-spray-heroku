package co.com.soat.tarifa


import spray.can.server.SprayCanHttpServerApp
import akka.actor.Props


object Boot extends App with SprayCanHttpServerApp {

  // create and start our service actor
  val service = system.actorOf(Props[ServiciosSoat], "serviciossoat")

  val port = args.find(_.contains("spray.port")) match {
    case Some(arg) =>
        try {
            Some(arg.split("=")(1).toInt)
        } catch {
            case e => None
        }
    case _ =>
        None
  }

  // create a new HttpServer using our handler tell it where to bind to
  newHttpServer(service) ! Bind(interface = "localhost", port = port.getOrElse(8888))

}