package me.dzinevich._5_classes_functions_inheritance.inheritance

interface MyInterface {
    val num: Int
    //val num2: Int = 2 - error, can't initialize
    val num2: Int
    get() { // have to use get() to have a concrete value
        //return field*2 // can't use the backing filed 'field' in get() / set() in interfaces
        return num*2 // can't use the backing filed 'field' in get() / set() in interfaces
    }

    fun myFun(str: String): String
}

// extendable by default, don't need 'open'
interface MySubInterface: MyInterface {
    fun mySubFun(num: Int): String
}

open class InterfaceImpl: MySubInterface {
    override val num: Int = 24
    override val num2: Int = 3

    override fun mySubFun(num: Int): String {
        TODO("Not yet implemented")
    }
    override fun myFun(str: String): String {
        TODO("Not yet implemented")
    }
}