package me.dzinevich._5_classes_functions_inheritance.inheritance

// everything in kotlin is public and final by default
// so you can't extend classes as they're final by default
// you should say it is open explicitly

open class Vehicle(val model: String) { }

// subclass must call the parent constructor
class Truck(model: String): Vehicle(model) {
}

// or
//class Truck2: Vehicle {
//    constructor(): super()
//}

// abstract

abstract class AbsVehicle(val model: String) {
    open fun printModel() = println("The model name: $model")
    abstract fun thePrice(): Double
}
open class Car(model: String, horsePower: Int): AbsVehicle(model) {
    final override fun printModel() = println("The CAR model name: $model")
    override fun thePrice(): Double = 10099.99
}

// override also means open! you can also inherit it!

class ElectricCar(model: String): Car(model, 150) {

}

fun main() {
    val aCar = Car("Opel", 150)
    aCar.printModel()

    val smth = SomethingElse("abc")
}

// let's say we don't have a primary constructor
open class Something {
    val property: String
    constructor(param: String) {
        property = param
        println("Hello from Something")
    }
}

class SomethingElse: Something {
    constructor(otherParam: String): super(otherParam) {
        println("Hello from SomethingElse")
    }
}

// can't extend data classes (open, abstract, etc..)
//open data class Abcd(val prop: String) {} -> error









