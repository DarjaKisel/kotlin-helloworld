package me.dzinevich._6_loops_if_when_trycatch_expressions

import java.math.BigDecimal

enum class Season {
    SPRING,
    WINTER,
    FALL,
    SUMMER
}

fun main() {

    val num = 133

    when(num) {
        100, 600 -> println("100 or 600")
        in 122..199 -> println("range from 122 to 199")
        200 -> println("200")
        300 -> println("300")
        else -> println("No match")
    }

    // we can use expressions

    val num2 = 90
    val y = 10

    when(num2) {
        y+80 -> println(90)
        y+90 -> println(100)
        else -> println("No match")
    }

    // we can use smart casting

    val obj: Any = "It's a string"
    val obj2: Any = BigDecimal(25.2)
    val obj3: Any = 45

    val something: Any = obj2

    if (something is String) {
        println(something.uppercase())
    }
    else if (something is BigDecimal) {
        println(something.remainder(BigDecimal(10.5)))
    }
    else if (something is Int) {
        println(something-22)
    }

    // instead, using when expression
    // we can assign when expression to a variable
    val z = when(something) {
        is String -> {
            println(something.uppercase())
            "case 1"
        }
        is BigDecimal -> {
            println(something.remainder(BigDecimal(10.5)))
            "case 2"
        }
        is Int -> {
            println(something-22)
            "case 3"
        }
        else -> "No match"
    }

    println(z)

    // use when with enum
    val timeOfYear = Season.WINTER
    val str = when(timeOfYear) {
        Season.SUMMER -> "summertime"
        Season.WINTER -> "wintertime"
        Season.SPRING -> "springtime"
        else -> "fall!"
    }

    println(str)

    // use when without a value
    val num3 = -50

    if (num2 < num3) {
        println("less")
    }
    else if (num2 > num3){
        println("greater")
    }
    else {
        println("equal")
    }

    when {
        num2 < num3 -> println("less")
        num2 > num3 -> println("greater")
        else -> println("equal")
    }
}