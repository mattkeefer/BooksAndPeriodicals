package main;
import BreezySwing.*;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;

public class viewDlg extends GBDialog {
	
	JList<String> list = addList(1,1,1,1);
	JTextArea info = addTextArea("", 1,2,1,1);
	JButton close = addButton("Close", 4,1,2,1);
	Library l;
	private JFrame dlg;
	private ArrayList<Item> before;
	private ArrayList<Item> equal;
	private ArrayList<Item> after;

	public viewDlg(JFrame frm, Library lib) throws FormatException {
		super(frm);
		l = lib;
		if(l.getSize()==0) {
			throw new FormatException("There are no items in the library.");
		}
		resetList();
		info.setFont(new Font("Arial", Font.TRUETYPE_FONT, 15));
		info.setEditable(false);
		getContentPane().setBackground(new Color(79, 194, 121).darker());
		setTitle("View Items");
		setSize(700, 500);
		setVisible(true);
	}
	
	private void initializeList() {
		ArrayList<Item> library = l.getItems();
		for(Item it : library) {
			addToList(it.getTitle());
		}
	}
	
	private void addToList(String str) {
		DefaultListModel<String> model = (DefaultListModel<String>)list.getModel();
		model.addElement(str);
	}
	
	private void resetList() {
		DefaultListModel<String> model = (DefaultListModel<String>)list.getModel();
		model.removeAllElements();
		initializeList();
	}
	
	public void buttonClicked(JButton button) {
		dispose();
	}
	
	public void listItemSelected(JList<String> li) {
		info.setText(l.getItem(li.getSelectedIndex()).print());
	}
	
	public void listDoubleClicked(JList<String> li, String selectedObj) {
		before = new ArrayList<Item>();
		equal = new ArrayList<Item>();
		after = new ArrayList<Item>();
		for(Item i : l.getItems()) {
			if(i != l.getItem(li.getSelectedIndex())) {
				try {
					if(i.compareTo(l.getItem(li.getSelectedIndex()))>0) {
						before.add(i);
					}
					if(i.compareTo(l.getItem(li.getSelectedIndex()))==0) {
						equal.add(i);
					}
					if(i.compareTo(l.getItem(li.getSelectedIndex()))<0) {
						after.add(i);
					}
				}
				catch(ClassCastException e) {
					//do nothing
				}
			}
		}
		try {
			compareDlg cd = new compareDlg(dlg, before, equal, after, l.getItem(li.getSelectedIndex()));
		}
		catch(FormatException e) {
			messageBox(e.getMessage());
		}
	}
}