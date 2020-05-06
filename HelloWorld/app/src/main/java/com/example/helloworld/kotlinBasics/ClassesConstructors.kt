package com.example.helloworld.kotlinBasics

import java.lang.IllegalArgumentException
import java.util.*

fun main(){

    var p1 = Person("Denis", "Sun")
    var p2 = Person()
    var p3= Person(lastName = "Change")

    var p4 = Person2()
    p4.hobby = "skateboard"
    p4.stateHobby()

    var p6 = Person3()
    var p7 = Person3("Jim", "Bim")
    var p5 = Person3("Ivan", "Ivanov", 33)
    p5.age = 28
    println("Ivan is ${p5.age} years old")

    var p8 = Person4()
    p8.stateHobby()

    var myCar = Carr()
    println("brand is : ${myCar.myBrand}")
    myCar.maxSpeed = 220
    println("Maxspeed is ${myCar.maxSpeed}")
    println("Model is ${myCar.myModel}")

    val iphone = MobilePhone("iOS", "Apple", "iPhone 12")
    iphone.chargeBattery(50)

    println("\\november\\")
}

class Person(var firstName: String = "John", var lastName: String = "Doe") {

    // initializer block
    init {
        println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
    }
}

class Person2(var firstName: String = "John", var lastName: String = "Doe") {
    // member variables - properties
    var age: Int? = null
    var hobby: String = "watch Netflix"

    // initializer block
    init {
        println("Initialized a new Person2 object with firstName = $firstName and lastName = $lastName")
    }
    // member functions - methods
    fun stateHobby(){
        println("My hobby is $hobby")
    }
}

class Person3(var firstName: String = "John", var lastName: String = "Doe") {
    // member variables - properties
    var age: Int? = null
    var hobby: String = "watch Netflix"

    // initializer block
    init {
        println("Initialized a new Person3 object with firstName = $firstName and lastName = $lastName")
    }
    // member secondary constructor
    constructor(firstName: String, lastName: String, age: Int)
        : this(firstName, lastName){
        println("Initialized a new Person3 object with firstName = $firstName and lastName = $lastName" +
                " and age $age")
    }
    // member functions - methods
    fun stateHobby(){
        println("My hobby is $hobby")
    }
}

class Person4(firstName: String = "John", lastName: String = "Doe") {
    // member variables - properties
    var age: Int? = null
    var hobby: String = "watch Netflix"
    var firstName: String? = null

    // initializer block
    init {
        this.firstName = firstName
        println("Initialized a new Person4 object with firstName = $firstName and lastName = $lastName")
    }
    // member secondary constructor
    constructor(firstName: String, lastName: String, age: Int)
            : this(firstName, lastName){
        this.age = age
        println("Initialized a new Person4 object with firstName = $firstName and lastName = $lastName" +
                " and age $age")
    }
    // member functions - methods
    fun stateHobby(){
        println("$firstName\'s hobby is $hobby")
    }
}

class Carr(){
    lateinit var owner: String
    val myBrand: String = "BMW"
    get() {
        return field.toLowerCase(Locale.ROOT)
    }

    var maxSpeed: Int = 250
/*    //  automatically under the hood
    get() = field
    set(value) { field = value}*/
    set(value) {
        field = if (value > 0) value else throw  IllegalArgumentException("Speed can not be less than 0")
    }

    var myModel: String = "M5"
    private set

    init {
        this.myModel = "M4"
        this.owner = "Frank"
    }
}

class MobilePhone(osName: String, brand: String, model: String){
    private var battery: Int = 10
    init {
        println("The phone $model from $brand uses $osName as its Operating System")
    }

    fun chargeBattery(chargedBy: Int){
        println("Battery level was $battery. Now it's ${battery+chargedBy}")
        battery +=chargedBy
        }
}

