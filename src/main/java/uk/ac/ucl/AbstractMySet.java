package uk.ac.ucl;

import java.util.List;
import java.util.ArrayList;

/**
 * This class implements methods common to all concrete set implementations but does not
 * represent a complete set implementation.<br />
 *
 * New set objects are created using a MySetFactory.
 */

public abstract class AbstractMySet<T extends Comparable<T>> implements MySet<T>
{
  @Override
  public boolean equals(MySet<T> aSet)
  {
    if (this.size() != aSet.size()) return false;
    for (T t : this) {
      if (!aSet.contains(t)) return false;
    }
    return true;
  }

  @Override
  public int hashCode()
  {
    return toList().hashCode();
  }

  public List<T> toList()
  {
    List<T> result = new ArrayList<>();
    for (T value : this)
    {
      result.add(value);
    }
    return result;
  }

  public void addAll(T... values) throws MySetException
  {
    for (T value : values)
    {
      add(value);
    }
  }

  public MySet<T> union(MySet<T> mySet) throws MySetException
  {
    return this.union(mySet, MAX_SIZE);
  }

  public MySet<T> union(MySet<T> mySet, int maxSize) throws MySetException
  {
    MySet<T> result = MySetFactory.getInstance().getMySet(maxSize);
    for (T value : this) result.add(value);
    for (T value : mySet) result.add(value);
    return result;
  }

  public MySet<T> intersection(MySet<T> mySet) throws MySetException
  {
    return intersection(mySet, MySet.MAX_SIZE);
  }

  public MySet<T> intersection(MySet<T> mySet, int maxSize) throws MySetException
  {
    MySet<T> result = MySetFactory.getInstance().getMySet(maxSize);
    for(T value : this)
    {
      if (mySet.contains(value))
      {
        result.add(value);
      }
    }
    return result;
  }

  public MySet<T> difference(MySet<T> mySet) throws MySetException
  {
    return difference(mySet, MySet.MAX_SIZE);
  }

  public MySet<T> difference(MySet<T> mySet, int maxSize) throws MySetException
  {
    MySet<T> result = MySetFactory.getInstance().getMySet(maxSize);
    for (T value : this)
    {
      if (!mySet.contains(value))
      {
        result.add(value);
      }
    }

    return result;
  }

  protected void checkSize(int maximumSize)
    throws MySetException
  {
     if ((maximumSize > MAX_SIZE) || maximumSize < 1)
     {
       throw new MySetException("Trying to create a set with size greater than maximum allowed.");
     }
  }
}
