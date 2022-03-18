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

    // RAW Strings

    //val filePath = "C:\dirName\folderName\file.txt" - error, need escape slashes
    val filePath = """C:\dirName\folderName\file.txt"""

    //multiline
    val name = "cat"
    val aLongText =
     """There was
        |a really long text
        |about a $name
        |and stuff""".trimMargin()
    println(aLongText)

    val oneOne = """    1
        |   11
        |  111
        | 1111""".trimMargin()
    println(oneOne)
}

class EmployeeWithToString(var name: String, val id: Int) {
    override fun toString(): String {
        return "EmployeeWithToString(name=$name, id=$id)"
    }
}