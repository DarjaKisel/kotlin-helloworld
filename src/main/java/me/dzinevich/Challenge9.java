package me.dzinevich;

import me.dzinevich._9_java_interoperability.Challenge;
import me.dzinevich._9_java_interoperability.EmployeeKotlin;
//import me.dzinevich._9_java_interoperability.KotlinChallenge;
import me.dzinevich._9_java_interoperability.Challenge9Kt;

public class Challenge9 {

  public static void main(String[] args) {
//    KotlinChallenge.seyHelloToJava("Student");
//    EmployeeKotlin employeeKt = new EmployeeKotlin("John", "Smith", 2017);
//    employeeKt.startYear = 2006;
//
//    Challenge.doMath(5, 4);
//
//    employeeKt.takesDefault("arg1");


    // --------------- now fix by changing ONLY the Java class -------------------


    Challenge9Kt.seyHelloToJava("Student");
    EmployeeKotlin employeeKt = new EmployeeKotlin("John", "Smith", 2017);
    employeeKt.setStartYear(2006);

    Challenge.INSTANCE.doMath(5, 4);

    employeeKt.takesDefault("arg1");

  }


  public static class Employee {

    private String firstName;
    private String lastName;
    private int startYear;
    private float[] salaryLast3Years;

    public Employee(String firstName, String lastName, int startYear) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.startYear = startYear;
      this.salaryLast3Years = new float[3];
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public int getStartYear() {
      return startYear;
    }

    public void setStartYear(int startYear) {
      this.startYear = startYear;
    }

    public float[] getSalaryLast3Years() {
      return salaryLast3Years;
    }

    public void setSalaryLast3Years(float[] salaryLast3Years) {
      this.salaryLast3Years = salaryLast3Years;
    }
  }
}
