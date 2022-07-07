package my;
import static my.LinkedList.*;
// Stack
// This is a sequential container with last-in-first-out behavior.  That is,
// remove will return the last item added to the stack, if one exists.
//
public class Stack<T> implements Container<T> {

	List<T> stack;
    // Construct a new, empty stack.
    //
    public Stack() {
	//new list called stack
	stack = new List<T>();
    }

    // Add a item to the stack
    //
    public void add(T item) {
	//made it use prepend for stack
	prepend(stack, item);
    }

    // Remove and return the top element of the stack
    // Removing from an empty stack returns null.
    //
    public T remove() {
	// this assigns T which is generic and return top later
        T top = item(stack);
	//this is removing queue
	LinkedList.remove(stack);
	//return the top element
	return top;
    }

    // Return the top element without removing it.
    // Peeking at an empty stack returns null.
    //
    public T peek() {
	//return the top element
        return item(stack);
    }

    // Predicate that is true when there are no items in the stack.
    //
    public boolean empty() {
	//uses the empty list and in LinkedList
        return LinkedList.empty(stack);
    }
}
