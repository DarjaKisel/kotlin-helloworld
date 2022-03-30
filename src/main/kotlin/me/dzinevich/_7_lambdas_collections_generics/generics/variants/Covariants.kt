package me.dzinevich._7_lambdas_collections_generics.generics.variants

/**
 *  LIST IS NOT A TYPE
 *  LIST IS A CLASS
 *  LIST<STRING> IS A TYPE, LIST<INT> IS A TYPE
 *
 *  AND WE SAY THAT LIST<SHORT> IS A SUB-TYPE OF LIST<NUMBER>
 *  BECAUSE IT IS NOT A SUB-CLASS OF A LIST<NUMBER> IT IS NOT EXTENDING ANYTHING
 *
 *  IT IS MORE LIKE WE'RE SAYING THAT A LIST OF NUMBER SHOULD BE ABLE TO ACCEPT A LIST OF INT / SHORT
 *
 *  we know that Short is a sub-class of Number
 *  but is Short a sub-type of Number?
 *  is List<Number> a super-type of List<Short>?
 *
 *  we want to treat a list of shorts like a list of number
 *  and we were able to do this when we used an immutable List.
 *  so, we want a list of short to be a sub-type of list of number
 *  if we want this sub-typing to be preserved (saved)
 *  we need to declare a type parameter to be Covariant
 *
 * Collections interface - Covariant
 * Mutable Collections interface - Not Covariant
 *
 * Covariant = соизменимый (changing together)
 * Invariant = неизменный (never changing)
 *
 * COVARIANTS are used to PRESERVE SUB-TYPING
 *
 * IN and OUT are only allowed for type parameters of CLASSES and INTERFACES
 *
 */
fun main() {
    val shortList: List<Short> = listOf(1,2,3,45,5)
    convertToIntegers(shortList)
    // convertToIntegers2(shortList)  ---> error
    val mutableShortList: MutableList<Short> = mutableListOf(1,2,3,45,5)

    // convertToIntegers2(mutableShortList) ---> error again!

    // Type mismatch. Required:MutableList<Number> Found: MutableList<Short>
}

// instead of fun <T: Number?> convertToAnInt(collection: List<T>) {
// lets' have a
fun convertToIntegers(list: List<Number>) {
    for (num in list) {
        println(num.toInt()) // we know that every num has the toInt() function
    }
}
fun convertToIntegers2(list: MutableList<Number>) {
    for (num in list) {
        println(num.toInt()) // we know that every num has the toInt() function
    }
}


open class Flower {

}

class Rose: Flower() {

}

/**
 *
 * it has a type parameter <T:Flower>
 * you can have a garden of roses, a garden of other flowers..
 *
 * make a Garden covariant by adding - OUT - keyword
 * OUT comes with the price (like in immutable collections, you can only read them)
 *
 * -!- - !- -!- -!- -!- -!- - !- -!- -!- -!- -!- - !- -!- -!- -!-
 * you can only use a COVARIANT class in an OUT POSITION
 * -!- - !- -!- -!- -!- -!- - !- -!- -!- -!- -!- - !- -!- -!- -!-
 *
 * Kotlin has a Notion of IN and OUT positions
 * >- function parameters are IN position
 * >- return type is in OUT position
 *
 * A few exceptions:
 * >- constructor parameters don't have an IN and OUT position, so you can always accept a co-variant parameter
 * >- but is you have a var variable of type T - you can't use co-variant (because Kotlin generates a setter method,
 * and you can't have a sub-type T as a parameter in a setter
 * >-- you can use IN and OUT in PRIVATE :) no need to protect anything
 *
 * WE ACCEPT ALL THE TYPES THAT ARE MADE -OUT- OF FLOWER
 */

// it is declaration-side variance (we declared Generic type on a class)
class Garden<out T: Flower>(val something: T, private var somethingElse: T) {

    val flowers: List<T> = listOf()

    // here T is a return type == OUT position
    fun pickFlower(i: Int): T {
        return flowers[i]
    }

    // -!- - !- -!- -!- -!- -!- - !- -!- -!- -!- -!- - !- -!- -!- -!-
    // if we have a ROSE garden there will be nothing to stop us from planting a DAISY flower!
    // in other words: we can only grow/produce flowers that are subclasses of Flower
    // but not receive just any flowers!
    // all Roses are flowers but not all flowers are roses!
    //-!- - !- -!- -!- -!- -!- - !- -!- -!- -!- -!- - !- -!- -!- -!-

    // here T is a function param == IN position
    //fun plantFlower(flower: T) { --- error ----'Type parameter T is declared as 'out' but occurs in 'in' position in type T
    fun containsFlower(flower: @UnsafeVariance T) {
        //use this annotation ONLY  if the method is NOT changing anything!!!!1111
    }


}

// tend == care
fun tendGarden(roseGarden: Garden<Rose>) {
//    waterGarden(roseGarden) ---- error! like with SHort and Number
//    Garden<Rose> is not a sub-type of Garden<Flower>
//    Garden class is INVARIANT !
//    when we ask for a garden of flower we can only get a garden of flower!
//    subclasses of flower will not be accepted
//    in other words - sub-typing is Not preserved, it is invariant!
}

// function that waters a garden
fun waterGarden(garden: Garden<Flower>) {

}









