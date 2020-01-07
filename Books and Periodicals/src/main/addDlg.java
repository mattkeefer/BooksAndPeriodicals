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
	JButton close = addButton("Close", 5,1,2,1);

	public addDlg(JFrame frm) throws FormatException {
		super(frm);
		frm.getContentPane().setBackground(new Color(79, 194, 121).darker());
		frm.setTitle("Add Item");
		frm.setSize(500, 400);
		frm.setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		dispose();
	}
}