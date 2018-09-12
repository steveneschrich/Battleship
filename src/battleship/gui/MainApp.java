package battleship.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import battleship.model.BoardModel;
import battleship.model.ShipConfiguration;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

import javax.swing.JDesktopPane;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;


public class MainApp {

	private JFrame frmBattleshiptm;
	protected BoardModel enemyBoardModel, userBoardModel;
	Logger logger=Logger.getGlobal();
	private JDesktopPane desktopPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frmBattleshiptm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBattleshiptm = new JFrame();
		frmBattleshiptm.setTitle("BattleshipTM");
		frmBattleshiptm.setBounds(100, 100, 450, 300);
		frmBattleshiptm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmBattleshiptm.setJMenuBar(menuBar);
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game...");
		mntmNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewGame();
			}
		});
		mnFile.add(mntmNewGame);
		
		
		JMenuItem mntmPlaceShips = new JMenuItem("Place Ships...");
		mntmPlaceShips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeShips();
			}
		});
		mnFile.add(mntmPlaceShips);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBattleshiptm.dispose();
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutDialog a=new AboutDialog();
				a.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
		
		desktopPane = new JDesktopPane();
		frmBattleshiptm.getContentPane().add(desktopPane, BorderLayout.CENTER);
	}

		private void createNewGame() {
			int dim=BoardModel.DEFAULT_BOARD_SIZE;
			String dimTxt=JOptionPane.showInputDialog(frmBattleshiptm,"Enter dimension for board",Integer.toString(dim));
			if ( dimTxt == null ) return;
			try {
				dim=Integer.parseInt(dimTxt);
			} catch (NumberFormatException e) {
				return;
			}
			
			logger.info("Setting game size to "+dim);
			
			/* At this point, dim is the board size */
			BattleshipGridFrame battleshipOpponentGrid=new BattleshipGridFrame();
			BattleshipGridFrame battleshipPlayerGrid=new BattleshipGridFrame();
			battleshipOpponentGrid.setFrameTitle("Opponent");
			battleshipPlayerGrid.setFrameTitle("Player");
			battleshipOpponentGrid.setBoardModel(new BoardModel(dim));
			battleshipPlayerGrid.setBoardModel(new BoardModel(dim));
			
			desktopPane.add(battleshipPlayerGrid);
			desktopPane.add(battleshipOpponentGrid);
			battleshipPlayerGrid.setVisible(true);
			battleshipOpponentGrid.setVisible(true);
		}
		
		private void placeShips() {
			PlaceShipsFrame psf=new PlaceShipsFrame();
			ShipConfiguration sc=new ShipConfiguration();
			sc.createManifest();
			
			psf.createShipManifest(sc.getManifest());
			desktopPane.add(psf);
			psf.setVisible(true);
		}
}
