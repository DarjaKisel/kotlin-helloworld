package me.dzinevich._8_file_io

import java.io.File

// walk() function accepts 'down' and 'up' to specify the direction

// walk bottom-up a tree - directories are visited after their files

// walk top-down a tree - directories are visited before files in them

fun main() {
    File("./src/main/kotlin/me/dzinevich/_8_file_io").walkTopDown()
        .filter { file -> file.name.endsWith(".kt") }
        .forEach { file -> println(file) }
}