package uz.pdp;

import java.util.Arrays;

public class DynamicArray {
    //initial capacity is start capacity of an array
    private int initialCapacity;
    //An array created with Object type because OUR array has to take all data types!!!
    Object[] object;
    //size we will be using it for decreasing and increasing the length of an array
    private int size = 0;

    // a default constructor
    public DynamicArray() {
        initialCapacity = 10;
        object = new Object[initialCapacity];
    }
    // a constructor with a parament

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        object = new Object[initialCapacity];
    }

    /**
     * By this method we can set an element to array
     *
     * @param newElement
     */
    public void add(Object newElement) {
        if (size == object.length) {
            doublingArray();
        }
        object[size] = newElement;
        size++;
    }

    /**
     * This is overload version of add method, but we can put element to index (which is given)
     *
     * @param newElement is element which we will set to array
     * @param index      is index which tells where should an element be placed
     */
    public void add(Object newElement, int index) {
        if (size == object.length) {
            doublingArray();
        }
        if (index >= size) {
            object[size] = newElement;
        } else {
            for (int i = size - 1; i >= index; i--) {
                //to shift value
                object[i + 1] = object[i];
            }
            object[index] = newElement;
        }
        size++;
    }

    //get size
    public int size() {
        return size;
    }

    /**
     * this method will remove|delete an element from array
     *
     * @param index is index which will be deleted
     * @return returns true if process is done else returns false if conditions do not match
     */
    public boolean remove(int index) {
        if (index > -1 && index < size) {
            for (int i = index; i < size; i++) {
                object[i] = object[i + 1];
            }
            size--;
            if (size < object.length / 2) {
                doubleShortening();
            }
            return true;
        }
        return false;
    }

    // returns true if array is empty else returns false
    public boolean isEmpty() {
        return size == 0;
    }

    //checks and returns true if array contains given element else returns false
    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if (object[i].equals(element))
                return true;
        }
        return false;
    }

    // clears array and equals to new array which its length = initialCapacity
    public void clear() {
        object = new Object[initialCapacity];
        size = 0;
    }

    // gets and returns object in given position if index is out of bound then method throws excaption
    public Object get(int index) {
        if (index > size) {
            System.err.println("Index is out of array's bound");
            return null;
        }
        return object[index];
    }
    // sets and a new element to array if index is in array's bound else return null and throes excaption
    public Object set(Object newElement, int index) {
        if (index > size) {
            System.err.println("Index is out of array's bound");
            return null;
        }
        Object res = object[index];
        object[index] = newElement;
        return res;
    }
    // returns index of given element
    public int indexOf(Object element){
        for (int i = 0; i < size; i++) {
            if (object[i].equals(element))
                return i;
        }
        return -1;
    }
    // loops from last index of array if it matches return index else -1
    public int lastIndexOf(Object element){
        for (int i=size-1;i>=0;i--) {
            if (object[i].equals(element))
                return i;
        }
        return -1;
    }
    // doubles size of array's length
    private void doublingArray(){
        Object [] temp= Arrays.copyOf(object,size);
        object=new Object[size*2];
        System.arraycopy(temp,0,object,0,temp.length);
    }
    // shorts array's length double times
    private  void  doubleShortening(){
        Object [] temp= Arrays.copyOf(object,size);
        object=new Object[size/2];
        System.arraycopy(temp,0,object,0,temp.length);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(object[i]);
            result.append(", ");
        }
        result.append("\b\b");

        result.append(']');
        return result.toString();
    }
}
