package com.example.helloworld.kotlinBasics

interface Drivable{
    val maxSpeed: Double
    fun drive(): String
    fun brake(){
        println("The drivable is braking ")
    }
}

open class Kar(override val maxSpeed: Double, val name: String, val brand: String)
    : Drivable{

    open var range: Double = 0.0

    fun extendRange(amount: Double) {
        if (amount > 0) {
            range += amount
        }

    }
//    override fun drive(): String = "Driving the interface drive"
    override fun drive(): String {
        return "Driving the interface drive"
    }

    open fun drive(distance: Double){
        println("Drove for $distance KM")
    }
/*    // overridden functions are implicitly open:
    override fun brake() {
        println("The car is breaking")
    }*/
}

class ElCar(maxSpeed: Double, name: String, brand: String, batteryLife: Double)
    : Kar(maxSpeed, name, brand) {

    var chargerType = "Type1"
    override var range = batteryLife * 6

    override fun drive(distance: Double){
        println("Drove for $distance KM on electricity")
    }

    override fun drive(): String{
        return "Drove for $range KM on electricity"
    }

    override fun brake() {
        super.brake()
        println("Brake inside ElCar class")
    }
}

fun main(){
    var audiA3 = Kar(200.0,"A3", "Audi")
    var teslaS = ElCar(240.0,"S-Model", "Tesla", 85.0)

    teslaS.brake()
    audiA3.brake()
}







