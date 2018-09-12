package battleship.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTable;

import battleship.model.BoardModel;

import java.awt.GridLayout;

import javax.swing.border.EtchedBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleshipGridFrame extends JInternalFrame {

	private JPanel contentPane;
	private String frameTitle;
	
	public String getFrameTitle() {
		return frameTitle;
	}

	public void setFrameTitle(String frameTitle) {
		this.frameTitle = frameTitle;
		setTitle(frameTitle);
	}

	/*
	 * State for the enemy and the user are tracked with two 
	 * different objects: the model (a BoardModel) and
	 * the tableModel (which refelects the model).
	 */
	private BoardModel boardModel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleshipGridFrame frame = new BattleshipGridFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BattleshipGridFrame() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 450);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setTitle(frameTitle);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(new GridLayout(1,2));
	}
	
	public BattleshipGridFrame(BoardModel bm) {
		this();
		setBoardModel(bm);
		
	}

	public BoardModel getBoardModel() {
		return boardModel;
	}

	/**
	 * Set the board model for the GUI object. This should reset the underlying
	 * panel, etc so the table renders the board model.
	 * @param enemyBoardModel
	 */
	public void setBoardModel(BoardModel boardModel) {
		this.boardModel = boardModel;
		
		BoardPanel boardPanel = new BoardPanel(boardModel);
		contentPane.add(boardPanel);
	}

	

	
}
