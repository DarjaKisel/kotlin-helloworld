package me.dzinevich;

import org.jetbrains.annotations.NotNull;

public class Car {

  public static int x = 5;

  private String color;
  private String model;
  public int year;
  private Object anObject;

  public Car(String color, String model, int year) {
    this.color = color;
    this.model = model;
    this.year = year;
  }

  public void demoMethod(Runnable runnable) {
    // runnable only has one method run() ----> SAM interface
//    new Thread(() -> System.out.println("THis is in a Thread!!! :)")).start();
    new Thread(runnable).start();
  }

  public static String xString() {
    return "This is x:" + x++;
  }

//  public @NotNull String getColor() {
    public String getColor() {
    return color;
  }

  public void setColor(@NotNull String color) {
    this.color = color;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

//  public int getYear() {
//    return year;
//  }
//
//  public void setYear(int year) {
//    this.year = year;
//  }

  public void variableMethod(int num, String... strings) {
    for (String s : strings) {
      System.out.println(s);
    }
  }

  public void wantAnArray(int[] arr) {
    for(int i : arr) {
      System.out.println("Here is the int!" + i);
    }
  }

  public Object getAnObject() {
    return anObject;
  }

  public void setAnObject(Object anObject) {
    this.anObject = anObject;
  }

  @Override
  public String toString() {
    return "Car{" +
        "color='" + color + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        '}';
  }
}
