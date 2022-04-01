@file:JvmName("StaticCar")
package me.dzinevich._9_java_interoperability

import java.io.IOException
import kotlin.jvm.Throws

fun topLevel() = println("I am in the cAr file!")

class SuperCar(color: String, @JvmField val model: String, val year: Int, var isAuto: Boolean) {
    var color: String = color
    set(value) {
        field = "always red"
    }

    companion object {
        @JvmField val isAuto = false
        const val isExpensive = true
        @JvmStatic fun carComp() = println("I am the computer!")
    }

    fun printMe(text: String) {
        println("I dont really accept a null parameter! : $text")
    }

    @Throws(IOException::class)
    fun doIO() {
        throw IOException()
    }

    @JvmOverloads fun defaultArgs(string: String = "Default String") {
        println("I am printing the value:::: $string")
    }
}

object SingletonObj {
    @JvmStatic fun doSomething() = println("I am a Singleton instance printing a line!")
}

fun main() {
    "Striiiiiiiing".print()
}

fun String.print() {
    println(" ->>> wooohoo")
}