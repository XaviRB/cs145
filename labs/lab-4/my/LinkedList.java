package my;

public class LinkedList {
    //Node class
    //Made this class so i can call the node
    //and use .next and .datum
    public static class Node<T>{
	T datum;
	Node<T> next;

	//needed to make a double and define next and datum
	public Node(T t){
		datum = t;
		next  = null;
	}

    }

    // This is a generic List reference.
    public static class List<T> {
	Node<T> head;

        // Constructor
        // This will be called by the java run-time environment when a new List
        // object is created.
        public List() {
		head = null;
        }

    }


    // Append
    // Adds item to the end of list.
    //
    // For example, using Python's list notation
    //   append([1, 2, 3], 5) => [1, 2, 3, 5]
    //   append([], 5)        => [5]
    public static <T> void append(List<T> list, T item) {

	Node<T> num   = new Node<T>(item);

	Node<T> temp  = list.head;

	if (empty(list)){
		list.head = num;
	}
	else{
		while (temp.next != null){
			temp = temp.next;
		}
	temp.next = num;
	}
    }

    // Prepend
    // Adds item to the beginning of list.
    //
    // For example, using Python's list notation
    //   prepend([1, 2, 3], 5) => [5, 1, 2, 3]
    //   prepend([], 5)        => [5]
    public static <T> void prepend(List<T> list, T item) {

        Node<T> num = new Node<T>(item);
	if(empty(list)){
		list.head = num;
	}
	else{
		num.next  = list.head;
		list.head = num;
	}
    }

    // Remove
    // Removes the item at the front of list
    //
    // For example, using Python's list notation
    //   remove([1, 2, 3]) => [2, 3]
    //   remove([])        => []
    public static <T> void remove(List<T> list) {
	assert list != null;

	if(empty(list)){
		return;
	}
	else {
		Node<T> temp = list.head.next;
		list.head    = temp;
	}
    }

    // Next
    // Returns the next sub-list
    //
    // For example, using Python's list notation
    //   next([1, 2, 3]) -> [2, 3]
    //   next([])        -> null
    public static <T> List<T> next(List<T> list) {


	if(empty(list)){
		return null;
	}
	else {
		List<T> subList = new List<T>();
		subList.head = list.head.next;
		return subList;
	}
    }

    // Advance
    // Returns the nth subslist
    //
    // For example, using Python's list notation
    //   advance([1, 2, 3], 1) -> [2, 3]
    //   advance([], n)        -> null
    public static <T> List<T> advance(List<T> list, int n) {
        Node<T> location = list.head;
	int temp = 0;

	while(temp != n){
		if(location == null){
			return null;
		}
		location = location.next;
		temp++;
	}

	List<T> sublist = new List<T>();
	sublist.head    = location;

	return sublist;

    }

    // At
    // Returns the item a position p.
    //
    // For example, using Python's list notation
    //   remove([1, 2, 3], 1) -> 2
    //   remove([], 1)        -> null
    public static <T> T at(List<T> list, int p) {
        int temp = 0;

	Node<T> location = list.head;

	if (location == null){
		return null;
	}
	else{

		while(temp != p){
			location = location.next;
			temp++;
		}
		return location.datum;
	}
    }

    // Item
    // Returns the data at the front of the list
    //
    // For example, using Python's list notation
    //   next([1, 2, 3]) -> 2
    //   next([])        -> null
    public static <T> T item(List<T> list) {
        if(empty(list)){
		return null;
	}
	else{
		return list.head.datum;
	}

    }

    // Empty
    // Returns true if there are no items in the list
    //
    // For example, using Python's list notation
    //   emtpy([1, 2, 3]) -> false
    //   emtpy([])        -> true
    public static <T> boolean empty(List<T> list) {
	assert list != null;
	return (list.head == null);
    }

    // Length
    // Returns the length of the list
    //
    // For example, using Python's list notation
    //   length([1, 2, 3]) -> 3
    //   length([])        -> 0
    public static <T> int length(List<T> list) {
	assert list != null;

	int length = 1;

	if(empty(list)){
		length = 0;
	}
	else{
		Node<T> num = list.head;
		while( num.next != null) {
			num = num.next;
			length++;
		}
	}
	return length;
    }

}
