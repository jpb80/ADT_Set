/**Jordan Buttkevitz
 * University of Pittsburgh
 * Data Structures
 * Project: ADT Set
 **/
public interface SetInterface<T>
{
/**
* Adds a new entry into this set.
* @param anElement the object to be added as a new element.
*/
public void insert(T anElement);
/**
* Removes unspecified element from this set, if possible
* @return either the removed entry, if the removal was successful
* or null.
*/
public T remove();
/**
* Gets the current number of elements in this set.
* @return the integer number of entries currently in the set.
*/
public int getCurrentSize();
/**
* Sees whether this set is an empty set.
* @return true if the set is an empty set, or false if not.
*/
public boolean isEmpty();
/**
* Returns a String in the format of set representation of this set.
* (e.g., "{1, 2, 3}", "{"Dog", "Cat", "Fish"}, etc.)
* @return a String representing this set.
*/
public String toString();
/**
* See whether anElement is in this set.
* @param anElement the element to be searched.
* @return true if anElement is in this set, false otherwise.
*/
public boolean in(T anElement);
/**
* Perform intersect operation between this set and the rhsSet.
* @param rhsSet the set to be intersected with.
* @return a new set which is the result of this set intersects with
* rhsSet.
*/
public SetInterface<T> intersect(SetInterface<T> rhsSet);
/**
* Perform union operation between this set and the rhsSet.
* @param rhsSet the set to be unioned with.
* @return a new set which is the result of this set unions with
* rhsSet.
*/
public SetInterface<T> union(SetInterface<T> rhsSet);
/**
* Perform diff operation between this set and the rhsSet.
* @param rhsSet the set to be diffed with.
* @return a new set which is the result of this set diffs with
* rhsSet.
*/
public SetInterface<T> diff(SetInterface<T> rhsSet);
/**
* See whether this set is a subset of rhsSet.
* @param rhsSet an input set.
* @return true if this set is a subset of rhsSet, false otherwise.
*/
public boolean subsetOf(SetInterface<T> rhsSet);
/**
* See whether this set is equal to the set otherObject.
* Note that this method overrides the method equals of the class
* Object.
* @param otherObject an input set.
* @return true if this set is equal the set otherObject.
*/
public boolean equals(Object otherObject);
/**
* Creates an array of all elements that are in this set.
* @return a newly allocated array of all the entries in this set.
*/
public T[] toArray();
}
