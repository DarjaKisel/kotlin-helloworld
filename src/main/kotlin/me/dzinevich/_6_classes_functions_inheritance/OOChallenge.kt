package me.dzinevich._6_classes_functions_inheritance

open class KotlinBicycle(var cadence: Int, var gear: Int = 10, var speed: Int) {
    fun applyBrake(decrement: Int) = run { this.speed -= decrement }
    fun speedUp(increment: Int) = run { this.speed += increment }
    open fun printDescription() = println("the bike has gear: $gear and cadence: $cadence and speed: $speed")
}

class KotlinMountainBike(var seatHeight: Int, cadence: Int, gear: Int = 10, speed: Int):
    KotlinBicycle(cadence, gear, speed) {
    override fun printDescription() {
        super.printDescription()
        println("and the bike has seatHeight: $seatHeight")
    }

    constructor(color: String, seatHeight: Int, cadence: Int, gear: Int = 123234234, speed: Int):
            this(seatHeight, cadence, gear, speed) {
        println("color is $color")
    }

    companion object {
        val availableColors = listOf<String>("red", "green", "blue", "black", "white")
    }
}

class KotlinRoadBike(val tireWidth: Int, cadence: Int, gear: Int = 10, speed: Int):
    KotlinBicycle(cadence, gear, speed) {
    override fun printDescription() {
        super.printDescription()
        println("and the bike has tireWidth: $tireWidth")
    }
}

fun main() {
    val kotlinBike = KotlinBicycle(cadence = 12, speed = 14)
    kotlinBike.printDescription()

    val kotlinMountainBike = KotlinMountainBike(seatHeight = 3, cadence = 11, speed = 16)
    kotlinMountainBike.printDescription()

    val kotlinRoadBike = KotlinRoadBike(66, 10, 4, 25)
    kotlinRoadBike.printDescription()

    val kotlinMountainBike2 = KotlinMountainBike("red", cadence = 10, seatHeight = 22, speed = 40)
    kotlinMountainBike2.printDescription()

    KotlinMountainBike.availableColors.forEach { print(it + ", ") }
}
