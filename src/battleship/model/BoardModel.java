package battleship.model;

import java.util.Arrays;


public class BoardModel {
	private BoardState boardState[][]=null;
	private Ship occupancy[][]=null;
	
	public static final int DEFAULT_BOARD_SIZE=10;
	private int boardSize=DEFAULT_BOARD_SIZE;


	
	public BoardModel() {
		setSize(DEFAULT_BOARD_SIZE);
	}
	public BoardModel(int bsize) {
		setSize(bsize);
	}
	
	public void setSize(int dimension) {
		boardSize=dimension;
		boardState=new BoardState[boardSize][boardSize];
		occupancy=new Ship[boardSize][boardSize];
		clearBoard();
	}

	public void clearBoard() {
		for (int i=0; i < boardState.length; i++) {
			for (int j=0; j < boardState[i].length; j++) {
				boardState[i][j]=BoardState.EMPTY;
				occupancy[i][j]=null;
			}
		}
	}
	
	public int numRows() {
		return boardSize;
	}
	public int numCols() {
		return boardSize;
	}
	public boolean hitAt(int row, int col) {
		return(boardState[row][col]==BoardState.HIT);
	}
	public boolean missAt(int row, int col) {
		return(boardState[row][col]==BoardState.MISS);
	}
	public boolean isEmpty(int row, int col) {
		return(boardState[row][col]==BoardState.EMPTY);
	}
	public void setHit(int row, int col) {
		boardState[row][col]=BoardState.HIT;
	}
	public void setMiss(int row, int col) {
		boardState[row][col]=BoardState.MISS;
	}
	public void clear(int row, int col) {
		boardState[row][col]=BoardState.EMPTY;
	}
	
	public boolean isOccupied(int row, int col) {
		return(occupancy[row][col]!=null);
	}
	public String occupiedSymbol(int row, int col) {
		if ( occupancy[row][col]==null) {
			return "";
		} else {
			return(occupancy[row][col].getSymbol());
		}
	}
}
