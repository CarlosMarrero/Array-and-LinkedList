
public class LinkedListInterface implements ListInterface {

    private Node start = null;
    private Node currentNode = null;

    /*
    *@param default constructor. 
     */
    public LinkedListInterface() {
        start = null;
    }

    /*
	 * @return Returns true if the linked list is empty or false if not.
	 * @see ListInterface#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        boolean empty = false;
        if (start == null) {
            empty = true;
        }
        return empty;
    }

    /*
	 * @return Returns the size of the linked list by looping through the list until null is found. 
	 * @see ListInterface#size()
     */
    @Override
    public int size() {
        int size = 0;
        if (isEmpty()) {
            return 0;
        } else {
            for (Node nextNode = start; nextNode != null; nextNode = nextNode.getNext()) // loops through the list to find the end.
            {
                size++;// adds one everytime a node is passed.
            }
        }
        return size;
    }

    /*
	 * @param sets a new node with the object passed in and adds the node at the end of the linked list. 
	 * @see ListInterface#add(java.lang.Object)
     */
    @Override
    public void add(Object obj) {
        Node addNode = new Node(obj);
        Node end;
        if (isEmpty()) {
            start = addNode;// if linked list is empty then adds the node.
        } else {
            for (end = start; end.getNext() != null; end = end.getNext())// loops through the list until the end. 
            {
            }
            end.setNext(addNode);// adds the node at the very end.
        }
    }

    /*
	 * @param takes a new node and add the object to it. if the index is zero then the start points at the new node else if it 
	 * 	 	  equals the end then end gets new node, and if in between then loop until index is found.
	 * @return Return true is the node was added at the specified index.
	 * @see ListInterface#add(java.lang.Object, int)
     */
    @Override
    public boolean add(Object obj, int index) {
        boolean add = false;
        Node addNode = new Node(obj);
        Node nextNode = start;
        if (index == 0) {
            addNode.setNext(start);
            start = addNode;
            add = true;
        } else if (index == size()) {
            add(obj);
            add = true;
        } else if (index < size()) {
            for (int i = 1; i < index; i++) {
                nextNode = nextNode.getNext();
            }
            addNode.setNext(nextNode.getNext());
            nextNode.setNext(addNode);
            add = true;
        }
        return add;
    }

    /*
	 * @param adds the new node created by stepping through the linked list until the correct pointer is found.
	 * @see ListInterface#addSorted(java.lang.Object)
     */
    @Override
    public void addSorted(Object obj) {
        if (isEmpty()) {
            add(obj);
        } else {
            Node addNode = new Node(obj);// new node created and obj is placed in it.
            Node currentNode = start;
            Node previousNode = null;
            int i = 0;
            while ((currentNode != null) && ((Integer) currentNode.getData() < (Integer) obj)) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
                i++;
            }
            if (i == 0) {
                addNode.setNext(start);
                start = addNode;
            } else {
                previousNode.setNext(addNode);
                addNode.setNext(currentNode);
            }
        }
    }

    /*
	 * @return Returns the object at the specified index.
	 * @see ListInterface#getObject(int)
     */
    @Override
    public Object getObject(int index) {
        Object indexObject = null;
        Node currentNode = start;
        if (index < size() && !isEmpty()) {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            indexObject = currentNode.getData();
        }
        return indexObject;
    }

    /*
	 * @return Returns the first object in the linked list, mainly the start node
	 * @see ListInterface#getFirstObject()
     */
    @Override
    public Object getFirstObject() {
        Object firstObject = null;
        if (isEmpty()) {
            currentNode = null;
        } else {
            firstObject = start.getData();
            currentNode = start.getNext();
        }
        return firstObject;
    }

    /*
	 * @param getFirstObject() needs to be called first in order the allow looping through this method.
	 * @return Returns the following object in the linked list.
	 * @see ListInterface#getNextObject()
     */
    @Override
    public Object getNextObject() {
        Object nextObject = null;
        if (currentNode != null) {
            nextObject = currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return nextObject;
    }

    /*
	 * @return Returns turn if the object at the specified index is removed.
	 * @see ListInterface#remove(int)
     */
    @Override
    public boolean remove(int index) {
        boolean remove = false;
        Node nextNode = start;
        Node previousNode = null;
        if (index < size()) {
            if (index == 0) {
                start = start.getNext();
                remove = true;
            } else {
                for (int i = 0; i < index; i++) {
                    previousNode = nextNode;
                    nextNode = nextNode.getNext();
                }
                previousNode.setNext(nextNode.getNext());
                remove = true;
            }
        }
        return remove;
    }

    /*
	 * @param resets start back to null.
	 * @see ListInterface#removeAll()
     */
    @Override
    public void removeAll() {
        start = null;
    }
}
