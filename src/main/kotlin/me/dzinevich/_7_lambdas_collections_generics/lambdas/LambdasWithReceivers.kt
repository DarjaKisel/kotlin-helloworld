package me.dzinevich._7_lambdas_collections_generics

import me.dzinevich._7_lambdas_collections_generics.lambdas.Employee
import me.dzinevich._7_lambdas_collections_generics.lambdas.employees
import java.lang.StringBuilder

fun countTo100(): String {
    val numbers = StringBuilder()
    for (i in 1..99) {
        numbers.append(i)
        numbers.append(", ")
    }
    numbers.append(100)
    return numbers.toString()
}

// we refer the _numbers_ variable to much
// use _with_ function
// with takes in: 1) an instance 2) a lambda

fun countTo100WithWith() =
    with(StringBuilder()) {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }

// use the apply
// we DON'T PASS an instance TO APPLY
// we USE an instance and we INVOKE APPLY ON it
fun countTo100WithApply() =
    StringBuilder().apply {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
    }.toString()


fun main() {
    println(countTo100())
    println(countTo100WithWith())
    println(countTo100WithApply())

    findByLastName(employees, "Johnson")
    findByLastName(employees, "Jameson")

    "Some string".apply someString@ {
        "Another String".apply {
            println(this@someString.uppercase() + lowercase())
        }
    }

}

fun findByLastName(employees: List<Employee>, nameToFind: String) {
//    for (emp in employees) {
//        if (emp.lastName == nameToFind) {
//            println("Found it! with lastname: $nameToFind")
//            return
//        }
//    }

    employees.forEach returnBlock@ {
        if (it.lastName == nameToFind) {
            println("Found it! with lastname: $nameToFind")
            //return ---- this return will return from both foreach and the method
            // if we only want to return from a lambda - @label it
            return@returnBlock
        }
    }

    println("No such employee with lastName: $nameToFind")
}