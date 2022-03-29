package me.dzinevich._7_lambdas_collections_generics

import java.math.BigDecimal

fun main() {

    val list = mutableListOf("Hello")
    list[0].uppercase()
    list.add("Another one")

//    printCollection(list)
    val bigDecimalList = mutableListOf(
        BigDecimal(-0.83),
        BigDecimal(34566.78),
        BigDecimal(0.10))
//    printCollection(bigDecimalList)
    bigDecimalList.printCollection()

}

// <T> - the function uses Generics
// <T> - the type parameter declaration
//fun <T> printCollection(collection: List<T>) {
//    for (item in collection) {
//        println(item)
//    }
//}

// instead of making it a top level function
// lets make it an extension function for List<T>
fun <T> List<T>.printCollection() {
    for (item in this) {
        println(item)
    }
}