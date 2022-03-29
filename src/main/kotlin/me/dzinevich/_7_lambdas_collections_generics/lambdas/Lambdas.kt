package me.dzinevich._7_lambdas_collections_generics.lambdas

val employees = listOf(
    Employee("John", "Smith", 2015),
    Employee("Josh", "Johnson", 2020),
    Employee("Alex", "Long", 2018)
)

fun main() {
    // run { println("I'm in a lambda!") } // run a lambda using Run statement

    println(employees.minByOrNull { e -> e.startYear })
    // we can use _it_ when there's a single parameter and compiler can infer the type
    println(employees.minByOrNull { it.startYear })
    // replace a lambda with a call to a _member reference_
    println(employees.minByOrNull(Employee::startYear))
    // or a call to a top level function
    run(::topLevel)
    run { topLevel() }

    // you can access mutable vars from a lambda
    // in java you can access only _final_ vals
    var n = 10
    run {
        n +=10
        println(n)
    }
}

// can access function parameters but can't change them
fun useParameter(emplList: List<Employee>, num: Int) {
    emplList.forEach {
        println(it.firstName)
        println(num)
    }
}

fun topLevel() {
    println("I am in a top level function")
}

data class Employee(val firstName: String, val lastName: String, val startYear: Int) {

}

