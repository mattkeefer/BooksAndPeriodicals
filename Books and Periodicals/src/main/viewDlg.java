package main;
import BreezySwing.*;
import java.awt.Color;
import javax.swing.JFrame;

public class viewDlg extends GBDialog {

	public viewDlg(JFrame frm) throws FormatException {
		super(frm);
		frm.getContentPane().setBackground(new Color(79, 194, 121).darker());
		
		frm.setTitle("View Items");
		frm.setSize(500, 400);
		frm.setVisible(true);
	}
}