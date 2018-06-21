package by.karpuk.mylist.entity;

public class MyList<T> {

	Node<T> first = null;
	Node<T> last = null;

	public MyList() {

	}

	public void add(T value) {
		Node<T> n = new Node<T>(value);
		if (first == null) {
			first = n;
		} else {
			n.prev = last;
			last.next = n;
		}
		last = n;
	}

	public void add(int index, T value) {
		if (index == 0) {
			addFirst(value);
		} else if (index == size()) {
			add(value);
		} else {
			Node<T> n = new Node<>(value);
			Node<T> nodeByIndex = getNodeByIndex(index);
			n.prev = nodeByIndex.prev;
			n.next = nodeByIndex;
			nodeByIndex.prev = n;
			n.prev.next = n;
		}
	}

	public void addFirst(T value) {
		Node<T> n = new Node<T>(value);
		if (first != null) {
			n.next = first;
			first.prev = n;
		}
		first = n;
	}

	public int getIndexByValue(T value) {
		int index = 0;
		Node<T> element = first;

		while (element.value != value) {
			if (element != last) {
				element = element.next;
				index++;
			} else {
				index = -1;
				break;
			}
		}
		return index;
	}

	public T getValueByIndex(int index) {
		Node<T> element = getNodeByIndex(index);
		return element.value;
	}

	public int size() {
		int size = 1;
		Node<T> element = first;

		if (first == null) {
			return 0;
		}

		while (element != last) {
			size++;
			element = element.next;
		}
		return size;
	}

	public void removeByIndex(int index) {
		Node<T> element = getNodeByIndex(index);
		if (element == first && element == last) {
			first = null;
			last = null;
		} else if (element == first) {
			first = element.next;
			first.prev = null;
			element = null;
		} else if (element == last) {
			last = element.prev;
			last.next = null;
		} else if (element != null) {
			element.prev.next = element.next;
			element.next.prev = element.prev;
		}
	}

	public void show() {
		if (first == null) {
			System.out.println("Empty list");
		} else {
			Node<T> cursor = first;
			do {
				System.out.println(cursor);
				cursor = cursor.next;
			} while (cursor != null);
		}
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index '" + index + "' doesn't exist");
		}
	}

	private Node<T> getNodeByIndex(int index) {
		checkIndex(index);

		Node<T> element = first;
		int i = 0;

		while (i < index) {
			element = element.next;
			i++;
		}
		return element;
	}

	private static class Node<T> {
		T value;
		Node<T> prev;
		Node<T> next;

		public Node(T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Value: " + value;
		}
	}
}
