//@file:JvmName("KotlinChallenge")

package me.dzinevich._9_java_interoperability

import me.dzinevich.Challenge9

fun main() {
    val emp = Challenge9.Employee("Jane", "Smith", 2000)

    emp.lastName = "Jones"
    emp.salaryLast3Years = floatArrayOf(50000.25f, 54000.60f, 56800.42f)
}

fun seyHelloToJava(name: String) {
    println("Kotlin says hello to Java and $name")
}

object Challenge {
//    @JvmStatic fun doMath(x: Int, y: Int) = (x + y) * (x - y)
    fun doMath(x: Int, y: Int) = (x + y) * (x - y)
}

class EmployeeKotlin(val firstName: String, val lastName: String, var startYear: Int) {
//    class EmployeeKotlin(val firstName: String, val lastName: String, @JvmField var startYear: Int) {

    @JvmOverloads
    fun takesDefault(param1: String, param2: String = "Default") {
        println("param1: $param1 and param2 $param2")
    }
}