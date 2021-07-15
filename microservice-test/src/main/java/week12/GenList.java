package week12;

public class GenList<T> {

	private NGen<T> begin = null;

	public GenList() {
		begin = new NGen<>(null, null);
	}

	public void addToStart(T item) {
		NGen<T> new_node = new NGen<>(item, null);
		new_node.setNext(begin);
		begin = new_node;
	}

	public int count() {
		NGen<T> temp = begin;
		// start the count with -1 so not to include the head
		int count = -1;

		while (temp != null) {
			T data = temp.getData();
			if (data != null) {
				count++;
			}
			temp = temp.getNext();
		}
		return count;
	}

}