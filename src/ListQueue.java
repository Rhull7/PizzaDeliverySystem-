//Team 1
//Queue for Pizza Delivery System
//CSIS 2420

package homedeliverypizza; 
import java.util.NoSuchElementException;


public class ListQueue<E>
{
	private int size;
	private Node<E> front;
	private Node<E> rear;
	
	
	//Creates nodes for linked list
	private static class Node<E>
	{
		private E e;
		private Node<E> next;
		
		public Node(E e)
		{
			this.e = e;
		}
	}
	
	
	//default constructor
	public ListQueue()
	{
		front = null;
		rear = null;
		size = 0;
	}
	
	//add items to queue
	public void enqueue(E e)
	{
		Node<E> holder = new Node<E> (e);
		
		//if queue is empty set item to front and rear
		if(isEmpty())
		{
			holder.next = front;
			front = holder;
			rear = holder;
		}
		
		//if queue is not empty set item to rear
		else
		{
			rear.next = holder;
			rear = holder;
			rear.next = null;
		}
		//increase size
		size++;
	}
	
	//remove items from queue
	public E dequeue()
	{
		if(isEmpty())
			throw new NoSuchElementException("Queue underflow");
		
		Node<E> temp = front;
		
		if(front.next == null)
			rear = null;
		//set front pointer to second item
		front = front.next;
		//decrease size
		size--;
		//return item at front
		return temp.e;
		
	}
	
	//see what item is at the front of the queue
	public E peek()
	{
		if(isEmpty())
			throw new NoSuchElementException("Queue underflow");
		return front.e;
	}
	
	//see the size of the queue
	public int size()
	{
		return size;
	}
	
	//add all items in queue to a string
	public String toString()
	{		
		StringBuilder string = new StringBuilder();
		Node<E> cur = front;
		
		for(int i = 0; i < size; i++)
		{
			string.append(cur.e + " ");
			cur = cur.next;
		}
		
		return string.toString();
	}
	
	//see if queue is empty
	public boolean isEmpty()
	{
		return front == null;
	}

}
