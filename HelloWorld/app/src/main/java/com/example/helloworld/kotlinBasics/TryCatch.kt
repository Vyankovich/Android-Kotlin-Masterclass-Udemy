package com.example.helloworld.kotlinBasics

import java.lang.Integer.parseInt
import java.lang.NullPointerException

fun main(){

    try {
        val data = 10 / 5
        println("Inside try block")
        println(data)
    } catch (e: NullPointerException) {
        println("Inside catch block")
    } finally {
        println("Finally block always executes")
    }
    println("Below code")

    val name: String? = "Victor"
    val s = name ?: throw IllegalArgumentException("Name required")
    println(s)
    // name?.let { println(it) }


}