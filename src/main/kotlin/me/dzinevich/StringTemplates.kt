package me.dzinevich

fun main() {
    val emp1 = Employee("Alex", 111)
    println(emp1)
    val emp123 = EmployeeWithToString("Darya", 123)
    println(emp123)

    val change = 4.22
    println("The change is $$change")

    val nominator = 10.99
    val denominator = 20.00
    println("The value of $nominator divided by $denominator is ${nominator/denominator}")

    println("The employee id is ${emp1.id}")
}

class EmployeeWithToString(var name: String, val id: Int) {
    override fun toString(): String {
        return "EmployeeWithToString(name=$name, id=$id)"
    }
}