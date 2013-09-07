package co.com.soat.tarifa

object TarifaSoat{

  type Tarifa = (Int, Int)
  type RangoModelos = (Int,Int)
  type RangoCilindrajes = (Int,Int)

  def tarifarClase2(cilindraje: Int, modelo: Int): Option[Tarifa] = {
	  
	  def modelos1 = (2004,3000)
	  def modelos2 = (0,2004)

	  def cilindrajes1 = (0,1499)
	  def cilindrajes2 = (1500,2499)
	  def cilindrajes3 = (2500,100000)	

	  def tarifas1 = (261133,130567)
	  def tarifas2 = (312000,156000)
	  def tarifas3 = (366067,183033)
	  def tarifas4 = (314200,157100)
	  def tarifas5 = (369800,184900)
	  def tarifas6 = (420267,210133)
	  
	  def c1 = (modelos1,cilindrajes1,tarifas1)
	  def c2 = (modelos1,cilindrajes2,tarifas2)
	  def c3 = (modelos1,cilindrajes3,tarifas3)
	  def c4 = (modelos2,cilindrajes1,tarifas4)
	  def c5 = (modelos2,cilindrajes2,tarifas5)
	  def c6 = (modelos2,cilindrajes3,tarifas6)

	  def tarifas = List(c1,c2,c3,c4,c5,c6)

	  tarifarPorCilindrajeModelo(tarifas, cilindraje, modelo)

  }

  def tarifarClase5(cilindraje: Int, modelo: Int): Option[Tarifa] = {
	  
	  def modelos1 = (2004,3000)
	  def modelos2 = (0,2004)

	  def cilindrajes1 = (0,1499)
	  def cilindrajes2 = (1500,2499)
	  def cilindrajes3 = (2500,100000)	

	  def tarifas1 = (146933,73467)
	  def tarifas2 = (179200,89600)
	  //def tarifas2 = (777,777)
	  def tarifas3 = (209467,104733)
	  def tarifas4 = (195067,97533)
	  def tarifas5 = (223000,111500)
	  def tarifas6 = (248533,124267)
	  
	  def c1 = (modelos1,cilindrajes1,tarifas1)
	  def c2 = (modelos1,cilindrajes2,tarifas2)
	  def c3 = (modelos1,cilindrajes3,tarifas3)
	  def c4 = (modelos2,cilindrajes1,tarifas4)
	  def c5 = (modelos2,cilindrajes2,tarifas5)
	  def c6 = (modelos2,cilindrajes3,tarifas6)

	  def tarifas = List(c1,c2,c3,c4,c5,c6)

	  tarifarPorCilindrajeModelo(tarifas, cilindraje, modelo)

  }  

  def tarifarClase6(cilindraje: Int, modelo: Int): Option[Tarifa] = {
	  
	  def modelos1 = (2002,3000)
	  def modelos2 = (0,2001)

	  def cilindrajes1 = (0,2499)
	  def cilindrajes2 = (2500,100000)

	  def tarifas1 = (262667,131333)
	  def tarifas2 = (351867,175933)
	  def tarifas3 = (335600,167800)
	  def tarifas4 = (211333,634000)

	  
	  def c1 = (modelos1,cilindrajes1,tarifas1)
	  def c2 = (modelos1,cilindrajes2,tarifas2)
	  def c3 = (modelos2,cilindrajes1,tarifas3)
	  def c4 = (modelos2,cilindrajes2,tarifas4)

	  def tarifas = List(c1,c2,c3,c4)

	  tarifarPorCilindrajeModelo(tarifas, cilindraje, modelo)

  }  


  def tarifarClase7(cilindraje: Int, modelo: Int): Option[Tarifa] = {
	  
	  def modelos1 = (2002,3000)
	  def modelos2 = (0,2001)

	  def cilindrajes1 = (0,1499)
	  def cilindrajes2 = (1500,2499)
	  def cilindrajes3 = (2500,100000)	

	  def tarifas1 = (182333,91167)
	  def tarifas2 = (226733,113367)
	  def tarifas3 = (292733,143367)
	  def tarifas4 = (227933,113967)
	  def tarifas5 = (280400,140200)
	  def tarifas6 = (343667,171833)
	  
	  def c1 = (modelos1,cilindrajes1,tarifas1)
	  def c2 = (modelos1,cilindrajes2,tarifas2)
	  def c3 = (modelos1,cilindrajes3,tarifas3)
	  def c4 = (modelos2,cilindrajes1,tarifas4)
	  def c5 = (modelos2,cilindrajes2,tarifas5)
	  def c6 = (modelos2,cilindrajes3,tarifas6)

	  def tarifas = List(c1,c2,c3,c4,c5,c6)

	  tarifarPorCilindrajeModelo(tarifas, cilindraje, modelo)
  }  
  
  def tarifarSinParametros(tarifa: Tarifa): Option[Tarifa] = {
  	None
  } 

  def tarifarPorCilindraje(cilindraje: Int): Option[Tarifa] = {
  	None
  }

  def tarifarPorPasajeros(pasajeros: Int): Option[Tarifa] = {
  	None
  }
  
  def tarifarPorCilindrajeModelo(tarifas: List[(RangoModelos,RangoCilindrajes,Tarifa)], cilindraje: Int, modelo: Int): Option[Tarifa] = {

	  def listamitarifa = tarifas.filter(x => modelo >=x._1._1 && modelo <= x._1._2).filter(x=>cilindraje >= x._2._1 && cilindraje <= x._2._2)
	  
	  def mitarifa = listamitarifa match {
	  	case List() => None 
	  	case _ => Some(listamitarifa.head._3)
	  }

	  mitarifa
  }
  
}