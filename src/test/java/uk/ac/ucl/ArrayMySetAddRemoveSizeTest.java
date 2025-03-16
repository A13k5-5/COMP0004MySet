package uk.ac.ucl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMySetAddRemoveSizeTest
{
  private ArrayMySet<Integer> aSet;

  @BeforeEach
  public void setUp() throws MySetException
  {
    aSet = new ArrayMySet<>(2);
  }

  @Test
  void aNewSetShouldBeEmpty()
  {
    assertTrue(aSet.isEmpty());
  }

  @Test
  public void aNewSetShouldHaveSizeZero()
  {
    assertEquals(0, aSet.size());
  }

  @Test
  public void aSetWithOneValueShouldHaveSizeOne() throws MySetException
  {
    aSet.add(1);
    assertEquals(1, aSet.size());
  }

  @Test
  public void aSetShouldContainAValueAfterItIsAdded() throws MySetException
  {
    aSet.add(1);
    assertTrue(aSet.contains(1));
  }

  @Test
  public void aSetShouldContainAllTheValuesAfterAddAll() throws MySetException
  {
    aSet.addAll(1, 2);
    assertAll(
      "addAll missng values",
      () -> assertTrue(aSet.contains(1)),
      () -> assertTrue(aSet.contains(2))
    );
  }

  @Test
  public void removingTheLastValueShouldLeaveAnEmptySet() throws MySetException
  {
    aSet.add(1);
    aSet.remove(1);
    assertTrue(aSet.isEmpty());
    assertFalse(aSet.contains(1));
  }

  @Test
  public void removingAValueShouldReduceTheSizeByOne() throws MySetException
  {
    aSet.add(1);
    aSet.add(2);
    assertEquals(2, aSet.size());
    aSet.remove(1);
    assertEquals(1, aSet.size());
  }

  @Test
  public void removingAValueNotInTheSetShouldNotChangeTheSet() throws MySetException
  {
    aSet.add(1);
    aSet.remove(2);
    assertEquals(1, aSet.size());
    assertTrue(aSet.contains(1));
  }

  @Test
  public void addingToAFullSetShouldThrowAnException() throws MySetException
  {
    aSet.add(1);
    aSet.add(2);
    assertThrows(
      MySetException.class,
      () -> { aSet.add(3); }
    );
  }

}