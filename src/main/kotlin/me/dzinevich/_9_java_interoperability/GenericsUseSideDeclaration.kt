package me.dzinevich._9_java_interoperability

import me.dzinevich.Car

fun main() {

    // ----------------------------------------------------------------
    // WILDCARDS.

    // wildcards in Java are converted to use-side declarations in Kotlin

    // ? extends Something -> converted to 'out' == covariant
    // ? super -> converted to 'in' == contravariant

    // ----------------------------------------------------------------
    // EXCEPTIONS.

    // if you call a Java method that calls an Exception
    // and you don't handle the exception - No Worries :)
    // Kotlin doesn't distinguish checked and unchecked exceptions

    // ----------------------------------------------------------------
    // VARARGS.

    val car = Car("green", "land rover", 2018)
    car.variableMethod(5, "aaa", "bbb", "ccc")

    val strings = arrayOf("aaa", "bbb", "ccc")
    //car.variableMethod(10, strings) ----- error!
    // we have to use spread operator to unpack an array
    car.variableMethod(10, *strings)

    // ----------------------------------------------------------------
    // VOID.

    // if java method returns void - in Kotlin it will return a Unit


    // ----------------------------------------------------------------
    // PRIMITIVE TYPES.

    // if a java methods required a primitive int[], short[]..etc
    // you need to use a kotlin function intArrayOf() or use a function arrayOIf(..).toIntArray
    val ints = arrayOf(1,2,3,4,5)
    // car.wantAnArray(ints) -- error! Type mismatch. Required: IntArray! Found: Array<Int>
    car.wantAnArray(ints.toIntArray())
    car.wantAnArray(intArrayOf(1,2,3,4,5))

    // ----------------------------------------------------------------
    // OBJECT CLASS.

    // something declared as Object in Java -> it will become Any in Kotlin
    // but, Any doesn't have all the methods that Object has (only equals(), hashCode(), and toString())
    // so if you really need them (notify() method) - you need to use Object from Java explicitly.

//    (car.anObject as java.lang.Object).notify()
//    car.anObject.javaClass // equivalent to getClass()

    // ----------------------------------------------------------------
    // STATIC METHOD / FIELDS.

    // they become companion objects in Kotlin

    println("x = ${Car.x}")
    println(Car.xString())


    // ----------------------------------------------------------------
    // MUTABLE

    // public fields and fields that have setters -> vars in Kotlin

    // ----------------------------------------------------------------
    // SAM - single abstract method

    // car.demoMethod() requires a Runnable
    // Runnable only has one method run() ----> SAM interface

    car.demoMethod( { println("I am inside the runnable!!")} )
}