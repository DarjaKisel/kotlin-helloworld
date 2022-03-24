package me.dzinevich._6_loops_if_when_trycatch_expressions

fun main() {

    // instead of
    // for(int i = 0; i < 10; i++) { }
    // kotlin uses ranges
    // range is an interval that has a start and an end values
    // you can use them in for loop and assign them to variables

    val range = 1..5 // all inclusive

    val charRange = 'a'..'z'

    val stringRange = "ABD".."XYZ"

    // everything that is Comparable can be in a range

    // use IN operator to check if smth is IN a range
    // IN checks if smth is >= to start value and <= to end value

    println(3 in range)
    println('q' in charRange)
    println("CCC" in stringRange)
    println("CCCCCC" in stringRange)
    println("ZZZZZZ" in stringRange)

    val backRange = 5.downTo(1)
    println(5 in backRange)

    // range with steps like 3,9,12,15...
    val stepRange = 3..15
    val stepThree = stepRange.step(3)
    val reversed = range.reversed()
    println(reversed)
    val reversedCharRange = charRange.reversed()
    println(reversedCharRange)

    for (i in reversed) {
        println(i)
    }

    for (i in stepThree) {
        println(i)
    }

//    for (s in stringRange) { - error with string range
//        println(s)
//    }
    val hello = "Hello"
    for (c in hello) {
        println(c)
    }

    for (num in 1..20) {
        print((num*10).toString() + ", ")
    }
    println()
    for (num in 1..20 step 4) {
        print((num*10).toString() + ", ")
    }
    println()
    for (i in 20 downTo 1 step 4) {
        print((i*10).toString() + ", ")
    }
    println()

    // if you want NOT INCLUSIVE - use UNTIL
    for (n in 12 until 34 step 2) {
        print((n).toString() + ", ")
    }

    val seasons = arrayOf("spring", "summer", "winter", "fall")
    for (s in seasons) {
        println(s)
    }
    val notASeason = "whatever" !in seasons
    println(notASeason)

    val notInRange = 32 !in 1..10
    println(notInRange)

    println('e' in hello)
    println('e' !in hello)

    //arrays have an extension function for iterating wih index
    for (index in seasons.indices) {
        println("${seasons[index]} is season number $index and it is beautiful")
    }

    seasons.forEach { println("$it hehe") }
    seasons.forEachIndexed() { idx, value -> println("season nr $idx is $value") }

    // you can give names to loops
    for (i in 1..3) {
        println("i = $i")
        jloop@ for (j in 1..4) {
            println("j = $j")
                for (k in 5..10) {
                    println("k = $k")
                    if (k == 7) {
                        break@jloop
//                       OR continue@jloop
                        // every time we hit 7 we want to break this loop and go back to i
                        // we don't want to continue the j loop and go back straight to i
                    }
                }
        }
    }




}