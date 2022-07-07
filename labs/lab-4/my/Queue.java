package my;
import static my.LinkedList.*;
// Queue
// This is a sequential container with first-in-first-out behavior.  That is,
// remove will return the oldest item added to the queue, if one exists.
//
public class Queue<T> {
	List<T> queue;
    // Construct a new, empty queue.
    //
    public Queue() {
	//new list called queue
	queue = new List<T>();

    }

    // Add a item to the queue
    //
    public void add(T item) {
	//made it use appened for queue
	append(queue, item);
    }

    // Remove and return the top element of the queue
    // Removing from an empty queue returns null.
    //
    public T remove() {
	//this assigns T which is generic and return top later
	T top = item(queue);
	//this is removing queue
	LinkedList.remove(queue);
	//return the top element
	return top;
    }

    // Return the top element without removing it.
    // Peeking at an empty queue returns null.
    //
    public T peek() {
	//return the top element
        return item(queue);
    }

    // Predicate that is true when there are no items in the queue.
    //
    public boolean empty() {
	//uses the empty list and in LinkedList
        return LinkedList.empty(queue);
    }
}
