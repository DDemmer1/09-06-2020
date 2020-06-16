package de.uni.koeln.gui.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.uni.koeln.Weatherstation;
import de.uni.koeln.gui.WeatherstationGUI;

public class UpdateButton extends JButton {

	public UpdateButton(Weatherstation weatherstation, WeatherstationGUI gui) {
		setText("🔄");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				weatherstation.updateWeatherData();
				gui.updatePanels();
			}
		});
	}
}
