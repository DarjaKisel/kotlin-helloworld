package me.dzinevich._6_loops_if_when_trycatch_expressions

fun main() {
    println(getNumber("22"))
    println(getNumber("22.55") ?: "I can't print the result")
    println(getNumber("22.55") ?: throw IllegalArgumentException("Number isn't an Int"))
    notImplementedYet("str")
}

fun getNumber(str: String):Int? {
    return try {
        Integer.parseInt(str)
    }
    catch (e: NumberFormatException) {
        null
    }
    finally {
        println("finally!")
        123456 // - this is NEVER returned!
    }
}

// return Nothing type
fun notImplementedYet(smth: String): Nothing {
    throw IllegalArgumentException("Not implemented yet")
}






