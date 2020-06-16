package de.uni.koeln.gui.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import de.uni.koeln.Weatherstation;
import de.uni.koeln.gui.WeatherstationGUI;

public class RemoveLocationButton extends JButton{
	
	public RemoveLocationButton(Weatherstation weatherstation, String location, WeatherstationGUI gui){
		super("❌");
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(false);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(location);
				weatherstation.deleteLocation(location);
				gui.updatePanels();
			}
		});
	}
	



}
