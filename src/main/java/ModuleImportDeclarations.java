import module java.base;

/**
 * Preview Feature: Module Import Declarations
 * 
 * This enhancement allows developers to import all the public top-level classes
 * and interfaces from an entire module with a single statement. Instead of
 * importing multiple packages individually, the import module M; syntax imports
 * everything that the module M exports.
 * 
 */
public class ModuleImportDeclarations {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Digite um número: ");
      var numero = scanner.nextInt();
      System.out.println(numero);
    }
  }

}
