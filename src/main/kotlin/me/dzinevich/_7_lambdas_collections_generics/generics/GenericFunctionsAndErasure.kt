package me.dzinevich._7_lambdas_collections_generics.generics

import java.lang.Appendable

/**
 * in Java you can provide a Generic type to ArrayList to help the compiler,
 * but after compilation this type is ERASED, so it is just an ArrayList for Java. |
 */
fun main() {
    // type parameter constraints to indicate what types can be used for a generic type
    val ints = listOf(1,2,3,4,5)
    val shorts: List<Short?> = listOf(10,20,30,40,50)
    val floats: List<Float?> = listOf(10.01f, -20.02f, -30.03f, 40.04f, -50.05f)
    val strings: List<String> = listOf("10.01f", "-20.02f", "-30.03f")

    convertToAnInt(shorts)
    convertToAnInt(floats)
//    convertToAnInt(strings) // - error -- doesn't stisfy the UPPER BOUND which is Number

    append(StringBuilder("abc"), StringBuilder("ABC"))

    printCollection(shorts)
//    printCollectionNonNullable(shorts) - error, shorts is nullable List<Short?>

    //type erasure in kotlin? - NOooooo KINDA :)
    // but it is still on COMPILE TIME
    if (strings is List<String>) {
        println("This list contains Strings")
    }

    var listAny: Any = listOf("str1", "str2")
    //if (listAny is List<String>) { ----- error
    // error - Cannot check for instance of erased type: List<String>

    // if (listAny is List) { ----- also an error
    // error - One type argument expected. Use 'List<*>' if you don't want to pass type argument
    // in Kotlin you HAVE TO specify the Generic type!
    if (listAny is List<*>) {
        println("This is a list. This <*> is called STAR PROJECTION")

        val strList = listAny as List<String>
        println("Finally this is a String!!!!! ---- ${strList[0].replace("str", "STRING")}")
    }

    // what if listAny doesn't contain a String?
    listAny = listOf(18.18, -100.01)
    val strList = listAny as List<String>
    println("Finally this is a String!!!!! ---- ${strList[0].replace("str", "STRING")}")


}

// a function that converts every number in a collection to an int
fun <T: Number?> convertToAnInt(collection: List<T>) {
    for (num in collection) {
        println("${num?.toInt()}")
    }
}

// function with MORE THAN ONE UPPER BOUND -- USE WHERE CLAUSE
fun <T> append(item1: T, item2: T)
    where T: CharSequence, T: Appendable {
        println("Result is ${item1.append(item2)}")
    }

// we can accept all types, even nullable by default T meas Any? |
fun <T> printCollection(col: List<T>) {
    for (item in col) {
        println(item)
    }
}
// what if we want to restrict T to only non-nullable - use Any |
fun <T: Any> printCollectionNonNullable(col: List<T>) {
    for (item in col) {
        println(item)
    }
}









