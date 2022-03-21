package me.dzinevich;

public class DummyClass {
  public String isVacationTime(boolean onVac) {
    return onVac ? "I am on Vacation" : "I am working";
  }

  public void printNumbers(int[] nums) {
    for (int num : nums) {
      System.out.println(num);
    }
  }
}
