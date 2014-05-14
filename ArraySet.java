/**Jordan Buttkevitz
 * University of Pittsburgh
 * Data Structures
 * Project: ADT SET
 **/
public class ArraySet<T> implements SetInterface<T> {
    private T[] setBag;
    private static final int DEFAULT_CAPACITY = 10;
    private int numOfEntries;
 
    public ArraySet() {
        this(DEFAULT_CAPACITY); 
    }
    public ArraySet(int aCapacity) {
      numOfEntries = 0; 
      setBag =  (T[])new Object[aCapacity];
     }

    private boolean isFull() {
        return numOfEntries == setBag.length;
    }
   
    @Override
    public void insert(T anElement) {
        if (in(anElement)) {
            return;
        }
        if (isFull()) {
            resize();
        }
        setBag[numOfEntries] = anElement;
        numOfEntries++;
    }

    private void insertAll(T[] elements) {
        for (int i = 0; i < elements.length; i++) {
            insert(elements[i]);
        }
    }
 
    private void resize() {
        T[] newSetBag = (T[])new Object[setBag.length * 2];
        for (int i = 0; i < setBag.length; i++) {
            newSetBag[i] = setBag[i];
        }
        setBag = newSetBag;
    }

    @Override
    public T[] toArray() {
        T[] tmpSetBag = (T[])new Object[numOfEntries]; 
        for (int i = 0; i < numOfEntries; i++) {
           tmpSetBag[i]  = setBag[i];
        }
        return tmpSetBag;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        return setBag[--numOfEntries];
    }

    @Override
    public int getCurrentSize() {
        return numOfEntries;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numOfEntries; i++) {    
             if(i == numOfEntries - 1 ) {
                result.append(String.valueOf(setBag[i]));  
             } else {
                result.append(String.valueOf(setBag[i])).append(",");
             }
        }  
        return "{".concat(result.toString()).concat("}");
    }

    @Override
    public boolean isEmpty() {
        return numOfEntries == 0;
    }

    @Override
    public boolean in(T anElement) {   
        for (int i = 0; i < numOfEntries; i++) {
            if ( anElement == setBag[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArraySet<T> intersect(SetInterface<T> rhsSet) {
        ArraySet<T> intersectSet = new ArraySet<T>(); 
        for(int i = 0; i < numOfEntries; i++) {
            if (rhsSet.in(setBag[i])) {
                intersectSet.insert(setBag[i]);
            }
        }
        return intersectSet;
    }
	
    @Override	
    public ArraySet<T> union(SetInterface<T> rhsSet) {
        ArraySet<T> unionSet = new ArraySet<T>();
        unionSet.insertAll(toArray());
        unionSet.insertAll(rhsSet.toArray());
        return unionSet;
    }
	
    @Override
    public ArraySet<T> diff(SetInterface<T> rhsSet) {
        ArraySet<T> diffSet = new ArraySet<T>();
        for (int i = 0; i < numOfEntries; i++) {
            if(!rhsSet.in(setBag[i])) {
                diffSet.insert(setBag[i]);
            }
        }
        return diffSet;
    }

    @Override
    public boolean subsetOf(SetInterface<T> rhsSet) {
        for (int i = 0; i < numOfEntries; i++) {
            if (!rhsSet.in(setBag[i])) {
                return false;
            }
        }
        return true;
    }
    public boolean equals(Object otherObject) {
        ArraySet<T> arraySetObject = new ArraySet<T>();
        arraySetObject = (ArraySet)otherObject;
        if (arraySetObject.getCurrentSize() != this.getCurrentSize()){
            return false;
        } 
        for (int i = 0; i < numOfEntries; i++) {
            if (!arraySetObject.in(this.setBag[i])) {
                return false;
            }
        }
        return true;


    } 
} //EOF
