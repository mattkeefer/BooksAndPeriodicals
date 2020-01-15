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
		if(((Periodical)obj).getIssue()==getIssue()) {
			System.out.println("0");
			return 0;
		}
		if(((Periodical)obj).getIssue()>=getIssue()) {
			System.out.println("1");
			return 1;
		}
		System.out.println("-1");
		return -1;
	}

	@Override
	public String print() {
		return getTitle() + " - " + getIssue();
	}	
}