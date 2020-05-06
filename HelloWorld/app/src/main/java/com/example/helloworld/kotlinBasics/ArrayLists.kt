package com.example.helloworld.kotlinBasics

fun main() {
    val arrayList = ArrayList<Double>()
    arrayList.add(1.0)
    arrayList.add(2.0)
    arrayList.add(3.0)
    arrayList.add(4.0)
    arrayList.add(5.0)

    var totalSum = 0.0
    for (i in arrayList) {
        totalSum += i
    }

    val average = totalSum / arrayList.size
    print(average)
}