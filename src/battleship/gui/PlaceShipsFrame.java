package battleship.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import battleship.model.Ship;

public class PlaceShipsFrame extends JInternalFrame {

	private JPanel dataPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaceShipsFrame frame = new PlaceShipsFrame();
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
	public PlaceShipsFrame() {
		setBounds(100, 100, 450, 300);
		this.setResizable(true);
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		dataPanel = new JPanel();
		scrollPane.setViewportView(dataPanel);
		dataPanel.setLayout(new GridLayout(1, 6, 0, 0));
		
		JLabel lblShip = new JLabel("Ship");
		dataPanel.add(lblShip);
		
		JLabel lblType= new JLabel("Type");
		dataPanel.add(lblType);
		
		JLabel lblBlocks = new JLabel("# Blocks");
		dataPanel.add(lblBlocks);
		
		JLabel lblstartCoordinate = new JLabel("Starting Coordinate");
		dataPanel.add(lblstartCoordinate);
		
		JLabel lblOrientation = new JLabel("Orientation");
		dataPanel.add(lblOrientation);
		
		JLabel lblAction=new JLabel("Action");
		dataPanel.add(lblAction);
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("OK");
		buttonPanel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		buttonPanel.add(btnCancel);

	}

	public void createShipManifest(Ship[] sc) {
		
		JTextField []startingCoordinates=new JTextField[sc.length];
		
		dataPanel.setLayout(new GridLayout(sc.length+1, 5, 0, 0));
		for (int i=0; i < sc.length; i++) {
			JLabel ss=new JLabel(sc[i].getSymbol());
			dataPanel.add(ss);
			JLabel st=new JLabel(sc[i].getShipType());
			dataPanel.add(st);
			JLabel nb=new JLabel(new Integer(sc[i].getShipSize()).toString());
			dataPanel.add(nb);
			startingCoordinates[i]=new JTextField("0,0");
			dataPanel.add(startingCoordinates[i]);
			
			JLabel layout=new JLabel("");
			dataPanel.add(layout);
			JButton jb=new JButton("Place Ship");
			final int j = i;
			jb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Do something with i, 
					System.out.println(j);
				}
				
			});
			dataPanel.add(jb);
			
		}
		
	}
	
}
