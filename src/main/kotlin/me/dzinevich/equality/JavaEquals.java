package me.dzinevich.equality;

public class JavaEquals {

  public static void main(String[] args) {
    JavaEmployee em1 = new JavaEmployee("Alex", 1);
    JavaEmployee em2 = new JavaEmployee("Josh", 2);
    JavaEmployee em3 = new JavaEmployee("Josh", 2);

    System.out.println(em1 == em2); // reference equality
    System.out.println(em2 == em3);
    System.out.println(em1.equals(em2)); // structural equality
    System.out.println(em2.equals(em3));

    System.out.println("Expected false, false, false, true");
  }
}
