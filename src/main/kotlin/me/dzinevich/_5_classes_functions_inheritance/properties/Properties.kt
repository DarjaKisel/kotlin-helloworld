package me.dzinevich._5_classes_functions_inheritance.properties

// kotlin has no fields, only properties

fun main() {
    val emp1 = Employee("Anna")
    emp1.fullTime = false
    println(emp1.name + " " + emp1.fullTime)

    // there's no way of changing a private property
    // even if there are getters and setters
    // because properties and set/get methods must have the same visibility

    // custom getters/setters in Employee2
    val emp2 = Employee2("Loo")
    println(emp2.fullTime)
    emp2.fullTime = false // -> will call set() method
}

class Employee(val name: String, var fullTime: Boolean = true)


// if you create your own getters and setters
// you must declare a property within a class
// 1. remove val/var from the fulltime - it becomes just a parameter
// 2. declare a class property
// 3. add a set/ get method RIGHT after the property declaration and use the Backing 'field'
class Employee2(val name: String, fullTime: Boolean = true) {

    var fullTime = fullTime
    // !!! immediately after a property declaration add a getter/setter
    get() {
        println("Running a custom get()")
        return field
    }
    set(value) {
        println("Running a custom set()")
        field = value
    }



}
