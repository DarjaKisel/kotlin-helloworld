package me.dzinevich._6_classes_functions_inheritance.functions

// extension functions - can extend any class you want with a function
fun main() {
    val s = "this is lowercase"
    println(Utils().upperFirstAndLast(s))
    println(s.upperFirstAndLast())

    // our string s - is the receiver object
    // our String class - is the receiver type, the type that we're extending
    // the object that we use to call the receiver function - is the receiver object

}

// associate it with the String class
// we no longer have to take String as a parameter
// this. refers to an instance that we use to call the function (or we can remove this.)

fun String.upperFirstAndLast(): String {
    return substring(0, 1).uppercase() +
            this.substring(1, length-1) +
            this.substring(length-1, this.length).uppercase()
}