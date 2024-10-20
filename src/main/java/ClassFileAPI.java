import java.io.IOException;
import java.lang.classfile.ClassElement;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.MethodModel;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Second Preview Feature: Class File API
 * 
 * The Class File API standardizes the process of reading, parsing, and
 * transforming Java .class files. Additionally, it aims to eventually deprecate
 * the JDK’s internal copy of the third-party ASM library.
 * 
 * Histórico:
 * Algumas mudanças internas baseadas em feedback
 * Código não mudou - JDK 22
 * 
 */
public class ClassFileAPI {
  public static void main(String[] args) throws IOException {
    final String PREFIX = "test_";
    final Path PATH = Path.of("src/main/java/ClassFileExample.class");
    ClassFile cf = ClassFile.of();
    ClassModel classModel = cf.parse(PATH);
    byte[] newBytes = cf.build(classModel.thisClass().asSymbol(), classBuilder -> {
      for (ClassElement ce : classModel) {
        if (!(ce instanceof MethodModel mm && mm.methodName()
            .stringValue()
            .startsWith(PREFIX))) {
          classBuilder.with(ce);
        }
      }
    });
    Files.write(PATH, newBytes);
  }
}

class ClassFileExample {
  public void doSomething() {
    System.out.println("Do something here");
  }

  public void doSomething2() {
    System.out.println("Do something here as well");
  }

  public void test_something() {
    System.out.println("Test method");
  }

}
