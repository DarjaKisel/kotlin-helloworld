package me.dzinevich._6_classes_functions_inheritance.classes

enum class Department(val fullName: String, val employees: Int) {
    HR("Human Resources", 5),
    IT("Info technology", 10),
    ACCOUNTING("Accounting", 3),
    SALES("Sales", 20);

    fun getDepartmentInfo(): String = "The $fullName department has $employees employees"
}

fun main() {
    println(Department.SALES.getDepartmentInfo())
}