package my;

// Container
// This is a generic interface sequential containers.
//
public interface Container<T> {

    // Add a item to the container
    //
    void add(T item);

    // Remove and return the top element of the container.
    // Removing from an empty container returns null.
    //
    T remove();

    // Return the top element without removing it.
    // Peeking at an empty container returns null.
    //
    T peek();

    // Predicate that is true when there are no items in the container.
    //
    boolean empty();
}
