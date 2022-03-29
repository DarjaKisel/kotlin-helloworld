package me.dzinevich;

import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Hello");
//    list.add(22); -> this will not compile because we told the compiler what type is in the collection
    list.get(0).toUpperCase(); // we cal call String methods because the compiler knows what type we have in the collection

    List list2 = new ArrayList<>();
    list2.add("Goodbye");
    //list2.get(0).toUpperCase(); --> doesnt work!

    // Java doesn't understand Generics!
    // they are just syntactically here for us and for the compiler |

//    boolean b = list instanceof List<String> - error -- (Illegal generic type for instanceof)
    boolean b = list instanceof List; // this will work
  }

}
