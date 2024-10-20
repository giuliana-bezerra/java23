/**
 * Second Preview Feature: Flexible Constructor Bodies
 * 
 * Proposto no Java 22 como Statements before super() - preview
 * 
 * Histórico: Outro nome, uma mudança
 * - Allow a constructor body to
 * https://openjdk.org/jeps/482#Early-assignment-to-fields before explicitly
 * invoking a constructor. This enables a constructor in a subclass to ensure
 * that a constructor in a superclass never executes code which sees the
 * https://docs.oracle.com/javase/specs/jls/se22/html/jls-4.html#jls-4.12.5-100-A
 * of a field in the subclass (e.g., 0, false, or null). This can occur when,
 * due to overriding, the superclass constructor invokes a method in the
 * subclass that uses the field.
 */
public class FlexibleConstructorBodies {
  public static void main(String[] args) {
    new Sub(42);
  }
}

class Super {
  Super() {
    overriddenMethod();
  }

  void overriddenMethod() {
    System.out.println("hello");
  }
}

class Sub extends Super {
  final int x;

  Sub(int x) {
    this.x = x; // Initialize the field
    super(); // Then invoke the Super constructor explicitly
  }

  @Override
  void overriddenMethod() {
    System.out.println(x);
  }
}