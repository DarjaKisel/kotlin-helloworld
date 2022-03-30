package me.dzinevich._7_lambdas_collections_generics.generics.variants

fun main() {
    val cars1 = mutableListOf(Car(), Car())
    val cars2: MutableList<Car> = mutableListOf()
    copyCars(cars1, cars2)

    val fords1 = mutableListOf(Ford(), Ford())
    val fords2: MutableList<Ford> = mutableListOf()
//    copyCars(fords1, fords2) ---- error, it wants Cars not Fords
    copyCarsGeneric(fords1, fords2)

//    copyCarsGeneric(fords1, cars2) ---- error, T has to be the same! not Cars and Fords at the same time
//    BUT we should be able to do this!
    val cars3: MutableList<Car> = mutableListOf(Ford(), Toyota(), Ford())

    // change copyCarsGeneric(source: MutableList<out T>, destination: MutableList<in T>)
    // then try again
    copyCarsGeneric(fords1, cars3) // ----- works!

    println(cars3)
}

fun copyCars(source: MutableList<Car>, destination: MutableList<Car>) {
    for (car in source) {
        destination.add(car)
    }
}

/**
 * CAN'T do this:
 * fun <out T:Car> copyCarsGeneric(source: MutableList<T>, destination: MutableList<T>) {
 * IN and OUT are only allowed for type parameters of CLASSES and INTERFACES
 *
 * source is only READ == COVARIANT, (we want source a Car or any of it's Sub-Classes
 * destination is only WRITTEN == CONTRAVARIANT, (we write to list of Cars, or any of it's Super-classes)
 *
 * destination can contain at least the type T or more, source must le type T or lower
 */

fun <T:Car> copyCarsGeneric(source: MutableList<out T>, destination: MutableList<in T>) {
    for (car in source) {
        destination.add(car)
    }
}

open class Car{}

class Toyota: Car(){}
class Ford: Car(){}


/**
 * USE CASE:
 * you work with a 3rd party library
 * there is a class that's INvariant
 * and you want to write a code that uses instances of the class in a COvariant way
 *
 * USE-side covariance is == Wildcards in Java *
 *
 * List<? extends Car> -> covariant
 * List<? super Car> -> contravariant
 */
