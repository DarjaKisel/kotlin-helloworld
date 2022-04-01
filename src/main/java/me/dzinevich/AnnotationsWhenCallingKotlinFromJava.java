package me.dzinevich;

import java.io.IOException;
import me.dzinevich._9_java_interoperability.SingletonObj;
import me.dzinevich._9_java_interoperability.SuperCar;

public class AnnotationsWhenCallingKotlinFromJava {

  public static void main(String[] args) {
    SuperCar superCar = new SuperCar("yellow", "lamborgini", 2016, false);

    // how to use companion objects ? and object instances ?
    // use Annotation @JvmStatic.
    // it will tell the compiler to make 2 versions of a function:
    // one as it normally does, and a static version of a function that would be called from java

    SuperCar.Companion.carComp(); // this is an instance method
    // after adding a @JvmStatic to method ->
    SuperCar.carComp(); // now you call it statically
    // this is important if the carComp() uses static filels, then you need to use a static function, not an instance function

    // access a field in companion obj
    // var isAuto = SuperCar.Companion.isAuto();

    // once we add @JvmField we can access field directly
    var isAuto = SuperCar.isAuto;
    System.out.println("is auto? :" + isAuto);

    // if the field is const - it is automatically static, no need to add @JvmField
    System.out.println("is expensive? :" + SuperCar.isExpensive);

    // ----------------------------------------------------------------
    // NAMED object instances


    SingletonObj.INSTANCE.doSomething(); // this is an instance method
    // after adding a @JvmStatic to method ->
    SingletonObj.doSomething(); // this is a static method


    // ----------------------------------------------------------------
    // NON-NULL SAFETY
    // there's nothing to stop Java from passing a null to a function
    // that is not expecting a non-null parameter
    // kotlin generates an exception when this happens

    //superCar.printMe(null); ----- error
    //NullPointerException: Parameter specified as non-null is null


    // ----------------------------------------------------------------
    // EXCEPTIONS

    // what happens if Kotlin function throws an exception,
    // and we call it from Java?
    // superCar.doIO(); -> throws IO exception, let's try catching it:

    try {
      superCar.doIO();
    } catch (IOException e) {
       // by default -> CAN'T CATCH THIS!
       // Exception 'java.io.IOException' is never thrown in the corresponding try block.

      // only after we annotate the function with @Throws(IOException::class)
      // Java compiler will see it

      System.out.println("IO ex");
    }


    // ----------------------------------------------------------------
    // DEFAULT PARAMETERS

    // we can specify default params in Kotlin
    // what happens if we call this fun from Java?

    // by default, you can't call the function without optional parameters,
    // because only 1 version is generated by the compiler

    // once you add the @JvmOverloads to the function,
    // compiler will generate every other possible version of this function
    superCar.defaultArgs("Something");
    superCar.defaultArgs();
  }

}
