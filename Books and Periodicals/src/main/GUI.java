/*
 * Matt Keefer
 * Books and Periodicals
 * 1/5/20
 */
package main;
import java.awt.Color;

import javax.swing.*;
import BreezySwing.*;

public class GUI extends GBFrame {
	JButton addBookButton = addButton("Add Book", 1,1,1,1);
	JButton viewButton = addButton("View Books", 1,2,1,1);
	Library lib = new Library();
	
	public static void main(String[] args) {
		JFrame frm = new GUI();
		frm.setTitle("<html><b>Brand <u>new</u></b> library system</html>");
		frm.setSize(400, 150);
		frm.setVisible(true);
		frm.getContentPane().setBackground(new Color(79, 194, 121));
	}
	
	public void buttonClicked(JButton button) {
		if(button==addBookButton) {
			try {
				addDlg ad = new addDlg(this, lib);
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
		if(button==viewButton) {
			try {
				viewDlg vd = new viewDlg(this, lib);
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
	}
}