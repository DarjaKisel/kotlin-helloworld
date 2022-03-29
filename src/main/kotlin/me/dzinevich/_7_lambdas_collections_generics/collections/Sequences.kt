package me.dzinevich._7_lambdas_collections_generics

fun main() {
    // java Streams == Sequences

    println(immutableMap
        .asSequence()
        .filter { it.value.color == "red" }
        .map { it.value.year })

    listOf("Joe", "Mary", "John", "Mark", "Alex")
        .asSequence()
        .filter {
            println("Filtering: $it")
            it[0] == 'J'
        }.map {
            println("Mapping: $it")
            it.uppercase()
        }
    // nothing is printed! intermediate operations are lazy, they're not performed until terminal operation!

    listOf("Joe", "Mary", "John", "Mark", "Alex")
        .asSequence()
        // if we use asSequence -> values are evaluated one by one
        .filter {
            println("Filtering: $it")
            it[0] == 'J'
        }.map {
            println("Mapping: $it")
            it.uppercase()
        }.find { it.endsWith('E') }

    // only Joe pass the filter, then it is returned and NO other values are evaluated ever
    // output:
    // Filtering: Joe
    // Mapping: Joe

    listOf("Joe", "Mary", "John", "Mark", "Alex")
        // if we DON'T use asSequence -> all values are evaluated
        .filter {
            println("Filtering: $it")
            it[0] == 'J'
        }.map {
            println("Mapping: $it")
            it.uppercase()
        }.find { it.endsWith('E') }

    // output:
//    Filtering: Joe
//    Filtering: Mary
//    Filtering: John
//    Filtering: Mark
//    Filtering: Alex
//    Mapping: Joe
//    Mapping: John

}