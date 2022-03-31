package me.dzinevich._8_file_io

import java.io.DataInputStream
import java.io.EOFException
import java.io.FileInputStream

val binPath = "src/main/kotlin/me/dzinevich/_8_file_io/testfile.bin"

fun main() {
    val dataInputStream = DataInputStream(FileInputStream(binPath))
    var string: String
    try {
        while (true) {
            string = dataInputStream.readUTF()
            println(string)
        }
    }
    catch (e: EOFException) {

    }

    // no try-with-resources in Kotlin!
    // function with use- in name is equivalent
}