package com.example.helloworld.kotlinBasics

import kotlin.math.floor

fun main() {
    val stringList: List<String> = listOf(
        "Denis","Frank","Michael","Garry")
    val mixedTypeList: List<Any> = listOf(
        "Denis",31,5,"BDay",40.2,"age","kg")

    for (value in mixedTypeList) {
        if (value is Int) {
            println("Integer: '$value'")
        } else if (value is Double) {
            println("Double: '$value' with Floor value ${floor(value)}")
        } else if (value is String) {
            println("String: '$value' of length ${value.length}")
        } else {
            println("Unknown type")
        }
    }
    // alternatively
    for (value in mixedTypeList) {
        when (value) {
            is Int -> println("Integer: '$value'")
            is Double -> println("Double: '$value' with Floor value ${floor(value)}")
            is String -> println("String: '$value' of length ${value.length}")
            else -> println("Unknown type")
        }
    }
    // smart cast
    val obj1: Any = "Text"
    if (obj1 !is String) {
        println("Not a string")
    } else {
        //obj is automatically cast to a String in this scope
        println("Found a String of length ${obj1.length}")
    }

    // explicit (unsafe) casting using "as" keyword - can go wrong
    val str1: String = obj1 as String
    println(str1.length)

    //val obj2: Any = 1334
    //val str2: String = obj2 as String
    //println(str2)

    // explicit (safe) casting using "as?" keyword
    val obj3: Any = 1334
    val str3: String? = obj3 as? String // works
    println(str3) // prints null

}