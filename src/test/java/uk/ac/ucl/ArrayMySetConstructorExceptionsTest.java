package uk.ac.ucl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayMySetConstructorExceptionsTest
{
  @Test
  public void creatingSetWithSizeLargerThanMaximumShouldThrowException()
  {
    assertThrows(
      MySetException.class,
        () -> { new ArrayMySet(MySet.MAX_SIZE + 1); }
    );
  }

  @Test
  public void creatingSetWithSizeLessThanOneShouldThrowException()
  {
    assertThrows(
        MySetException.class,
        () -> { new ArrayMySet(MySet.MIN_SIZE - 1); }
    );
  }

  @Test
  public void creatingSetWithNegativeSizeShouldThrowException()
  {
    assertThrows(
        MySetException.class,
        () -> { new ArrayMySet(-1); }
    );
  }
}
