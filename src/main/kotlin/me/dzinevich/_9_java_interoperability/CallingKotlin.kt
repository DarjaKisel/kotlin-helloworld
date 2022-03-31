@file:JvmName("StaticCar")
package me.dzinevich._9_java_interoperability

fun topLevel() = println("I am in the cAr file!")

class SuperCar(color: String, @JvmField val model: String, val year: Int, var isAuto: Boolean) {
    var color: String = color
    set(value) {
        field = "always red"
    }

}

fun main() {
    "Striiiiiiiing".print()
}

fun String.print() {
    println(" ->>> wooohoo")
}