package battleship.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import battleship.model.BoardModel;

public class BoardPanel extends JPanel {
	private BoardModel enemyBoardModel;
	private GridLocationButton [][]board;
	private int numRows, numCols;
	
	/**
	 * Create the panel.
	 */
	public BoardPanel(BoardModel m) {
		enemyBoardModel=m;
		numRows=enemyBoardModel.numRows()+1;
		numCols=enemyBoardModel.numCols()+1;
		setLayout(new GridLayout(numRows,numCols));
	

		BattleshipTrackingActionListener al=new BattleshipTrackingActionListener();
		
		/* Create the board itself as a bunch of JButtons */
		board=new GridLocationButton[enemyBoardModel.numRows()][enemyBoardModel.numCols()];
		for (int rows=0; rows < enemyBoardModel.numRows(); rows++) {
			for (int cols=0; cols < enemyBoardModel.numCols(); cols++) {
				board[rows][cols]=new GridLocationButton();
				board[rows][cols].setBoardLocation(rows, cols, enemyBoardModel);
				board[rows][cols].addActionListener(al);
			}
		}
		
		
		/* Row 1 are column headings */
		this.add(new JLabel(""));
		for (int i=1; i < numCols; i++) {
			JLabel jl=new JLabel(getColumnName(i),SwingConstants.CENTER);
			jl.setMaximumSize(new Dimension(10,10));
			this.add(jl);
		}
		
		for (int row=0; row < numRows-1; row++) {
			for (int col=0; col < numCols; col++) {
				if ( col == 0 ) {
					this.add(new JLabel(new Integer(row+1).toString(),SwingConstants.RIGHT));
				} else {
					this.add(board[row][col-1]);
			
				}
			}
		}
	}


	
	public String getColumnName(int col) {
		if ( col == 0 ) {
			return "";
		} else {
			return new Character(intToAlpha(col-1)).toString();
		}
	}
	public static char intToAlpha(int i) {
		return((char)((int)'A'+i));
	}

}
