package com;

import java.util.Arrays;

class ArrayBasedList<E extends Comparable<? super E>> implements ListInterface<E> {

	// Define INITIAL_CAPACITY, size of elements of custom ArrayList
	private static final int INITIAL_CAPACITY = 10;
	private int size = 0;
	private Object elementData[] = {};

	/**
	 *
	 * constructor of custom ArrayList
	 */
	public ArrayBasedList() {
		elementData = new Object[INITIAL_CAPACITY];
	}

	/**
	 * add elements in custom/your own ArrayList Method adds elements in
	 * ArrayListCustom.
	 */
	public void add(E e) {
		if (size == elementData.length) {
			ensureCapacity(); // increase current capacity of list, make it
								// double.
		}
		elementData[size++] = e;
	}

	/**
	 * method returns element on specific index.
	 */
	@SuppressWarnings("unchecked")
	public E get(int index) {
		// if index is negative or greater than size of size, we throw
		// Exception.
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
		}
		return (E) elementData[index]; // return value on index.
	}

	/**
	 * remove elements from custom/your own ArrayList method returns
	 *
	 * removedElement on specific index. else it throws IndexOutOfBoundException if
	 * index is negative or greater than size of size.
	 */
	public boolean remove(int index) {
		if (index < 0 || index >= size) {
			return false;
		}

		Object removedElement = elementData[index];
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		size--; // reduce size of ArrayListCustom after removal of element.

		return true;
	}

	/**
	 * Ensure capacity of custom/your own ArrayList.
	 *
	 * Method increases capacity of list by making it double.
	 */
	private void ensureCapacity() {
		int newIncreasedCapacity = elementData.length * 2;
		elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
	}

	/**
	 * Display custom/your own ArrayList.
	 *
	 * Method displays all the elements in list.
	 */
	public void display() {
		System.out.print("Displaying list : ");
		for (int i = 0; i < size; i++) {
			System.out.print(elementData[i] + " ");
		}
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
	public boolean add(E element, int index) {
		if (index >= 0) {
			if (this.size == this.elementData.length) {
				this.ensureCapacity();
			}

			if (index == this.size) {
				this.elementData[index] = element;
			} else if (index < this.size) {
				for (int i = size; i > index; i--) {
					this.elementData[i] = this.elementData[i - 1];
				}
				this.elementData[index] = element;
				this.size++;
			}
		}
		return true;
	}

	@Override
	public void addSorted(E element) {
		if (this.size == this.elementData.length) {
			this.ensureCapacity();
		}
		for (int i = 0; i < this.elementData.length; i++) {
			if (element.compareTo((E) this.elementData[i]) >= 0) {
				this.elementData[i] = element;
				this.size++;
				break;
			}
		}
	}

	@Override
	public E replace(E element, int index) {
		this.elementData[index] = element;
		return element;
	}

	@Override
	public void removeAll() {
		this.size = 0;
	}
}