package uk.ac.ucl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayMySetIntersectionTest
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
  public void anIntersectionOfEmptySetsShouldGiveAnEmptySet() throws MySetException
  {
    assertTrue(aSet1.intersection(aSet2).isEmpty());
  }

  @Test
  public void anIntersectionOfTwoNonOverlappingSetsShouldGiveAnEmptySet() throws MySetException
  {
    aSet1.add("one");
    aSet2.add("two");
    assertTrue(aSet1.intersection(aSet2).isEmpty());
  }

  @Test
  public void anIntersectionOfTwoOverlappingSetsShouldGiveASetContainingTheCommonValues() throws MySetException
  {
    aSet1.add("one");
    aSet1.add("two");
    aSet2.add("two");
    aSet2.add("three");
    MySet<String> result = aSet1.intersection(aSet2);
    assertAll(
      "Incorrect intersection",
      () -> assertEquals(1, result.size()),
      () -> assertTrue(result.contains("two"))
    );
  }

  @Test
  public void anIntersectionThatExceedsTheMaximumAllowedSetSizeShouldThrowAnException() throws MySetException
  {
    aSet1.add("one");
    aSet1.add("two");
    aSet2.add("one");
    aSet2.add("two");
    assertThrows(
      MySetException.class,
      () -> { aSet1.intersection(aSet2, 1); }
    );
  }
}
