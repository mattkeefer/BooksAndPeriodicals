package main;
import BreezySwing.*;
import java.awt.Color;
import javax.swing.JFrame;

public class viewDlg extends GBDialog {
	
	Library l;

	public viewDlg(JFrame frm, Library lib) throws FormatException {
		super(frm);
		l = lib;
		getContentPane().setBackground(new Color(79, 194, 121).darker());
		setTitle("View Items");
		setSize(500, 400);
		setVisible(true);
	}
}