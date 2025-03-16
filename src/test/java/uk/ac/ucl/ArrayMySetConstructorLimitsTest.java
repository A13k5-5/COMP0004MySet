package uk.ac.ucl;

import org.junit.jupiter.api.Test;

public class ArrayMySetConstructorLimitsTest
{
  @Test
  public void minimumSizeOfOneShouldBeValid() throws MySetException
  {
     new ArrayMySet<String>(MySet.MIN_SIZE);
  }

  @Test
  public void maximumSizeShouldBeValid() throws MySetException
  {
    new ArrayMySet<String>(MySet.MAX_SIZE);
  }
}
