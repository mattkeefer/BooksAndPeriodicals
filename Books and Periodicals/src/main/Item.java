package main;

public abstract class Item implements Comparable {
	
	private String title;
	
	public Item(String t) {
		title = t;
	}

	public abstract int compareTo(Object obj);
	public abstract String print();
}