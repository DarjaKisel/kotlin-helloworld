package me.dzinevich;

import me.dzinevich._9_java_interoperability.StaticCar;
import me.dzinevich._9_java_interoperability.SuperCar;

public class CallKotlin {

  public static void main(String[] args) {

    // extension Kt is automatically included in the class name
    // CallingKotlinKt.topLevel();
    StaticCar.topLevel();

    // you can change the static class name that compiler is generating
    // using JVM @Name annotation @file:JvmName("StaticCar")

    // calling an extension function
    StaticCar.print("printing String from Java");

    // access Class members, fields and methods
    SuperCar car = new SuperCar("red", "ferrari", 1986, true);
    System.out.println(car.model);
    //car.setModel(); --- no setter as it is val

    // use custom setter
    car.setColor("purple");
    System.out.println(car.getColor());

    car.isAuto(); // method with bool is called ISauto not GETauto
    car.setAuto(false); // method with bool is called ISauto not GETauto

    // if you want java code to be able to access fields Directly without Getters and setters
    // use Annotation @JvmField,
    // but you will have NO Getter after that!!
    // you can;t use it with private property, override property, or a constant property
    String model = car.model;
  }
}
