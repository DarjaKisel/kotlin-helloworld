package me.dzinevich

fun main() {
    val myInt = 10
    var myLong = 12L
    myLong = myInt.toLong() // no automatic num widening in Kotlin
    println("Default datatype is an Int? - ${myInt is Int}")

    val myByte: Byte = 111
    var myShort: Short
    myShort = myByte.toShort() // no automatic num widening in Kotlin

    //Exception: numeric literals
    val anotherInt = 5

    var myDouble = 65.5
    println(myDouble is Double)

    val myFloat = 35.8349f
    println("myFloat is float? - ${myFloat is Float}")
    myDouble = myFloat.toDouble() // no automatic num widening in Kotlin

    //CHARS

    val char = 'b'
    //java
    //char myChar = 65;

    val myChar = 65// in Kotlin this will be an int :)
    //val myChar: Char = 65 -> error

    val myCharInt = 65
    println(myCharInt.toChar()) // we need to call a method to get a char

    //BOOL

    val myBool = true


    //Call a java method that requires primitive types as args
    val vacationTime = false
    //kotlin class Boolean is compiled to a primitive boolean in java
    val onVacation = DummyClass().isVacationTime(vacationTime)
    println(onVacation)

    // ANY - sort of an Object in java
    // it is a root of any object in kotlin
    // includes function definition: toString, hashCode, equals
    val any: Any

    // UNIT - sort of a void in java (not really a data type in java)
    // it's a singleton unit instance (it is really a data type in kotlin)

    // NOTHING - is a subclass of every class
}