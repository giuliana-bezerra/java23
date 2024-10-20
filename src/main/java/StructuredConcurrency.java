import java.util.concurrent.StructuredTaskScope;

/**
 * Third Preview Feature: Implicit Declared Classes Instance Methods
 * 
 * JEP 462 (JDK 21) introduces Structured Concurrency as a way to simplify
 * handling
 * multiple concurrent tasks in Java. The concept ensures that when a task
 * creates subtasks, these subtasks are managed as a group, making concurrency
 * easier to reason about, monitor, and manage. Structured concurrency organizes
 * tasks so that they all start and finish within a defined scope, which makes
 * error handling, cancellations, and resource cleanup more predictable and
 * easier to handle.
 * 
 * Histórico:
 * - Sem mudanças, igual ao JDK 22
 * 
 */
public class StructuredConcurrency {
  public static void main(String[] args) throws InterruptedException {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      StructuredTaskScope.Subtask<String> task1 = scope.fork(() -> task1());
      StructuredTaskScope.Subtask<String> task2 = scope.fork(() -> task2());

      scope.join();
      scope.throwIfFailed(e -> new RuntimeException("Error!"));

      System.out.printf("%s, %s", task1.get(), task2.get());
    }
  }

  public static String task1() {
    return "Task 1";
  }

  public static String task2() {
    // if (true)
    // throw new RuntimeException("Teste");
    return "Task 2";

  }
}
