package me.dzinevich._6_classes_functions_inheritance.functions

class Utils {
    fun upperFirstAndLast(str: String): String {
        return str.substring(0, 1).uppercase() +
                str.substring(1, str.length-1) +
                str.substring(str.length-1, str.length).uppercase()
    }
}
