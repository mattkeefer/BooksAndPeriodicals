package main;

public abstract class Item implements Comparable {
	
	private String title;
	
	public Item(String t) {
		title = t;
	}
	
	public void setTitle(String s) {
		title = s;
	}
	
	public String getTitle() {
		return title;
	}

	public abstract int compareTo(Object obj);
	public abstract String print();
}