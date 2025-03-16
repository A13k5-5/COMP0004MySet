package uk.ac.ucl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayMySetDifferenceTest
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
  public void theDifferenceOfEmptySetsShouldGiveAnEmptySet() throws MySetException
  {
    assertTrue(aSet1.difference(aSet2).isEmpty());
  }

  @Test
  public void theDifferenceOfTwoSetsShouldBeASetContainingTheValuesInTheFirstSetButNotInTheSecondSet()
    throws MySetException
  {
    aSet1.add("one");
    aSet1.add("two");
    aSet2.add("two");
    aSet2.add("three");
    MySet<String> result = aSet1.difference(aSet2);
    assertAll(
      "Incorrect set difference",
      () -> { assertEquals(1, result.size()); },
      () -> { assertTrue(result.contains("one")); }
    );
  }

  @Test
  public void theDifferenceOfTwoNonOverlappingSetsShouldBeEqualToTheFirstSet() throws MySetException
  {
    aSet1.add("one");
    aSet1.add("two");
    aSet2.add("three");
    aSet2.add("four");
    MySet<String> result = aSet1.difference(aSet2);
    assertAll(
      "Incorrect set difference",
      () -> { assertEquals(2, result.size()); },
      () -> { assertTrue(result.contains("one")); },
      () -> { assertTrue(result.contains("two")); }
    );
  }

  @Test
  public void aDifferenceThatExceedsTheMaximumAllowedSetSizeShouldThrowAnException() throws MySetException
  {
    aSet1.add("one");
    aSet1.add("two");
    aSet2.add("three");
    aSet2.add("four");
    assertThrows(
      MySetException.class,
      () -> { aSet1.difference(aSet2, 1); }
    );
  }
}
