package me.dzinevich.imports

import me.dzinevich._6_classes_functions_inheritance.functions.upperFirstAndLast as up
import me.dzinevich._6_classes_functions_inheritance.classes.SomeInfo as Info
import me.dzinevich._6_classes_functions_inheritance.packages.topLevelFunction as func

fun main() {
    println("Package name doesn't match the real file location!")

    // import a top level function from another package
    func("Hello from the Imports file!")

    // import an object type
    println(Info.someInfo())

    // if you import from many sources and your imports are named the same
    // it's very useful to use as aliases

    "Another example string".up()
}

