/**
 * Third Preview Feature: Implicit Declared Classes Instance Methods
 * 
 * Histórico: 2 mudanças
 * 
 * - Implicitly declared classes automatically import three static methods for
 * simple textual I/O with the console. These methods are declared in the new
 * top-level class
 * https://cr.openjdk.org/~prappo/8305457/java.base/java/io/IO.html.
 * - Implicitly declared classes automatically import, on demand, all of the
 * public top-level classes and interfaces of the packages exported by the
 * java.base module.
 * 
 */
void main() {
  try (Scanner scanner = new Scanner(System.in)) {
    System.out.println("Digite um número: ");
    var numero = scanner.nextInt();
    System.out.println(numero);
  }
}
