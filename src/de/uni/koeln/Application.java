package de.uni.koeln;


import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.uni.koeln.gui.WeatherstationGUI;

public class Application {

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					WeatherstationGUI gui = new WeatherstationGUI("Cologne");
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				} 
			}
		});
	}

}
