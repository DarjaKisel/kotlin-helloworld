package me.dzinevich._7_lambdas_collections_generics

fun main() {
    val strings = listOf("spring", "summer", "winter", "fall") // this is an IMMUTABLE LIST
    println(strings.javaClass) // class java.util.Arrays$ArrayList

    val emptyList = emptyList<String>()
    val emptyList2: List<String> = emptyList()

    println(emptyList.javaClass)

    var strings1 = listOf<String>() // can't do anything with it, it is immutable

    if (emptyList.isNotEmpty()) {
        println(emptyList[0])
    }

    val notNullList = listOfNotNull("hello", "i", "am", "not", null)
    println(notNullList) // prints -- [hello, i, am, not]
    // the null value was never added to the list

    val arrayList = arrayListOf(1, 2, 3) // it is java MUTABLE arrayList
    println(arrayList.javaClass) // this is the old plain java.util.ArrayList class

    val mutableList = mutableListOf(1 ,2, 3)
    println(mutableList.javaClass) // this is absolutely the SAME MUTABLE old plain java.util.ArrayList class

    // Convert an array to list
    val array = arrayOf(1,2,3) // class [Ljava.lang.Integer; - array of Ints
    println(array.javaClass)
    val listFromArray = listOf(array)
    println(listFromArray.javaClass) // class java.util.Collections$SingletonList
    println(listFromArray) // this is an array of 1 element - the 1 element is the list of Ints
    // use spread operator
    val listFromArray2 = listOf(*array) // use * to UNPACK the array
    println(listFromArray2) // [1, 2, 3]
    println(listFromArray2.javaClass) //class java.util.Arrays$ArrayList

    // you can access elements in array in Kotlin using  [ ] square brackets
    // or set it
    mutableList[2] = 44
    println(mutableList[2])
    mutableList.set(2, 22)
    println(mutableList.get(2))

    // if we need a primitive type array[] in java
    val primitiveArray = intArrayOf(1,32,4)
    println(primitiveArray.toList()) //[1, 32, 4]
    println(primitiveArray.javaClass) //class [I

}