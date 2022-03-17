package me.dzinevich.equality;

public class JavaEmployee {

  private String name;
  private int id;

  public JavaEmployee(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public boolean equals(Object obj) {

    if (obj == null) {
      return false;
    }

    if (obj == this) {
      return true;
    }

    if (obj instanceof JavaEmployee) {
      return name.equals(((JavaEmployee) obj).name) && id == ((JavaEmployee) obj).id;
    }

    return false;
  }
}
