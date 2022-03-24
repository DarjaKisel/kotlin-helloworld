package me.dzinevich._5_classes_functions_inheritance.functions

fun function_NotInline(op1: Int, op2: Int, label: String) = "${label} ${op1 * op2}"

// make it inline:
// inline function is NOT compiled to a function at all
// when it's compiled it's body is directly substituted to a function call

inline fun function_Inline(op1: Int, op2: Int, label: String) = "${label} ${op1 * op2}"