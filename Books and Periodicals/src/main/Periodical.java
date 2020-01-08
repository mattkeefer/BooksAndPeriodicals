package main;

public class Periodical extends Item {

	private int issue;
	
	public Periodical(String t, int i) {
		super(t);
		setIssue(i);
	}
	
	public int getIssue() {
		return issue;
	}

	public void setIssue(int i) {
		issue = i;
	}

	@Override
	public int compareTo(Object obj) {
		return 0;
	}

	@Override
	public String print() {
		return null;
	}

	
}