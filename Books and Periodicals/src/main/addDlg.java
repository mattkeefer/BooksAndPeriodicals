package main;
import BreezySwing.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class addDlg extends GBDialog {
	
	JTextField title = addTextField("", 2,2,1,1);
	JLabel tLbl = addLabel("Title:", 2,1,1,1);
	JTextField author = addTextField("", 3,2,1,1);
	JLabel aLbl = addLabel("Author:", 3,1,1,1);
	IntegerField issue = addIntegerField(0, 4,2,1,1);
	JLabel iLbl = addLabel("Issue Number:", 4,1,1,1);
	JButton close = addButton("Close", 5,1,1,1);
	JButton add = addButton("Add", 5,2,1,1);
	ButtonGroup type = new ButtonGroup();
	JRadioButton book = addRadioButton("Book", 1,1,1,1);
	JRadioButton periodical = addRadioButton("Periodical", 1,2,1,1);
	Library l;
	
	private ChangeListener cl = new ChangeListener() {
    	@Override
    	public void stateChanged(ChangeEvent e) {
    		JRadioButton source = (JRadioButton) e.getSource();
    		if(source==book && book.isSelected()) {
    			issue.setText("");
    			author.setText("");
    			iLbl.setVisible(false);
				issue.setVisible(false);
				aLbl.setVisible(true);
				author.setVisible(true);
			}
			if(source==periodical && periodical.isSelected()) {
				issue.setText("");
    			author.setText("");
				iLbl.setVisible(true);
				issue.setVisible(true);
				aLbl.setVisible(false);
				author.setVisible(false);
			}
    	}
    };
	
	public addDlg(JFrame frm, Library lib) throws FormatException {
		super(frm);
		l = lib;
		type.add(book);
		type.add(periodical);
		book.addChangeListener(cl);
		periodical.addChangeListener(cl);
		book.setSelected(true);
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
				if(book.isSelected()) {
					Book b = new Book(title.getText(), author.getText());
					l.add(b);
				}
				if(periodical.isSelected()) {
					Periodical p = new Periodical(title.getText(), issue.getNumber());
					l.add(p);
				}
				dispose();
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
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
}