package assertjPractice;

import static org.assertj.core.api.Assertions.assertThat;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

@HelidonTest
public class AssertIterables {

  @Test
  void testList() {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("Sudheerp");
    arrayList.add("Sudheerp");
    arrayList.add("Manojap");
    arrayList.add("Venkatp");
    arrayList.add("Sudheerp");

    assertThat(arrayList).contains("Sudheerp"); // Should contain the list of values mentioned.
    assertThat(arrayList)
        .containsOnly(
            "Sudheerp",
            "Sudheerp",
            "Venkatp",
            "Manojap"); // The arraylist/collection should only contain the values mentioned in the
    // method in any order and nothings else,the imp point is the duplicates are
    // ignored(i.e if the value is found the fuplicates are also found)
    assertThat(arrayList)
        .containsExactly(
            "Sudheerp",
            "Sudheerp",
            "Manojap",
            "Venkatp",
            "Sudheerp"); // The arrayList/Collection should exactly contain the values mentiioned in
    // the method in the same order and the duplicates are not ignored
    // The other assertion methods are 1.containsExactlyInAnyOrder 2.containsSequence
    // 3.containsSubSequence 4.containsOnlyOnce 5.containsAnyOf

    // All the elements of the collection should satify the given assertions
    assertThat(arrayList)
        .allSatisfy(
            d -> {
              assertThat(d).isNotNull();
              assertThat(d).isNotEmpty();
            });

    // Atleast one of the elements of the collection should satisfy the given assertions
    assertThat(arrayList)
        .anySatisfy(
            d -> {
              assertThat(d).endsWith("ikap");
              assertThat(d).startsWith("Mou");
            });

    // None of the elements of collection should satisfy the given assertions
    assertThat(arrayList)
        .noneSatisfy(
            d -> {
              assertThat(d).startsWith("Nag");
            });

    assertThat(arrayList).allMatch(d -> d.endsWith("p"), "All should end with p");
    assertThat(arrayList).anyMatch(d -> d.startsWith("Sud"));
    assertThat(arrayList).noneMatch(d -> d.startsWith("Nag"));
  }
}
