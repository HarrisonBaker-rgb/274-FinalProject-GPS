
public interface PriorityQueueInterface<T,E> {
	boolean isEmpty();
	// Don't need isfull since im doing a linked priority queue instead of an array queue
	//boolean isFull();
	int size();
	void clear();
	void add(T start, T name, E cost);
	T remove();
	String peekName();
	int peekCost();
}
