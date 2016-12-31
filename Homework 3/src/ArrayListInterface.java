
import java.util.*;

public class ArrayListInterface implements ListInterface {

    private Object[] objectArray;
    private int size = 0;
    private int currentObject = 0;

    /*
	 *  @return	Returns <b>true</b> if the list is empty, otherwise it returns <b>false</b>. 
	 * @see ListInterface#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        boolean length = false;
        if (size() == 0) {
            length = true;
        }
        return length;
    }

    /*
	 * @return Returns an integer of the size of the array.
	 * @see ListInterface#size()
     */
    @Override
    public int size() {
        return size;
    }

    /*
	 * @param this methods adds a given object to the end of the list.
	 * @see ListInterface#add(java.lang.Object)
     */
    @Override
    public void add(Object obj) {
        if (isEmpty() == true) {
            objectArray = new Object[1];//makes an array of size 1.
            objectArray[0] = obj;//adds the object to the first and only index.
            size++;//sets the size of the array to 1.
        } else {
            Object[] otherArray = new Object[size() + 1];// makes a different array one size bigger then the original array.
            for (int i = 0; i < size(); i++) {
                otherArray[i] = objectArray[i];//copies all index.
            }
            otherArray[size()] = obj;//at last index the object is inserted.
            size++;//increase array size by 1.
            objectArray = otherArray.clone();//copies the temporary array back to the original array.
        }
    }

    /*
	 * @return Returns true if the object is added returns false other wise.
	 * @see ListInterface#add(java.lang.Object, int)
     */
    @Override
    public boolean add(Object obj, int index) {
        boolean add = false;
        if (isEmpty() == true) {
            objectArray = new Object[1];
            objectArray[0] = obj;
            size++;
            add = true;
        } else {
            List<Object> otherArray = new ArrayList<Object>(Arrays.asList(objectArray));// puts the array in a list.
            otherArray.add(index, obj);// adds the given object at the specified index.
            objectArray = otherArray.toArray();//makes list back into array.
            size++;
            add = true;
        }
        return add;
    }

    /*
	 * @param adds an object to the array and is sorted.
	 * @return Returns the array sorted.
	 * @see ListInterface#addSorted(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void addSorted(Object obj) {
        if (isEmpty() == true) {
            objectArray = new Object[1];
            objectArray[0] = obj;
            size++;
        } else {
            @SuppressWarnings("rawtypes")// was trying to get rid of the warning i changed the rawtype but collection stopped working.
            List otherArray = new ArrayList(Arrays.asList(objectArray));
            otherArray.add(obj);
            Collections.sort(otherArray);// sorts the list for me.
            objectArray = otherArray.toArray();
            size++;
        }
    }

    /*
	 * @return Return the object at the specific index. 
	 * @see ListInterface#getObject(int)
     */
    @Override
    public Object getObject(int index) {
        Object objectIndex;
        if (index < 0 || index > size())// if index is out of bound.
        {
            objectIndex = null;
        } else {
            objectIndex = objectArray[index];
        }
        return objectIndex;
    }

    /*
	 * @param starts a counter to allow looping through the loop to peek at objects.
	 * @return Return the first object in the array.
	 * @see ListInterface#getFirstObject()
     */
    @Override
    public Object getFirstObject() {
        Object firstObject = null;
        if (size() > 0) {
            firstObject = objectArray[0];
            currentObject = 1;// sets the counter to 1 for later use.
        }
        return firstObject;
    }

    /*
	 * @param getFirstObject() needs to be ran first in order for this method to work.
	 * @return Return the current object.
	 * @see ListInterface#getNextObject()
     */
    @Override
    public Object getNextObject() {
        Object nextObject;
        if (currentObject < 1) {
            nextObject = null;
        } else {
            nextObject = objectArray[currentObject];
            currentObject++;
        }
        return nextObject;
    }

    /*
	 * @return Returns true if the object was deleted, else false.
	 * @see ListInterface#remove(int)
     */
    @Override
    public boolean remove(int index) {
        boolean remove;
        if (index < 0 || index > size()) {
            remove = false;
        } else {
            List<Object> otherArray = new ArrayList<Object>(Arrays.asList(objectArray));
            otherArray.remove(index);// uses remove from list class and resizes for me.
            objectArray = otherArray.toArray();
            size--;
            remove = true;
        }
        return remove;
    }

    /*
	 * @param resets the entire array and set the size variable back to 0 for resizing the array.
	 * @see ListInterface#removeAll()
     */
    @Override
    public void removeAll() {
        objectArray = new Object[0];
        size = 0;
    }
}
