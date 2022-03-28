package me.dzinevich._7_lambdas_collections_generics

fun main() {
    // sets are like maps
    // mutable and immutable
    // LinkedHashSet is created by default by setOf() function


    val ints = mutableSetOf(1, 2, 3)
    ints.plus(-22)
    println(ints)
    println(ints.plus(-22))
    ints + 20
    println(ints)
    println(ints + 20)
    // the set ints doesn't get changed as we didn't assign an updated set to a new variable

    println(ints.minus(2))
    println(ints - 2)

    // try to remove an element that doesn't exist
    println(ints.minus(22)) // --- nothing happened

    println(ints.average()) // the result is a double 2.0
    println(ints.drop(3)) // drop first 3 elements

    val mutableInts = mutableSetOf(11, -21, 346, 0, 1)
    mutableInts.plus(100)
    println(mutableInts)

    //PLUS and MINUS belong to the IMMUTABLE COLLECTION INTERFACE

}