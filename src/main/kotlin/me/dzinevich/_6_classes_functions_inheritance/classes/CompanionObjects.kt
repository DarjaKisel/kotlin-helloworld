package me.dzinevich._6_classes_functions_inheritance.classes

class SomeClass private constructor(val someString: String) {

//    val privateVal = 6
//    fun accessPrivateField() {
//        println("The private field value is $privateVal")
//    }

    companion object SomeName { // similar to static in java, we access it without creating an instance
        private val privateVal = 6
        fun accessPrivateField() {
            println("The private field value is $privateVal")
        }

        fun justAssign(str: String) = SomeClass(str)
        fun lowerOrUpper(str: String, isLower: Boolean): SomeClass {
            if (isLower) {
                return SomeClass(str.lowercase())
            } else {
                return SomeClass(str.uppercase())
            }
        }
    }
}

fun main() {
    SomeClass.SomeName.accessPrivateField() // like static in java
    // or
    SomeClass.accessPrivateField()

    // can't use private constructor
    // let's create some instances using factory methods
    val some1 = SomeClass.justAssign("abc")
    val some2 = SomeClass.lowerOrUpper("abc", false)

    println(some1.someString)
    println(some2.someString)

    wantsSomeInterface(object: SomeInterface {
        override fun mustImplement(num: Int): String {
            return "This is from Must Implement ${num*100}"
        }
    } )
}

// you can use companion objects to access private constructors
// -> to implement a factory pattern!

// Anonymous objects

interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("Want Some Interface: ${si.mustImplement(22)}")
}
