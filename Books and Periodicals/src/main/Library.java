package main;

import java.util.ArrayList;

public class Library {

	private ArrayList<Item> lib;
	
	public Library() {
		lib = new ArrayList<Item>();
	}
	
	public void add(Item i) {
		lib.add(i);
	}
	
	public int getSize() {
		return lib.size();
	}
	
	public Item getItem(int i) {
		return lib.get(i);
	}
	
	public ArrayList<Item> getItems() {
		return lib;
	}
}