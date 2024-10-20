/**
 * Preview Feature: Primitive Types Patterns in instanceof and switch
 * 
 * Enhance pattern matching by allowing primitive type patterns in all pattern
 * contexts, and extend instanceof and switch to work with all primitive types.
 */
public class PrimitiveTypesPatternsInstanceOfSwitch {
  public static void main(String[] args) {
    // Pattern
    float value = 1f; // 10000000000000000f;
    System.out.println(value instanceof float);
    System.out.println(value instanceof int);

    // Instanceof
    if (value instanceof int intValue)
      System.out.println(intValue);

    // Switch
    switch (value) {
      case float floatValue when floatValue == 1f ->
        System.out.println("float 1: " + floatValue);
      case int intValue -> System.out.println("int: " + intValue);
      default -> System.out.println("n/a");
    }

  }
}
