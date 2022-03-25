package me.dzinevich._6_loops_if_when_trycatch_expressions

fun main() {
    printRangeFrom5to5kInStepsOf5()
}

fun printRangeFrom5to5kInStepsOf5() {
    for (num in 5..5000 step 5) {
        print(num.toString() + ", ")
    }
    println()
    for (num in -500..0) {
        print(num.toString() + ", ")
    }
    println()

    // first 15 numbers of fibonacci sequence
    var sum:Int
    var beforeLast = 0
    var last = 1
    println(beforeLast)
    println(last)

    for (i in 1..13) {
        sum = beforeLast + last
        println(sum)
        beforeLast = last
        last = sum
    }

    // we need 1, 11, 100, 99, 98, 2
    iloop@for (i in 1..5) {
        print("$i, ")
        if (i == 2) {
            break
        }
        for (j in 11..20) {
            print("$j, ")

            for (k in 100 downTo 90) {
                print("$k, ")
                if (k == 98) {
                    continue@iloop
                }
            }
        }
    }

    val num = 122
    val dnum:Double =
        when {
            num > 100 -> -234.567
            num < 100 -> 444.555
            else -> 0.0
        }
    println("\n $dnum")
}