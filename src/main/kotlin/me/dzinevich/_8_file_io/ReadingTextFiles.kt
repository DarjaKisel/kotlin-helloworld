package me.dzinevich._8_file_io

import java.io.File

val path = "src/main/kotlin/me/dzinevich/_8_file_io/testfile.txt"

fun main() {
    // equivalent to:
    //new InputStreamReader(new FileInputStreamReader(new File(path), "UTF-8"))

    val lines = File(path).reader().readLines()

    // readlines() function Javadoc says Don't use for huge files! Closes the stream automatically

    lines.forEach { println(it) }

    val reader = File(path).reader()
    val file = reader.readText()
    // readText() returns entire file, doesn't close the stream!
    println(file)
    reader.close()

    // variant 2 - use use() function
    // use - executes the given block on that resource and then closes it correctly (try-catch)
    val lines2 = File(path).reader().use { it.readText() }
    println(lines2)

    val lines3 = File(path).readText() // closes the resource, but has a hard limit of 2 GB
    println(lines3)

    // we want 1 line at a time
    // use forEachLine() function
    File(path).reader().forEachLine { println(it) }
    // forEachLine inside uses the useLines() function
    // if we do
    File(path).reader().useLines { println(it) }
    // we'le get a sequence since there is no terminate operation
    File(path).reader().useLines { it.forEach { println(it) } }
}