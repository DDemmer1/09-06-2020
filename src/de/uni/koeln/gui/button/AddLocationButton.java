package de.uni.koeln.gui.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import de.demmer.dennis.weatherstack.exception.WeatherStackApiException;
import de.uni.koeln.Weatherstation;
import de.uni.koeln.gui.WeatherstationGUI;
import de.uni.koeln.gui.pane.LocationInput;

public class AddLocationButton extends JButton{

	public AddLocationButton(Weatherstation weatherstation, WeatherstationGUI gui, LocationInput input) {
		setText("➕");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String location = input.getText();
				if(location.equals("") || location == null || location.isEmpty()) {
					return;
				}
				try {
					weatherstation.addLocation(input.getText());
				} catch (WeatherStackApiException ex) {
					JOptionPane.showMessageDialog(gui,"Not found");
					ex.printStackTrace();
				}
				gui.updatePanels();
				
			}
		});
	}
}
	

