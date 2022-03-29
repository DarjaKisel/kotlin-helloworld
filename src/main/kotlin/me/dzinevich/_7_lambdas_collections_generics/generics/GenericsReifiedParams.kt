package me.dzinevich._7_lambdas_collections_generics.generics

import me.dzinevich._7_lambdas_collections_generics.collections.Car
import me.dzinevich._7_lambdas_collections_generics.lambdas.Employee
import java.math.BigDecimal

/**
 *  -- INLINE FUNCTIONS CAN BE REIFIED (materialized)
 *  -- REIFICATION ---> materialization
 *  -- IS A KOTLIN FEATURE THAT PREVENTS A TYPE <T> BEING ERASED AT RUNTIME
 *
 * If you declare a function as INLINE
 * and a type parameter is REIFIED
 * then you can check the Generic Type at runtime!
 */

fun main() {



    val mixedList: List<Any> = listOf("string", 10, BigDecimal(-22.54),
        Employee("name", "lastname", 2019),
        Car("blue", "seat", 2017),
        BigDecimal(900.099))

    // so when you call a function that returns a type of <T>
    // when calling it
    // you need to provide a Type you want to be returned <BigDecimal> or <String>..etc
    val bigDecimals = getElementsOfType<BigDecimal>(mixedList)
    val strings = getElementsOfType<String>(mixedList)

    println(bigDecimals)
    println(strings)
}

// the function has a return type of type T
inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {
    var newList: MutableList<T> = mutableListOf()
    for (el in list) {
        if (el is T) { // now, after the fun is inlined and T is reified, the TYPE T is NOT ERASED AT RUNTIME
            // you ONLY want to use REIFICATION if you need to check a Type INSIDE a Function
            newList.add(el)
        }
    }
    return newList
}