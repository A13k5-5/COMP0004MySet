package uk.ac.ucl;


import java.util.List;

/**
 *  This interface defines the public methods that all set classes have.
 *  The interface is generic, parameterised over the type of the value stored in a set.
 *  As values must be comparable, the parameterised type T must be a subtype of Comparable, so
 *  that sets can only be created for values that can be compared using compareTo.
 *  The MySet interface extends iterable to allow sets to be iterated using the
 *  for each loop.
 */
public interface MySet<T extends Comparable<T>> extends Iterable<T>
{
  /**
   * The fixed maximum size of a set.
   */
  int MAX_SIZE = 1000;
  /**
   * The minimum size of a set. Any set must be able to hold at least one value.
   */
  int MIN_SIZE = 1;

  /**
   * Determine the size of the set, the numbers of values currently stored.
   * @return The size of the set.
   */
  int size();

  /**
   * Check if the set is empty.
   * @return True if the set is empty, false otherwise.
   */
  boolean isEmpty();

  /** Determine if the argument set has the same value (contents) as this set.
   *
   * @param aSet The set to compare with.
   * @return true if the sets contain the same values.
   */
  boolean equals(MySet<T> aSet);

  /**
   * Add a value to a set.
   * @param value The value to add.
   * @throws MySetException If the set is full.
   */
  void add(T value) throws MySetException;

  /**
   * Add a sequence of one or more values to a set.
   * @param values The values to add.
   * @throws MySetException If the set is full.
   */
  void addAll(T... values) throws MySetException;

  /**
   * Check if the set contains a value.
   * @param value The value to look for.
   * @return True if the set contains the value, false otherwise.
   */
  boolean contains(T value);

  /**
   * Remove a value from the set. Do nothing if the value is not in the set.
   * @param value The value to remove.
   */
  void remove(T value);

  /**
   * Generate the union of the set with another set. The union is a new set, leaving the
   * source sets unchanged.
   * @param mySet The set to form a union with.
   * @return A new set containing the union.
   * @throws MySetException If the resulting set is too big or cannot be created.
   */
  MySet<T> union(MySet<T> mySet) throws MySetException;

  /**
   * Generate the union of the set with another set. The union is a new set with the maximum
   * size given as a parameter, and the source sets are left unchanged.
   * @param mySet The set to form a union with.
   * @param maxSize The maximum size allowed for the result set.
   * @return A new set containing the union.
   * @throws MySetException If the resulting set is too big or cannot be created.
   */
  MySet<T> union(MySet<T> mySet, int maxSize) throws MySetException;

  /**
   * Generate the intersection of the set with another set. The intersection is a new set,
   * leaving the source sets unchanged.
   * @param mySet The set to form the intersection with.
   * @return A new set containing the intersection.
   * @throws MySetException If the resulting set cannot be created.
   */
  MySet<T> intersection(MySet<T> mySet) throws MySetException;

  /**
   * Generate the intersection of the set with another set. The union is a new set with the maximum
   * size given as a parameter, and the source sets are left unchanged.
   * @param mySet The set to form the intersection with.
   * @param maxSize The maximum size allowed for the result set.
   * @return A new set containing the intersection.
   * @throws MySetException If the resulting set cannot be created.
   */
  MySet<T> intersection(MySet<T> mySet, int maxSize) throws MySetException;

  /**
   * Generate the set difference of the set with another set (the set of
   * elements that are in the set but not in the other set). The difference
   * is a new set, leaving the source sets unchanged.
   * @param mySet The set to determine the difference with.
   * @return A new set containing the difference.
   * @throws MySetException If the resulting set cannot be created.

   */
  MySet<T> difference(MySet<T> mySet) throws MySetException;

  /**
   * Generate the set difference of the set with another set (the set of
   * elements that are in the set but not in the other set). The difference
   * is a new set with the maximum size as given in the parameter,
   * leaving the source sets unchanged.
   * @param mySet The set to determine the difference with.
   * @param maxSize The maximum size allowed for the result set.
   * @return A new set containing the difference.
   * @throws MySetException If the resulting set cannot be created.

   */
  MySet<T> difference(MySet<T> mySet, int maxSize) throws MySetException;

  /**
   * Create a List containing the set contents, with nested sets stored as nested lists.
   * @return A List (an ArrayList).
   */
  List<T> toList();
}
