package main;
import BreezySwing.*;
import java.awt.Color;
import javax.swing.*;

public class addDlg extends GBDialog {
	
	JTextField title = addTextField("", 1,2,1,1);
	JLabel tLbl = addLabel("Title:", 1,1,1,1);
	JTextField author = addTextField("", 2,2,1,1);
	JLabel aLbl = addLabel("Author:", 2,1,1,1);
	IntegerField issue = addIntegerField(0, 3,2,1,1);
	JLabel iLbl = addLabel("Issue Number:", 3,1,1,1);
	JButton close = addButton("Close", 5,1,1,1);
	JButton add = addButton("Add", 5,2,1,1);
	ButtonGroup type = new ButtonGroup();
	JRadioButton book = addRadioButton("Book", 1,1,1,1);
	JRadioButton periodical = addRadioButton("Periodical", 1,2,1,1);
	Library l;

	//TODO need change listener for radio buttons to change GUI layout
	
	public addDlg(JFrame frm, Library lib) throws FormatException {
		super(frm);
		l = lib;
		type.add(book);
		type.add(periodical);
		getContentPane().setBackground(new Color(79, 194, 121).darker());
		setTitle("Add Item");
		setSize(500, 400);
		setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		if(button==close) {
			dispose();
		}
		if(button==add) {
			try {
				checkInputs();
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
			if(book.isSelected()) {
				Book b = new Book(title.getText(), author.getText());
			}
		}
	}
	
	private void checkInputs() throws FormatException {
		if(title.getText().trim().equals("")) {
			throw new FormatException("Please enter a title.");
		}
		if(book.isSelected() && author.getText().trim().equals("")) {
			throw new FormatException("Please enter an author.");
		}
		if(periodical.isSelected() && (!issue.isValidNumber() || issue.getNumber()<0)) {
			throw new FormatException("Please enter a valid issue number.");
		}
	}
	
	private void setGUI() {
		
	}
}