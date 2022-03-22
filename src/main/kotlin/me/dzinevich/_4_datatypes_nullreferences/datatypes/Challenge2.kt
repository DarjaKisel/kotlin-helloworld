package me.dzinevich

fun main() {
    val float1 = -3847.394f
    val float2: Float = -3847.394.toFloat()

    val float1_nullable: Float? = -3847.394f
    val float2_nullable: Float? = -3847.394.toFloat()

    val nonNullableArrayOfShorts: Array<Short> = arrayOf(1,2,3,4,5)
    val nullableArrayOfIntsTo200: Array<Int?> = Array(40) {
            i -> (i + 1)*5
    }
    for (i in nullableArrayOfIntsTo200) {
        println(i)
    }

    val charArray = charArrayOf('a', 'b', 'c')

    val x: String? = "I AM UPPERCASE"
    val y = x?.toLowerCase() ?: "I give up"
    println(y)
    val z: String? = null
    val q = z?.toLowerCase() ?: "I give up"
    println(q)

    val a: String? = "I AM IN UPPERCASE"
    println(a)
    a?.let { println(it.toLowerCase().replace("am", "am not")) }
}