package uk.ac.ucl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayMySetUnionTest
{
  private ArrayMySet<String> aSet1;
  private ArrayMySet<String> aSet2;

  @BeforeEach
  public void setUp() throws MySetException
  {
    aSet1 = new ArrayMySet<>();
    aSet2 = new ArrayMySet<>();
    MySetFactory.getInstance().setClassName("ArrayMySet");
  }

  @Test
  public void aUnionOfEmptySetsShouldGiveAnEmptySet() throws MySetException
  {
    assertTrue(aSet1.union(aSet2).isEmpty());
  }

  @Test
  public void aUnionOfTwoNonOverlappingSetsShouldGiveASetContainingAllValues() throws MySetException
  {
    aSet1.add("one");
    aSet2.add("two");
    MySet<String> result = aSet1.union(aSet2);
    assertAll(
        "Incorrect union",
        () -> assertEquals(2, result.size()),
        () -> assertTrue(result.contains("one")),
        () -> assertTrue(result.contains("two"))
    );
  }

  @Test
  public void aUnionOfTwoOverlappingSetsShouldGiveASetContainingAllDistinctValues() throws MySetException
  {
    aSet1.add("one");
    aSet1.add("two");
    aSet2.add("two");
    aSet2.add("three");
    MySet<String> result = aSet1.union(aSet2);
    assertAll(
        "Incorrect union",
        () -> assertEquals(3, result.size()),
        () -> assertTrue(result.contains("one")),
        () -> assertTrue(result.contains("two")),
        () -> assertTrue(result.contains("three"))
    );
  }

  @Test
  public void aUnionThatExceedsTheMaximumAllowedSetSizeShouldThrowAnException() throws MySetException
  {
    aSet1.add("one");
    aSet1.add("two");
    aSet2.add("three");
    aSet2.add("four");
    assertThrows(
      MySetException.class,
      () -> { aSet1.union(aSet2, 3); }
    );
  }
}
