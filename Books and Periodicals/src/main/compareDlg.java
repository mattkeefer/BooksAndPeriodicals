package main;
import BreezySwing.*;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;

public class compareDlg extends GBDialog {

	JLabel itemInfo = addLabel("", 1,1,1,1);
	JTextArea list = addTextArea("", 2,1,1,1);
	JButton close = addButton("Close", 3,1,1,1);
	
	public compareDlg(JFrame frm, ArrayList<Item> b, ArrayList<Item> e, ArrayList<Item> a, Item i) throws FormatException {
		super(frm);
		getContentPane().setBackground(new Color(79, 194, 121).darker());
		itemInfo.setText(i.print());
		itemInfo.setFont(new Font("Arial", Font.BOLD, 15));
		list.setEditable(false);
		list.setFont(new Font("Arial", Font.TRUETYPE_FONT, 15));
		resetInfo();
		
		//adds items of same time coming before
		if(b.size()!=0) {
			addInfo("Before:\n\n");
			fillInfo(b);
		}
		//adds items of same time that are equal
		if(e.size()!=0) {
			addInfo("\n\nEqual:\n\n");
			fillInfo(e);
		}
		//adds items of same time coming after
		if(a.size()!=0) {
			addInfo("\n\nAfter:\n\n");
			fillInfo(a);
		}
		
		setTitle("Compare Items");
		setSize(700, 500);
		setVisible(true);
	}
	
	private void resetInfo() {
		list.setText("");
	}
	
	private void addInfo(String str) {
		String out = list.getText();
		resetInfo();
		out += str;
		list.setText(out);
	}
	
	private void fillInfo(ArrayList<Item> list) {
		for(Item i : list) {
			addInfo(i.print() + "\n");
		}
	}
	
	public void buttonClicked(JButton button) {
		dispose();
	}
}