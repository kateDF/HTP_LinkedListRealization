package by.karpuk.mylist.run;

import by.karpuk.mylist.entity.MyList;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("List of Integers: ");
		MyList<Integer> list = new MyList<Integer>();
		list.add(3);
		list.add(6);
		list.add(15);
		list.add(22);
		list.add(-8);
		list.add(23);

		list.show();

		System.out.println("Size start: " + list.size());

		int value = 15;
		System.out.println("\nGet index by value " + value + ": " + list.getIndexByValue(value));
		int elemInd = 3;
		System.out.println("Get value by index " + elemInd + ": " + list.getValueByIndex(elemInd));

		int index = 1;
		System.out.println("\nRemove element with index " + index + ". Result:");
		list.removeByIndex(index);

		list.show();

		System.out.println("Size after removing: " + list.size());

		int elementToAdd = -88;
		System.out.println("\nIncert " + elementToAdd + " at the beggining. Result:");
		list.addFirst(elementToAdd);

		list.show();

		System.out.println("\nList of Strings: ");
		MyList<String> names = new MyList<>();
		names.add("Kate");
		names.add("Nick");
		names.add("Daria");
		names.addFirst("Dima");
		names.addFirst("Sveta");

		names.add(3, "Lena");
		names.add(0, "Anna");
		names.add(7, "Mark");

		for (int i = 0; i < names.size(); i++) {
			System.out.print(names.getValueByIndex(i) + " ");
		}

	}

}
