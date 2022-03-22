package me.dzinevich._6_classes_functions_inheritance.accessmodifiers

/**
 *  1. on the top level
 *  no modifier = default = public
 *  private - then everything in the same file can access it
 *  no requirement of matching class inside the file
 *  can create private classes in the same file
 *  module group of files that are compiled together
 *  'internal' modifier - visible inside the module
 *  protected - can't use on the top level
 *
 *  2. within a class
 *  public, private and protected - equal to java
 *  the only difference in the internal
 *  in kotlin classes can't see private members belonging to inner classes
 *
 *  on compilation:
 *  private - compiled to package private
 *  internal - compiled to public
 *
 *  All classes are public and final by default
 */

fun main() {
    //can use a private class in the same file
    val emp = PrivateEmployee()
    println(emp)

    val emp1 = Employee("John")
    val empShort1 = EmployeeShort("Short")
    println(emp1.firstName + " " + emp1.fullTime)
    println(empShort1.firstName + " " + empShort1.fullTime)

    val emp2 = Employee("Jane", false)
    val empShort2 = EmployeeShort("Short", false)
    println(emp2.firstName + " " + emp2.fullTime)
    println(empShort2.firstName + " " + empShort2.fullTime)

    println(Demo().hello)
}

private class PrivateEmployee {
}

// 1. equivalent to Java - using a primary constructor below + init block
//class Employee constructor(firstName: String) {
//    val firstName:String
//    init {
//        this.firstName = firstName
//    }
//}

// 2. combine with var declaration without init block
//class Employee constructor(firstName: String) {
//    val firstName:String = firstName
//}

// 3. we can remove explicit declaration of a variable and move it to constructor,
// kotlin will generate the code and assign the value
//class Employee constructor(val firstName: String) {
//}

// 4. we can remove constructor keyword, kotlin will generate everything
class Employee (val firstName: String) {

    var fullTime: Boolean = true

    //let's try to add a secondary constructor to add an optional 'fullTime' flag
    // need to call the primary constructor using : this(..)
    // can't use val in the secondary constructor
    // only primary constructor can declare properties
    // we need to actually declare a fullTime variable in the class
    constructor(firstName: String, fullTime: Boolean): this(firstName) {
        this.fullTime = fullTime
    }
}

class EmployeeShort(val firstName: String, var fullTime: Boolean = true)

// class without primary constructor
class Demo {
    val hello: String

    constructor() {
        this.hello = "Hello"
    }

}