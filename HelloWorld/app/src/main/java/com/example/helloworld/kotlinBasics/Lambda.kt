package com.example.helloworld.kotlinBasics

fun main() {

    val sum: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    println(sum(10, 5))

    // even shorter
    val sum2 = { a: Int, b: Int -> println(a + b) }
    sum2(10, 5)

}