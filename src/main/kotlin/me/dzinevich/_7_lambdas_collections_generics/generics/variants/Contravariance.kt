package me.dzinevich._7_lambdas_collections_generics.generics.variants

/**
 * CONTRAVARIANCE is used to accept instances of a SUB-class an any of it's SUPER-classes
 *
 * instead of "we want to accept a Cat and all of it's sub-classes" -> covariance -> look DOWN the inheritance tree
 * we say "we want to accept a Cat and all of it's super-classes"  -> contravariance -> look UP the inheritance tree
 *
 * so, the task is
 * when we receive a Cat / a Sub-Class of an Animal we also want to accept an Animal
 *
 * we can only use CONTRAVARIANT types as TYPE PARAMETERS and NOT as RETURN VALUES :)
 *
 */

fun main() {
    val catGroomingToy = object: AnimalCare<Cat> {
        override fun groom(animal: Cat) {
            println("I am grooming a cat!")
        }
    }
    val dogGroomingToy = object: AnimalCare<Dog> {
        override fun groom(animal: Dog) {
            println("I am grooming a dog!")
        }
    }
    val catHotel = PetHotel<Cat>(listOf(Cat("Fluffy"), Cat("Kitty")), catGroomingToy)
    catHotel.petPet(0)

    val dogHotel = PetHotel<Dog>(listOf(Dog("Ginger"), Dog("Bob"), Dog("John")), dogGroomingToy)
    dogHotel.petPet(2)


    // ----- what if we add more animals like Hamster/ Bird/ Turtle ?? - more implementations?


    // since we made the AnimalCare interface contravariant, and it accepts all the T and any of it's super-classes
    // now we can create 1 implementation of an AnimalCare for any Animal
    val petGroomingToy = object: AnimalCare<Animal> {
        override fun groom(animal: Animal) {
            println("I am grooming ${animal.name}")
        }
    }

    val catHotel2 = PetHotel<Cat>(listOf(Cat("Fluffy"), Cat("Kitty")), petGroomingToy)
    catHotel2.petPet(0)

    val dogHotel2 = PetHotel<Dog>(listOf(Dog("Ginger"), Dog("Bob"), Dog("John")), petGroomingToy)
    dogHotel2.petPet(2)


}

class PetHotel<T: Animal>(val pets: List<T>, val petCare: AnimalCare<T>) {
    fun getPet(i: Int) = pets[i]
    fun petPet(i: Int) {
        petCare.groom(pets[i])
    }
}

open class Animal(open val name: String) {}

class Cat(override val name: String): Animal(name) {}
class Dog(override val name: String): Animal(name) {}

// we made the Interface a contravariant by adding IN before the type
// WE WILL ACCEPT ALL TYPES THAT HAVE T -IN- THEIR INHERITANCE TREE
interface AnimalCare<in T> { // we accept whatever a T is and any of it's super-classes
    fun groom(animal: T)

    // we can only use CONTRAVARIANT types as TYPE PARAMETERS and NOT as RETURN VALUES :)
    //fun pick(): T ----- error!
    // if you return an Animal here, when you create a catHotel and ask to pick - you receive an Animal, not a Cat
    // - in other words - it is ok to treat a Cat like an Animal but not ok to treat an Animal like a Cat, it could be not a Cat at all :)
}