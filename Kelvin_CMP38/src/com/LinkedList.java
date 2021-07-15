package com;

/**
 * 
 * @author Sameh A. Fakhouri
 *
 * @param <I>
 */
public class LinkedList<I extends Comparable<? super I>> implements ListInterface<I> {

	private LinkedListNode<I> head;
	private LinkedListNode<I> tail;
	private int size = 0;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0) ? true : false;
	}

	@Override
	public void add(I element) {
		LinkedListNode<I> node = new LinkedListNode<I>(element);

		if (this.isEmpty()) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.setNext(node);
			this.tail = node;
		}

		this.size++;
	}

	@Override
	public boolean add(I element, int index) {
		if ((index >= 0) && (index <= this.size)) {
			// if the index == size the new element gets added to end of list
			if (index == this.size) {
				this.add(element);
				return true;
			} else if (index == 0) {
				LinkedListNode<I> node = new LinkedListNode<I>(element);
				// the element replaces the head
				node.setNext(this.head);
				this.head = node;
				this.size++;
				return true;
			} else {
				LinkedListNode<I> node = new LinkedListNode<I>(element);
				// find the node with the specified index
				int curIndex = 0;
				LinkedListNode<I> prevNode = null;
				LinkedListNode<I> curNode = this.head;
				while (curIndex < index) {
					prevNode = curNode;
					curNode = curNode.getNext();
					curIndex++;
				}
				prevNode.setNext(node);
				node.setNext(curNode);
				this.size++;
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public void addSorted(I element) {
		if (this.isEmpty()) {
			this.add(element);
		} else if (element.compareTo(this.head.getData()) < 0) {
			// element is smaller than the head element
			LinkedListNode<I> node = new LinkedListNode<I>(element);
			node.setNext(this.head);
			this.head = node;
			this.size++;
		} else if (element.compareTo(this.tail.getData()) >= 0) {
			// element is larger or equal to the tail element
			LinkedListNode<I> node = new LinkedListNode<I>(element);
			this.tail.setNext(node);
			this.tail = node;
			this.size++;
		} else {
			LinkedListNode<I> node = new LinkedListNode<I>(element);
			LinkedListNode<I> prevNode = null;
			LinkedListNode<I> curNode = this.head;
			while (element.compareTo(curNode.getData()) > 0) {
				prevNode = curNode;
				curNode = curNode.getNext();
			}
			node.setNext(curNode);
			prevNode.setNext(node);
			this.size++;
		}
	}

	@Override
	public I get(int index) {
		if ((index >= 0) && (index < this.size)) {
			int curIndex = 0;
			LinkedListNode<I> curNode = this.head;
			while (curIndex < index) {
				curNode = curNode.getNext();
				curIndex++;
			}
			return curNode.getData();
		} else {
			return null;
		}
	}

	@Override
	public I replace(I element, int index) {
		if ((index >= 0) && (index < this.size)) {
			int curIndex = 0;
			LinkedListNode<I> curNode = this.head;
			while (curIndex < index) {
				curNode = curNode.getNext();
				curIndex++;
			}
			I oldElement = curNode.getData();
			curNode.setData(element);
			return oldElement;
		} else {
			return null;
		}
	}

	@Override
	public boolean remove(int index) {
		if ((index >= 0) && (index < this.size)) {
			int curIndex = 0;

			LinkedListNode<I> prevNode = null;
			LinkedListNode<I> curNode = this.head;
			while (curIndex < index) {
				prevNode = curNode;
				curNode = curNode.getNext();
				curIndex++;
			}

			if ((curNode == this.head) && (curNode == this.tail) && (this.size == 1)) {
				this.head = null;
				this.tail = null;
			} else if (curNode == this.head) {
				this.head = curNode.getNext();
			} else if (curNode == this.tail) {
				prevNode.setNext(null);
				this.tail = prevNode;
			} else {
				prevNode.setNext(curNode.getNext());
			}

			this.size--;
			return true;
		} else {
			return false;
		}
	}

//	@Override
//	public boolean remove(int index) {
//		if ((index >= 0) && (index < this.size)) {
//
//			// If linked list is empty
//			if (this.head == null)
//				return false;
//
//			// Store head node
//			LinkedListNode<I> temp = this.head;
//
//			// If head needs to be removed
//			if (index == 0) {
//				this.head = temp.getNext();
//				return true;
//			}
//
//			// Find previous node of the node to be deleted
//			for (int i = 0; temp != null && i < index - 1; i++)
//				temp = temp.getNext();
//
//			// If position is more than number of nodes
//			if (temp == null/* || temp.getNext() == null */)
//				return false;
//
//			// Node temp->next is the node to be deleted
//			// Store pointer to the next of node to be deleted
//			LinkedListNode<I> next = null;
//			if (temp.getNext() != null) {
//				next = temp.getNext().getNext();
//			}
//
//			temp.setNext(next); // Unlink the deleted node from list
//			this.size--;
//			return true;
//		} else {
//			return false;
//		}
//	}

	@Override
	public void removeAll() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public String toString() {
		if (this.isEmpty()) {
			return "Linked List = {}";
		} else {
			String s = "Linked List = {";
			LinkedListNode<I> curNode = this.head;
			while (curNode != this.tail) {
				s = s + curNode.getData() + ", ";
				curNode = curNode.getNext();
			}
			s = s + curNode.getData() + "}";
			return s;
		}
	}
}