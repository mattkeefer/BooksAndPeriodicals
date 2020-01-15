package main;

public class Book extends Item {
	
	private String author;
	
	public Book(String t, String a) {
		super(t);
		author = a;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String a) {
		author = a;
	}
	
	@Override
	public int compareTo(Object obj) {
		if(getAuthor()==((Book)obj).getAuthor()) {
			System.out.println("0");
			return 0;
		}
		if(getAuthor().compareTo(((Book)obj).getAuthor()) > 0) {
			System.out.println("-1");
			return -1;
		}
		System.out.println("1");
		return 1;
	}

	@Override
	public String print() {
		return getTitle() + " - " + getAuthor();
	}
}