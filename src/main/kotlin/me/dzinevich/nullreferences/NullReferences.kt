package me.dzinevich.nullreferences

fun main() {
    //val str: String = null -> can't do this
    val str: String? = null // ? means a nullable type
    // now we can't use toUpperCase() because of a nullable type
    // we need to check for null first
    if (str != null) {
        str.toUpperCase()
    }
    // or
    str?.toUpperCase()
    println("What happens if we call: ${str?.toUpperCase()}")

    val str2: String = str ?: "Default string value"
    // str2 is a non-nullable String

    println("Str2 is: ${str2}")

    // val country = bankAccount?address?country ?: "US

    // CASTING
    val intArray: Any = arrayOf(1,2,3,4,5)
    val str3 = intArray as? String // try to cast an array of int to a string :)
    println(str3) // is null

    //val shouldBeANullableString: String = intArray as? String -> error
    val shouldBeANullableString: String? = intArray as? String

    println(shouldBeANullableString?.toUpperCase()) // will be null

    // we're sure that a var is not null - use !! assertion
    val str4: String? = "Something"
    str4!!.toUpperCase()

    // uncomment -> will trow an NPE
//    val npeStr = str!! // exception is thrown here, where is the assertion !!
//    npeStr.toUpperCase() // not here

    // printText(str5) - error, type mismatch
    str4?.let { printText(it) }

    val another = "another"
    println(str == another) // the == is safe operator even if str5 is null

    // ARRAYS
    val nullableIntArray = arrayOfNulls<Int?>(5) // all 5 elements are null
    // or ... = arrayOfNulls<Int>(5)
    for (i in nullableIntArray) {
        println(i)
    }
    println(nullableIntArray[3].toString())
}

fun printText(str: String) {
    println(str)
}