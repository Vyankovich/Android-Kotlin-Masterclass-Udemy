package com.example.helloworld.kotlinBasics

fun main() {

/*    val obj1: Any? = null
    val str1: String = obj1 as String
// Exception in thread "main" kotlin.TypeCastException:
// null cannot be cast to non-null type kotlin.String
    println(str1)*/

/*    val obj2: Any = 123
    val str2: String = obj2 as String
// Exception in thread "main" java.lang.ClassCastException:
// java.lang.Integer cannot be cast to java.lang.String
    println(str2)*/

    // source and target variable needs to be a nullable for casting to work
    val obj3: Any? = "String unsafe cast"
    val str3: String? = obj3 as String?
    println(str3) // works

    // as? provides a safe cast operation to safety cast to a type.
    // it returns a null if casting is not possible rather than throwing
    // ClassCastException exception
    val location: Any = "Kotlin"
    val safeString: String? = location as? String
    val safeInt: Int? = location as? Int
    println(safeString) // Kotlin
    println(safeInt) // null
    // alternatively
    safeString?.let { println(it) }

}