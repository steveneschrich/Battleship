package battleship.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class BattleshipTrackingActionListener implements ActionListener {

	
	public BattleshipTrackingActionListener() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GridLocationButton b=(GridLocationButton)e.getSource();
		b.toggleStatus();
	}

}
