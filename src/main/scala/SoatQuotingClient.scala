package co.com.soat.tarifa

import TarifaSoat._

object tarifadorSoatCliente extends App{
  
  def cilindraje = 2010
  def modelo = 1600
  def claseConsultada = 99
 

  def resultado = tarifarClase5(cilindraje,modelo) match {
  	case Some(s) => s
  	case None => " Sorry, there is no tarif for you in this moment :( "
  }

  println("The tarif for you is: " + resultado)

}
