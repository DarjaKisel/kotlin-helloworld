package me.dzinevich._7_lambdas_collections_generics.collections

fun main() {

    val immutMap = mapOf(
        1 to Car("red", "porche", 2019),
        2 to Car("gray", "ford", 2015),
        3 to Car("black", "bmw", 2017))
    println(immutMap.javaClass) // class java.util.LinkedHashMap
    println(immutMap)

    val mutableMap = mutableMapOf<String, Car>(
        "Porche" to Car("red", "porche", 2019),
        "Ford" to Car("gray", "ford", 2015),
        "BMW" to Car("black", "bmw", 2017))
    println(mutableMap.javaClass) // class java.util.LinkedHashMap
    println(mutableMap)

    // LinkedHashMap makes it easy to convert to Set and keep the order

    // If we want a HashMap - we need to say 'hashMapOf'
    val hashMap = hashMapOf<Int, Car>(
        1 to Car("red", "porche", 2019),
        2 to Car("gray", "ford", 2015),
        3 to Car("black", "bmw", 2017))
    println(hashMap.javaClass) // class java.util.HashMap
    println(hashMap)
    // it is Mutable!
    hashMap[5] = Car("olive", "range rover", 2018)
    println(hashMap)

    // DESTRUCTURING DECLARATIONS

    val pair = Pair(10, "ten")
    val first = pair.first
    val second = pair.second
    val (firstV, secondV) = pair
    println(firstV)
    println(secondV)

    // same with map - instead of entry, use just (k,v)
//    for (entry in mutableMap) {
//        println(entry.key)
//        println(entry.value)
//    }
    for ((key, value) in mutableMap) {
        println(key)
        println(value)
    }

    // if you want to destructure a class this way
    // you need to implement a COMPONENT functions
    // both Pair class and Map.Entry class have implemented them

    val car = Car("blue", "Aston Martin", 1971)
    val (c, m, y) = car
    println("color is $c")
    println("model is $m")
    println("year is $y")




}

data class Car(val color: String, val model: String, val year: Int) {

    //in a DATA CLASS we get them for free :)
//    operator fun component1() = color
//    operator fun component2() = model
//    operator fun component3() = year
}