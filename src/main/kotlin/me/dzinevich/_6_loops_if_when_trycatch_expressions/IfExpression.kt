package me.dzinevich._6_loops_if_when_trycatch_expressions

fun main() {
    // no ternary operator in Kotlin!

    val someCondition = 69 < 22

    var num: Int
    if (someCondition) {
        num = 50
    } else {
        num = 522
    }

    // num = someCondition ? 50 : 522 - in Java

    num = if (someCondition) 50 else 522 // the same in Kotlin
    println(num)

    // we can return from if-expression
    println(
        "The result of the if-expression is ${
            if (someCondition) {
                println("something")
                50
            } else {
                println("Else")
                522
            }
        }"
    )

    // we can assign if-expression to a variable
    val ifExpression = if (someCondition) {
        println("something")
    } else {
        println("Else")
    }
    println(ifExpression.javaClass)
}