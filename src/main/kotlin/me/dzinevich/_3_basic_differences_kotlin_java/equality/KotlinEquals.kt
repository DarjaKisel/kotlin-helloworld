package me.dzinevich._3_basic_differences_kotlin_java.equality


fun main() {
    val emp1 = Employee("Alex", 1)
    val emp2 = Employee("Josh", 2)
    val emp3 = Employee("Josh", 2)
    val emp4 = emp2

    println(emp1 == emp2) // structural equals
    println(emp2 == emp3)

    println(emp2 === emp3) // referential equals

    println(emp1.equals(emp2)) // structural equals
    println(emp2.equals(emp3))

    println(emp4 === emp2)

    println("Expected: \n false \n true \n false \n false \n true \n true")

    // "In Kotlin '==' and 'equals' do the same thing"
    // "In Kotlin '===' checks referential equality"

    println(emp4 != emp2) // checking structural - expected false
    println(emp4 !== emp2) // checking ref - expected false
    println(emp2 != emp3) // checking structural - expected false
    println(emp2 !== emp3) // checking ref - expected true
}