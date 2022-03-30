package me.dzinevich._7_lambdas_collections_generics


fun main() {
    val joe = Person("Joe", "Jones", 44)
    val joe2 = Person2("Joe", "Jones", 44)
    val (fName, lName, aAge) = joe
    val (fName2, lName2, aAge2) = joe2
    println("fName = $fName and lName = $lName and aAge = $aAge")
    println("fName = $fName2 and lName = $lName2 and aAge = $aAge2")

    val jane = Person("Jane", "Smith", 12)
    val mary = Person("Mary", "Wilson", 70)
    val john = Person("John", "Adams", 32)
    val jean = Person("Jean", "Smithson", 56)

    // imm map
    // key -lastname, val - person instance
    val aMap: Map<String, Person> = mapOf(
        joe.lastName to joe,
        jane.lastName to jane,
        mary.lastName to mary,
        john.lastName to john,
        jean.lastName to jean
    )
    println(aMap.count { it.value.lastName.startsWith("S") })

// pairs of first and last names
    val pairsOfFirstLastNames = aMap.map { Pair(it.value.firstName, it.value.lastName) }
    println(pairsOfFirstLastNames)
// var 2
    val firstNames = aMap.map { it.value.firstName }
    val lastNames = aMap.map { it.value.lastName }
    val pairsOfFirstLastNames2 = firstNames.zip(lastNames)
    println(pairsOfFirstLastNames2)

// use also() function (also() works like apply() but you use it instead of this inside a lambda)
    aMap.map { it.value }.forEach { println("${it.firstName} is ${it.age} years old") }

    // amap is the receiver for whathever we do in also() functions
    aMap.also {
        it.map { println("${it.value.firstName} is ${it.value.age} years old") }
    }

    val list1 = listOf(1,4,8,15,50)
    val list2 = listOf(4,55,-183,15, 0)
    val list3 = list1.filter { it in list2 }
    println(list3)


    // ------------------------------------------------------------------------------------------


    var regularPaper = Box<Regular>()
    var paper = Box<Paper>()
    paper = regularPaper

    regularPaper = paper
}


class Person(val firstName: String, val lastName: String, val age: Int) {
    operator fun component1() = firstName
    operator fun component2() = lastName
    operator fun component3() = age
}
data class Person2(val firstName: String, val lastName: String, val age: Int) {}

// we want box to accept T or any of T sub-classes
class Box<out T>{}

open class Paper{}

class Regular: Paper(){}
class Premium: Paper(){}