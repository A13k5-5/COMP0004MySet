package uk.ac.ucl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayMySetToListTest
{
  private ArrayMySet<String> aSet;

  @BeforeEach
  public void setUp() throws MySetException
  {
    MySetFactory.getInstance().setClassName("ArrayMySet");
    aSet = new ArrayMySet<>();
  }

  @Test
  public void anEmptySetShouldReturnAnEmptyList()
  {
    List<String> aList = aSet.toList();
    assertEquals(0, aList.size());
  }

  @Test
  public void aSetOfSizeOneShouldReturnAListOfSizeOneContainingTheSameValue() throws MySetException
  {
     aSet.add("one");
     List<String> aList = aSet.toList();
     assertAll(
       "Incorrect list generated",
        () -> assertEquals(1, aList.size()),
        () -> assertTrue(aList.contains("one"))
     );
  }
}
