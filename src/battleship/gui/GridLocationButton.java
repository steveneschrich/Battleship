package battleship.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import battleship.model.BoardModel;

public class GridLocationButton extends JButton {

	private BoardModel boardModel;
	private int row, column;
	
	public GridLocationButton() {
		super();
		// Hacks for the mac
		setOpaque(true);
		setBorderPainted(false);
		setVisible(true);
		this.setMaximumSize(new Dimension(10,10));
	}
	public void setBoardLocation(int row, int column, BoardModel m) {
		this.row=row;
		this.column=column;
		this.boardModel=m;

		refreshLocationState();
	}
	
	/**
	 * The given location can have a status (empty, hit, miss) as well
	 * as occupied by a ship. Both can be represented in the graphical
	 * button: the color is the status, text is the ship.
	 */
	public void refreshLocationState() {
		// Board state
		if (boardModel.isEmpty(row, column)) {
			setBackground(Color.GRAY);
			setForeground(Color.WHITE);
		} else if ( boardModel.hitAt(row, column)) {
			setBackground(Color.RED);
			setForeground(Color.WHITE);
		} else if ( boardModel.missAt(row, column)) {
			setBackground(Color.WHITE);
			setForeground(Color.BLACK);
		}
		// Ship occupancy
		if ( boardModel.isOccupied(row, column)) {
			setText(boardModel.occupiedSymbol(row,column));
		}
		this.repaint();
	}
	
	public void toggleStatus() {
		if (boardModel.hitAt(row, column)) {
			clearState();
		} else if ( boardModel.missAt(row,  column)) {
			recordHit();
		} else if ( boardModel.isEmpty(row, column)) {
			recordMiss();
		}
	}
	public void recordHit() {
		boardModel.setHit(row, column);
		refreshLocationState();
	}
	public void recordMiss() {
		boardModel.setMiss(row, column);
		refreshLocationState();
	}
	public void clearState() {
		boardModel.clear(row, column);
		refreshLocationState();
	}

}
