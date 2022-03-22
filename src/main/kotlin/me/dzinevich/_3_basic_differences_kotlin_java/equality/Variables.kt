package me.dzinevich._3_basic_differences_kotlin_java.equality

fun main() {
    val numberVal = 10;
    //numberVal = 11 - can't reassign a val

    var numberVar = 10
    numberVar = 11
    // ^ see vars are underlined

    val numberInt: Int = 10 // don't declare a type twice, the default type Int is known to the compiler
    val numbrInt = 10
    val numberShort: Short = 10

    // you can't reassign an employee instance, but you can change properties inside the instance
    val employee1 = Employee("Darya Kisel", 400)
    employee1.name = "Darya Zinevich"
    // employee1 = Employee("Darya Zinevich", 400) -> error

    val employee2: Employee
    val aNum = 200
    // the if-else guaranties to the compiler that employee2 will be assigned only once

    if (aNum > numberVal) {
        employee2 = Employee("Mike Skott", 120)
    }
    else {
        employee2 = Employee("Skott Mike", 210)
    }

    // can't change the data type on a fly
    // numberVal = "String" -> error
}

class Employee(var name: String, val id: Int) { // name can change, id cannot

    override fun equals(obj: Any?) : Boolean {
        if (obj is Employee) {
            return name == obj.name && id == obj.id
        }

        return false;
    }
}