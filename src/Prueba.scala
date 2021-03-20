
class Paciente(nombre:String, primerAp:String, segundoAp:String, edad:Byte,
               var fecha:List[String], var horaRegistro:List[String], var nivelBienestar:List[Byte],
               var temperatura:List[Double], var humedad:List[Double]){

  override def toString: String = "Nombre: " + nombre + "\nPrimer Apellido: " + primerAp + "\nSegundo Apellido: " + segundoAp +
                                  "\nEdad: " + edad + "\nFecha: " + fecha + "\nHora de registro: " + horaRegistro +
                                  "\nNivel de Bienestar: " + nivelBienestar + "\nTemperatura: " + temperatura + "\nHumedad: " + humedad;
  var cont = 0

  def obtenerPromedioNivelBienestar(nivelBE: List[Byte]): Double={
    var prom:Double=0.0
    for(i<-0 to (nivelBE.length-1)){
      prom = prom + nivelBE(i)
    }
    prom/nivelBE.length
  }

  def obtenerTemperaturaMenor(temperatura:List[Double]) : Double = {
    var temMayor: Double = temperatura(0)
    for(e<-0 to (temperatura.length-1)){
      if(temMayor>=temperatura(e)){
        temMayor= temperatura(e)
        cont = e
      }
    }
    //cont+=1
    println("Temperatura MENOR \nNivel de bienestar: " + nivelBienestar(cont) + " Fecha: " + fecha(cont) +  " Hora de registro: " + horaRegistro(cont))
    temMayor
  }


  def obtenerTemperaturaMayor(temperatura:List[Double]): Double ={
    var temMenor: Double = 0.0
    cont = 0
    for(e<-0 to (temperatura.length-1)){
      if(temperatura(e)<=temperatura(e)){
        temMenor = temperatura(e)
        cont = e
      }
    }

    println("Temperatura MAYOR: \nNivel de bienestar: " + nivelBienestar(cont) + " Fecha: " + fecha(cont) +  " Hora de registro: " + horaRegistro(cont))
    temMenor

  }

}

object Prueba {
  def main(args: Array[String]): Unit = {
    val fecha: List[String] = List("12/03/2021","13/03/2021","14/03/2021", "15/03/2021","16/03/2021")
    val horaRegistro : List[String] = List("08:00","14:20","08:00","09:00","15:20")
    val nivelDeBienestar : List[Byte] = List(2,1,2,3,4)
    val temperatura : List[Double] = List(25.3, 26.4, 29.3, 23.4,28)
    val humedad : List[Double] = List(12, 34.5, 40.2, 30.6, 29.8)

    var paciente1 = new Paciente("Adan", "Ruiz", "Villalobos", 22,
                                fecha, horaRegistro, nivelDeBienestar, temperatura, humedad)
    //println(paciente1)

    println("Promedio de nivel de bienestar: " + paciente1.obtenerPromedioNivelBienestar(nivelDeBienestar))
    println("Temperatura Mayor: " + paciente1.obtenerTemperaturaMayor(temperatura))
    println("Temperatura Menor: "+ paciente1.obtenerTemperaturaMenor(temperatura))

  }
}
