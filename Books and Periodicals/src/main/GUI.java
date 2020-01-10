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
	JMenuItem pop = addMenuItem("Reeee", "Populate");
	
	public static void main(String[] args) {
		JFrame frm = new GUI();
		frm.setTitle("<html><b>Brand <u>new</u></b> library system</html>");
		frm.setSize(500, 150);
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
	
	public void menuItemSelected(JMenuItem menuItem) {
		lib.add(new Book("Dictionary", "Webster"));
		lib.add(new Book("Grapes of Wrath", "Steinbeck"));
		lib.add(new Book("Of Mice and Men", "Steinbeck"));
		lib.add(new Periodical("Sports Illustrated", 345));
		lib.add(new Periodical("Sports Illustrated", 646));
		lib.add(new Periodical("National Geographic", 345));

	}
}