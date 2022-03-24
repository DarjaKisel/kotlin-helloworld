package me.dzinevich._5_classes_functions_inheritance.properties

// main purpose - storing state
// in data class we have: toString + equals + hashcode + copy
// data class must have a primary constructor which must have at least 1 param, it must be val or var not just a parameter
// data class can't be abstract or sealed or inner
// you can declare other properties, other than in the prim constructor, but they're ignored by tostring/ equals/ hashcode
data class Car(val color: String, val model: String, val year: Int) {
}

class RegularClass(var name: String = "abc")

fun main() {
    val car = Car("red", "opel corsa", 1991)
    println(car.toString())

    val car2 = Car("red", "opel corsa", 1991)

    println(car == car2) // data class instances are equal by reference
    println(car.equals(car2)) // data class instances are equal by structure

    val reg = RegularClass()
    val reg2 = RegularClass()
    println(reg == reg2) // regular class instances are NOT equal by reference

    //copy method
    val car3 = car2.copy()
    println(car3.toString())
    val car4 = car.copy(year = 2015) // we can change some of the properties
    println(car4.toString())
}