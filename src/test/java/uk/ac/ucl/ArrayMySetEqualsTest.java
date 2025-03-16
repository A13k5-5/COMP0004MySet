package uk.ac.ucl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayMySetEqualsTest
{
  private ArrayMySet<String> set1;
  private ArrayMySet<String> set2;

  @BeforeEach
  public void setUp() throws MySetException
  {
    set1 = new ArrayMySet<>();
    set2 = new ArrayMySet<>();
  }

  @Test
  public void emptySetsShouldBeEqual()
  {
    assertTrue(set1.equals(set2));
  }

  @Test
  public void twoSetsWithSameValuesShouldBeEqual() throws MySetException
  {
    set1.add("one");
    set2.add("one");
    assertTrue(set1.equals(set2));
  }

  @Test
  public void twoSetsWithDifferentValuesShouldNotBeEqual() throws MySetException
  {
    set1.add("one");
    set2.add("two");
    assertFalse(set1.equals(set2));
  }

  @Test
  public void emptySetShouldNotBeEqualToNonEmptySet() throws MySetException
  {
    set1.add("one");
    assertFalse(set1.equals(set2));
  }
}
