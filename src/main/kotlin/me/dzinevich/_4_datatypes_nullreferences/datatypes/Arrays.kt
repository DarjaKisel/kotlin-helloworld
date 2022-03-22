package me.dzinevich._4_datatypes_nullreferences.datatypes

import me.dzinevich.DummyClass

fun main() {
    // Two ways of creating an array
    // - 1- do you know elements already?
    // - 2- do you just have an empty array and then fill it in?

    // - 1
    val names = arrayOf("John", "Jane", "Bob")

    val longs1 = arrayOf(1L, 2L, 3L)
    val longs2 = arrayOf<Long>(1, 2, 3)

    val longs3 = arrayOf(1,2,3) // this is actually an int array
    println(longs2 is Array<Long>)
    //println(longs3 is Array<Long>) // compile error
    println(longs3 is Array<Int>)

    //we can use the usual indexes
    println(longs1[2])

    // use the constructor to initialize
    val evenNumbers = Array(size = 16) {
        i -> i * 2
    }

    for (num in evenNumbers) {
        println(num)
    }

    // init an array with all nums from 1 to 10K
    val tenKNumbers = Array(size = 10000) {
        i -> i+1
    }
    println("-----")
    println(tenKNumbers.size)

    //init with all zeros
    val allZeros = Array(size = 10) { i -> 0}
    // val allZeros = Array(size = 10) {0}
    println("-----")
    for (num in allZeros) {
        println(num)
    }

    // - 2
    // if you're not initializing an array at declaration
    // then please indicate a data type deliberately

    println("-----")
    var someArray: Array<Int>
    someArray = arrayOf(1,2,3,4)
    for (num in someArray) {
        println(num)
    }
    someArray = Array(size = 6) {
        i -> (i+1)*10 // 10,20,30,40,50,60
    }
    for (num in someArray) {
        println(num)
    }

    //Array of Mixed Datatypes
    println("-----")
    val mixedArray = arrayOf("hello", 22, 34.567f, true)
    for (item in mixedArray) {
        println(item)
    }

    // what if a Java method requires an array[] as a param
    val myIntArray = arrayOf(1,2,3,4,5,6,7)
    // DummyClass().printNumbers(myIntArray)  -> error
    // need to use one of special array primitive type classes in Kotlin
    // - IntArray, ByteArray, LongArray...
    // using them also gets you a performance boost
    val myIntArray1 = intArrayOf(1,2,3,4,5,6,7)
    DummyClass().printNumbers(myIntArray1)

    // you can't create an array with size 5 and Not initialize it
    // var otherArray = Array<Int>(size = 5) -> error, need to init
    // but! with primitive types - you can!
    var primitiveArrayNoInit = IntArray(size = 5)
    // reason - they're init automatically with default primitive type values

    // you can also always convert an Array<Int> to IntArray and call a java method with int[] param
    DummyClass().printNumbers(evenNumbers.toIntArray())
    // and vise versa
    val convertedIntArrayToArrayInt: Array<Int> = primitiveArrayNoInit.toTypedArray()
}