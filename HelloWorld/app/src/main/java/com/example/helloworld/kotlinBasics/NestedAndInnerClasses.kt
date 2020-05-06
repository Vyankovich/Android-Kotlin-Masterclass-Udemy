package com.example.helloworld.kotlinBasics

// nested class example
class OuterClass{
    private var name: String = "private String"
    class NestedClass{
        var description: String = "code inside nested class"
        private var id: Int =100
        fun foo(){
            // print("name is ${name}") // cannot access the outer class members
            println("Id is $id")
        }
    }
}

// inner class example
class OuterClass2{
    private var name: String = "string"
    inner class InnerClass{
        var descr: String = "code inside inner class"
        private var id: Int = 101
        fun foo() {
            println("name is $name") // access the private outer class member
            println("Id is $id")
        }
    }
}

fun main() {
    // nested class must be initialized
    println(OuterClass.NestedClass().description) // accessing property

    val obj = OuterClass.NestedClass() // object creation
    obj.foo() // access member function

    // ----------------------

    println(OuterClass2().InnerClass().descr) // accessing property
    var obj2 = OuterClass2().InnerClass() // object creation
    obj2.foo() // access member function
}