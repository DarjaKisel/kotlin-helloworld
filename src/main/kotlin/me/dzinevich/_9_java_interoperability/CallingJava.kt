package me.dzinevich._9_java_interoperability

import me.dzinevich.Car
import java.math.BigDecimal

fun main() {
    val car = Car("blue", "ford", 2019)

    // use annotation @Nullable and @NotNull as a hint to help the compiler

    car.color = null // NO COMPILER ERRORS unit @NotNull is used in Car.setColor()

    var colorNullable: String? = car.color
    println(car)
    println(colorNullable)
    //println(colorNullable.javaClass) ---- error, no such Java class String? in Java

    // val colorNonNullable: String = car.color - error! car.color must not be null
    //println(colorNonNullable.javaClass)

    // Platform type occur when you're using types from another language (like Java)
    // when you see Type followed by ! in error message - it is Platform Type
    // val something: Int = car.model --- error (Required: Int Found: String! )

    // you can only treat fields like properties ONLY if java class field has getter and setter
    // we commented out Car.year getter and setter
    // car.year = 2020 -- error
    // let's make the field public
     car.year = 2020 // - now okay
    println(car)
}