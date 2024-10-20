import java.util.List;
import java.util.stream.Gatherers;

/**
 * Second Preview Feature: Stream Gatherers
 * 
 * While the Stream API already supports operations like mapping, filtering, and
 * reduction, there were limitations when dealing with advanced use cases.
 * Stream Gatherers aim to address these gaps by providing custom intermediate
 * operations.
 * É possível inclusive criar novas operações intermediárias usando um
 * Initializer, Integrador, Combiner e Finisher (opcional)
 * 
 * Histórico:
 * Sem mudanças em relação a 22
 * Mesmo do JDK 22
 */
public class StreamGatherers {
  public static void main(String[] args) {
    // windowing
    var data = List.of("a", "b", "c", "d", "e");
    var chunks1 = data.stream().gather(Gatherers.windowSliding(2)).toList();
    var chunks2 = data.stream().gather(Gatherers.windowFixed(2)).toList();
    System.out.println(chunks1);
    System.out.println(chunks2);

    // folding e unfolding

    // barriers

    // prefix scans

    // handling duplicated elements
  }
}
