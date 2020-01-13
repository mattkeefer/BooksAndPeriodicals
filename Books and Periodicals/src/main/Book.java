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
			return 0;
		}
		System.out.println(getAuthor().compareTo(((Book)obj).getAuthor()));
		return getAuthor().compareTo(((Book)obj).getAuthor());
	}

	@Override
	public String print() {
		return getTitle() + "\n" + getAuthor();
	}

	
}