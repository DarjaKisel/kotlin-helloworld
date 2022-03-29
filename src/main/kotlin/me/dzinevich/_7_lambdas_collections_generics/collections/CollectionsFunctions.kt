package me.dzinevich._7_lambdas_collections_generics

import me.dzinevich._7_lambdas_collections_generics.collections.Car

val immutableMap = mapOf<String, Car>(
    "Porche" to Car("red", "porche", 2019),
    "Ford" to Car("red", "Ford", 2015),
    "BMW" to Car("black", "bmw", 2017),
    "Ford2" to Car("silver", "Ford", 2022),
    "Opel" to Car("silver", "Opel", 2018))

fun main() {
    val setInts = setOf(1,2,3,4,5,67,-1)

    // 1. filter

    println(setInts.filter { it % 2 != 0 })
    println(immutableMap.filter { it.value.year == 2017 })

    val mutableMap = mutableMapOf<String, Car>(
        "Porche" to Car("red", "porche", 2019),
        "Ford" to Car("gray", "ford", 2015),
        "BMW" to Car("black", "bmw", 2017))

    mutableMap.filter { it.value.color == "black" }
    println("The filtered map is $mutableMap")
    // filter doesn't cha\nge the original collection, it returns anew collection

    // 2. map

    val ints = arrayOf(1,2,3,4,5)
    val add20list: MutableList<Int> = mutableListOf()

    for (i in ints) {
        add20list.add(i + 20)
    }
    println(add20list)

    // instead, use map function
    val add10list = ints.map { it+10 }
    println(add10list)

    println(immutableMap.map { it.value.year })
    println(immutableMap.filter { it.value.model == "Ford" }.map { it.value.color })

    //3. all | any | count

    println(immutableMap.all { it.value.color == "red" })
    println(immutableMap.any { it.value.color == "red" })
    println(immutableMap.count { it.value.model == "Ford" })

    // 4. find | groupBy
    val cars = immutableMap.values
    println(cars.find { it.year > 2017 }) // return single first item that satisfies the condition
    println(cars.groupBy { it.color })

    // 5. sorted
    println(immutableMap.toSortedMap()) // sorted by key
    println(cars.sortedBy { it.year }) // sorted by year
}