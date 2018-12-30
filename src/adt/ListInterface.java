package ADT;

public interface ListInterface<T> {

    public boolean add(T newEntry);

    public int size();
    
    public void clear();

    public T getEntry(int givenPosition);

    public boolean isEmpty();

    public boolean replace(int givenPosition, T newEntry);

    public int getNumberOfEntries();

}
