import java.util.ArrayList;
import java.util.Arrays;

public class PriorityQueue <T ,E> implements PriorityQueueInterface<T,E> {

	
	//========================================Properties
	//private ArrayList<Node> list = new ArrayList<Node>();
	private int capacity = 15;
	private Node<T,E>[] list = (Node<T,E>[]) new Node[capacity];
	

	private int size;
	//========================================Constructors
	//========================================Helper Methods
	private class Node<T,E> {
		private T start;
		private T name;
		private E cost;
		
		private Node(T start, T name, E cost) {
			this.name = name;
			this.start = start;
			this.cost = cost;
		}
		
		private Node compare(Node n1, Node n2) {
			if ((int)n1.cost > (int)n2.cost) {
				return n2;
			}
			return n1;
		}
	}
	
	
	public PriorityQueue(){
		size = 0;
		
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public void clear() {
		for(int i = 0; i < size; i++) {
			list[i] = null;
		}
	}
	// When we add things to the queue, we want it to restructure such that
	// the lowest cost is at the front
	
	
	public void add(T start, T name, E cost) {
		Node n = new Node(start, name, cost);
		//list.add(n);
		list[size] = n;
		sort();
		size++;
	}
	
	public void add(Node n) {
		//Node n = new Node(start, name, cost);
		//list.add(arr);
		list[size] = n;
		size++;
		sort();
	}
	
	public void edit(T start, T name, E cost) {
		Node n = new Node(start, name, cost);
		int num = peekCost() + (int)n.cost;
		String name1 = (String)list[0].name + (String)n.name;
		Node h = new Node(list[0].start,name1,num);
		list[0] = h;
		sort();
	}
	
	public void continueFrom(String vertexName) {
		
	}
	
	public String peekName() {
		return (String)list[0].name;
	}
	
	public int peekCost() {
		return (Integer)list[0].cost;
	}
	
	public T peekStart() {
		return list[0].start;
	}

	@Override
	public T remove() {
		T ret = null;
		for(int i = 0; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		size--;
		return ret;
		
		
	}
	
	
	private void sort() {
		int z = 0;
		while (true) {
			
		for(int i = 0; i < size - 1; i++) {
			if ((int)list[i].cost > (int)list[i + 1].cost) {
				swap(i,i+1);
			}
		}
		z++;
			if (checkOrder() || z > 300) break;
		}
		
	}
	
	private void swap(int index1, int index2) {
		Node<T,E> tmp = null;
		tmp = list[index1];
		list[index1] = list[index2];
		list[index2] = tmp;
	}
	
	private boolean checkOrder() {
		for (int i = 0; i < size - 1; i++) {
			if ((int)list[i].cost > (int)list[i + 1].cost) return false;
		}
		return true;
	}
	
	public void resize() {
		Node<T,E>[] arr = (Node<T,E>[]) new Node[capacity];
		for(int i = 0; i < size; i++) {
			arr[i] = list[i];
		}
		capacity *= 2;
		list = (Node<T,E>[]) new Node[capacity];
		for(int i = 0; i < size; i++) {
			list[i] = arr[i];
		}
		System.out.println("Resized");
	}
	
	

	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String toString() { 
		String ret = "";
		for(int i = 0; i < size; i++) {
			ret += list[i].start + " " + list[i].name + " " + list[i].cost + "\n";
		}
		return ret;
	}


	
	
}
