/**
 * Third Preview Feature: Scoped Values
 * 
 * JEP 464 (JDK 21) introduces Scoped Values, a feature aimed at enhancing how
 * values are
 * shared between threads, particularly useful for handling concurrency. Unlike
 * ThreadLocal variables, which are mutable and can lead to complexities like
 * memory leaks, scoped values offer immutable state sharing. They allow values
 * to be shared within a bounded execution scope, ensuring that they are only
 * accessible during specific parts of a program's execution.
 * 
 * Histórico: Uma mudança
 * - The type of the operation parameter of the
 * https://cr.openjdk.org/~alanb/sv-20240517/java.base/java/lang/ScopedValue.html#callWhere(java.lang.ScopedValue,T,java.lang.ScopedValue.CallableOpmethod
 * is now a new functional interface which allows the Java compiler to infer
 * whether a checked exception might be thrown. With this change, the
 * https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/ScopedValue.html#getWhere(java.lang.ScopedValue,T,java.util.function.Supplier
 * method is no longer needed and is removed.
 * 
 */
public class ScopedValues {
  // Declarando o Scoped Value
  private static final ScopedValue<String> USERNAME = ScopedValue.newInstance();

  public static void main(String[] args) throws Exception {
    // ScopedValue.callWhere now uses a functional interface that supports checked
    // exceptions
    ScopedValue.callWhere(USERNAME, "Giuliana", () -> {
      System.out.println("Inside scope: " + getUsername());
      riskyOperation(); // This method might throw a checked exception
      return null; // Returning null since we're using Void
    });
    System.out.println("Outside scope: " + getUsername());
  }

  private static void riskyOperation() throws Exception {
    System.out.println("Inside riskyOperation: " + getUsername());
    throw new Exception("Something went wrong!");
  }

  private static String getUsername() {
    return USERNAME.get();
  }
}
