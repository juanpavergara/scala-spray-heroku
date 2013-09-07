package co.com.soat.tarifa


import akka.actor.Actor
import spray.routing._
import spray.http._
import spray.http.Uri
import MediaTypes._

import co.com.soat.tarifa.TarifaSoat._

import net.hamnaberg.json.collection._
import net.hamnaberg.json.collection.Value._
//import net.hamnaberg.json._
import java.net.URI


import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.native.JsonMethods._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class ServiciosSoat extends Actor with DemoService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing,
  // timeout handling or alternative handler registration
  def receive = runRoute(demoRoute)
}


// this trait defines our service behavior independently from the service actor
trait DemoService extends HttpService {

  // we use the enclosing ActorContext's or ActorSystem's dispatcher for our Futures and Scheduler
  //implicit def executionContext = actorRefFactory.dispatcher

  val mydomain = "www.soatapi.co"

  val demoRoute = {

  	val urid = extract(_.request.uri)

  	urid { urip =>
  		get {
  			path("tarifasoat" / "AutosFamiliares"){ 
      	  		
      	  		parameters('modelo.as[Int], 'cilindraje.as[Int]){ (modelo, cilindraje) =>
		    		
		    		println("uri: " + urip)

		    		val uris = urip.toString

      	  			var prima = 0
      	  			var contribucion = 0

		    		tarifarClase5(cilindraje,modelo) match {
		    			case Some(s) => {
		    				prima = s._1
		    				contribucion = s._2
		    			}
		    			case None => " Sorry, there is no tarif for you in this moment :( "
		    		}

		    		val item = Item(
		    			URI.create(uris),
		      			List(
		      				ValueProperty("tipo-vehiculo", None, Some(StringValue("Autos Familiares"))),
		        			ValueProperty("modelo", None, Some(NumberValue(modelo))),
		        			ValueProperty("cilindraje", None, Some(NumberValue(cilindraje))),
		        			ValueProperty("prima", None, Some(NumberValue(prima))),
		        			ValueProperty("contribucion", None, Some(NumberValue(contribucion)))
		      			),
		      			List(
		      				Link(URI.create("http://examples.org/blogs/jdoe"), "blog", Some("Blog")),
		        			Link(URI.create("http://examples.org/images/jdoe"), "avatar", Some("Avatar"), Some(Render.IMAGE))
		      			)
		    		)
		    
		    		// Armar una lista de enlaces para la collection
		    		// Esto es un ejemplo pues no se necesita en este caso y no se usara en el collection
		    		val links = List(
		    			Link(URI.create("http://example.org/friends/?queries"), "queries"),
		      			Link(URI.create("http://example.org/friends/?template"), "template")
		    		)
			
		    		val collection = JsonCollection(Version.ONE, URI.create(uris), List(), List(item), Nil, None, None)
		    		val collectionJson = collection.toJson
		    
      	    		println("==================== pretty(render(collectionJson)) ==========================")
					val prettyjson = pretty(render(collectionJson))

					println(prettyjson)
      	    		complete(prettyjson)
      	  		} 
      		
        } 
	}
	}
  }

}