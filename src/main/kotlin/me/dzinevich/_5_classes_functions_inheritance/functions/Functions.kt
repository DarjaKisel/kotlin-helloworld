package me.dzinevich._5_classes_functions_inheritance.functions

import me.dzinevich._5_classes_functions_inheritance.properties.Car

// functions in classes == methods, member functions
// default return type is Unit

fun main() {
    println(labelMultiply(label = "Here's the result:", operand2 = 3, operand1 = 4))
    println(labelMultiplyVer2(3, 4, "The result is:"))

    val emp = Employee("jane")
    println(emp.toUpFun()) // calling a member function just like a method in java

    val car1 = Car("red", "opel corsa", 1991)
    val car2 = Car("blue", "ford mustang", 1995)
    val car3 = Car("gray", "toyota land cruiser", 2001)
    printColors(car1, car2, car3, str = "ABC") // you should name the vars after the vararg

    // pass an array to a function requiring vararg parameter
    val myArray = arrayOf(car1, car2, car3)
    printColors(*myArray, str = "ABC") // use spread operator * to unpack the array

    // also, use * spread operator to combine 2 arrays together
    val myAnotherArray = arrayOf(car2, car2)
    val car4 = Car("yellow", "submarine", 1974)

    val lotsOfCars = arrayOf(*myArray, *myAnotherArray, car4)
    println("Size is ${lotsOfCars.size}")
    for (c in lotsOfCars) {
        println(c)
    }
}

// function parameter should alwasy include the type!
// once you put one parameter not in the order - you have to call names of all the others too
// only one vararg parameter per function is possible!

// function with block body
fun labelMultiply(operand1: Int, operand2: Int, label: String = "The answer is:"): String {
    return ("$label ${operand1 * operand2}")
}

// function with expression body
fun labelMultiplyVer2(operand1: Int, operand2: Int, label: String): String = "$label ${operand1 * operand2}"

// function with varargs
fun printColors(vararg cars: Car, str: String) {
    cars.forEach { println(it.color) }
}

class Employee(val name: String) {
    // this fun is public and final just like everything else in kotlin
    fun toUpFun() = name.uppercase()
}