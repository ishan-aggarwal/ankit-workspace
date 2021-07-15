package com;

/**
 * 
 * @author Sameh A. Fakhouri
 *
 * @param <I>
 */
public class LinkedListNode<I extends Comparable<? super I>> {

	private I data;
	private LinkedListNode<I> next;

	public LinkedListNode(I data) {
		this.data = data;
		this.next = null;
	}

	public LinkedListNode(I data, LinkedListNode<I> next) {
		this.data = data;
		this.next = next;
	}

	public I getData() {
		return data;
	}

	public void setData(I data) {
		this.data = data;
	}

	public LinkedListNode<I> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<I> next) {
		this.next = next;
	}
}