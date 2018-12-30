package ADT;

public class LList<T> implements ListInterface<T> {

    private Node<T> firstNode;
    private int numberOfEntries;

    public LList() {
        clear();
    }

    @Override
    public final void clear() {
        firstNode = null;
        numberOfEntries = -1;
    }

    @Override
    public boolean add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node<T> lastNode = getNodeAt(numberOfEntries);
            lastNode.setNext(newNode);
        }
        numberOfEntries++;
        return true;
    }

    
    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node<T> desiredNode = getNodeAt(givenPosition);
            desiredNode.setData(newEntry);
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 0) && (givenPosition <= numberOfEntries)) {
            result = getNodeAt(givenPosition).getData();
        }

        return result;
    }

    
    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        boolean result;

        if (numberOfEntries == -1) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    

    public String toString() {
        String outputStr = "";
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            outputStr += currentNode.getData() + "\n";;
            currentNode = currentNode.getNext();
        }
        return outputStr;
    }

    private void displayChain(Node nodeOne) {
        if (nodeOne != null) {
            System.out.print(nodeOne.getData() + " ");
            displayChain(nodeOne.getNext());
        }
    }

    public int size() {
        return numberOfEntries + 1;
    }
    
    private Node<T> getNodeAt(int givenPosition) {
        Node<T> currentNode = firstNode;

        for (int counter = 0; counter < givenPosition; counter++) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

}
