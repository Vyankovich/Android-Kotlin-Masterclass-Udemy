package com.example.helloworld.kotlinBasics

open class Base(){
    val a = 1 // public by default
    private var b = 2 // private to Base class
    protected open val c = 3 // visible to the Base and Derived classes
    internal val d = 4 // visible inside the same module
    protected fun e(){} // visible to Base and Derived classes
}

class Derived: Base(){
    // a,c,d and e() of class Base are visible
    // b is not visible
    override val c = 8 // c is protected
}

fun main() {
    val base = Base()
    // base.a and base.d are visible
    // base.b, base.c, base.e() are not visible
    val derived = Derived()
    // derived.c is not visible
}