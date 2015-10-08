package org.hbs.java.collection;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueuePractice {

	/**
	 * Queue - FIFO
	 * 
	 * There are 2 types of queues 
	 * 1. Bounded (Limited)   - ArrayBlockingQueue 
	 * 2. Unbounded (Unlimited)  - LinkedList
	 * 
	 * There are 2 sets of operations for a queue
	 * 1. Blocking 
	 * 2. Non-Blocking
	 * 
	 * Queues have 2 sets of methods
	 * 1. Throws exceptions when meet with an illegal operation
	 * 2. Returns a false/null when meet with an illegal operation
	 * 
	 * Illegal operation
	 * 1. Try to add more elements into a queue
	 * 2. Try to remove elements from an empty queue
	 * 3. Try to look at the first element in the queue
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		//Queue<Integer> q1 = new ArrayBlockingQueue<Integer>(3);
		Queue<Integer> q1 = new LinkedList<Integer>();

		
		q1.add(10);
		q1.add(20);
		q1.add(30);
		System.out.println("Head of the queue is : " + q1.element());
		

		try {
			q1.add(40);
		} catch (IllegalStateException e) {
			System.out.println("Tried to add too may items to the queue");
		}

		System.out.println("############ Elements of the queue ############");
		for (Integer value : q1) {
			System.out.println("Queue value: " + value);
		}

		System.out.println("Removed from the queue: " + q1.remove());
		System.out.println("Removed from the queue: " + q1.remove());
		System.out.println("Removed from the queue: " + q1.remove());

		try {
			System.out.println("Removed from the queue: " + q1.remove());
		} catch (NoSuchElementException e) {
			System.out
					.println("Tried to remove too many contents from the queue!!");
		}

		// /////////////////////////////////////////////////
		Queue<Integer> q2 = new ArrayBlockingQueue<Integer>(3);

		
		
		q2.offer(10);
		q2.offer(20);
		q2.offer(30);
		
		System.out.println("Tried peeking: "+q2.peek());
		if (q2.offer(40) == false) {
			System.out.println("Try to add, but could not be added!");
		}
		
		System.out.println("Removing from the new queue: "+q2.poll());
		System.out.println("Removing from the new queue: "+q2.poll());
		System.out.println("Removing from the new queue: "+q2.poll());
		System.out.println("Removing from the new queue: "+q2.poll());
		System.out.println(q2);

	}

}
