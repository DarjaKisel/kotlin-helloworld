package me.dzinevich._7_lambdas_collections_generics

fun main() {
    val strings = listOf("spring", "winter", "summer", "summer")
    val colors = listOf("white", "black", "red", "black", "white")

    // get last element
    println(strings.last())
    println(strings.first())

    // reverse
    println(strings.reversed())

    // what if we want an element at idx 5
    if (strings.size > 5) {
        println(strings[5])
    }
    // instead
    println(strings.getOrNull(5))

    val ints = listOf(1,2,44,5)
    println(ints.maxOrNull())

    // join 2 collections
    println(strings.zip(colors)) // zip creates Pair elements

    // if collection's size aren't equal - elements from the longer list are dropped
    // [(spring, white), (winter, black), (summer, red)]

    val mergedList = listOf(colors, strings)
    println(mergedList)

    // a list containing 2 lists :)
    // [[white, black, red], [spring, winter, summer]]

    val combinedList = strings + colors
    println(combinedList)
    // finally! concatenated list
    // [spring, winter, summer, white, black, red]

    // if we don't wat any duplicates - use Union function
    val noDuplicates = strings.union(colors)
    println(noDuplicates)

    // ust remove duplicated from the list
    val noDupsColors = colors.distinct()
    println(noDupsColors)

    //make an Immutable list Mutable
    val mutableSeasons = strings.toMutableList()
    mutableSeasons.add(4, "something new")
    println(mutableSeasons)

}