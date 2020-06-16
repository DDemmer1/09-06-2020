package de.uni.koeln.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.demmer.dennis.weatherstack.exception.WeatherStackApiException;
import de.demmer.dennis.weatherstack.model.Weather;
import de.uni.koeln.Weatherstation;
import de.uni.koeln.gui.button.AddLocationButton;
import de.uni.koeln.gui.button.UpdateButton;
import de.uni.koeln.gui.pane.LocationInput;
import de.uni.koeln.gui.pane.WeatherPane;

public class WeatherstationGUI extends JFrame {

	
	
	
	private Weatherstation weatherstation = new Weatherstation();

	
	
	
	public WeatherstationGUI(String defaultLocation) {
		super("Weatherstation");
		setVisible(true);
		setBounds(700, 200, 800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			weatherstation.addLocation(defaultLocation);
		} catch (WeatherStackApiException ex) {
			JOptionPane.showMessageDialog(this,"Not found");
			ex.printStackTrace();
		}
		
		init();

	}
	
	
	public void init() {
		Container frameContent = getContentPane();

		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(20, 20, 20, 20), null));
		pane.setLayout(new FlowLayout(FlowLayout.LEFT));
		pane.setBackground(Color.WHITE);
		
		for (Weather weather : weatherstation.getAllWeather()) {
			pane.add(new WeatherPane(weather,weatherstation,this));
		}
		
		pane.add(new UpdateButton(weatherstation, this));
		
		LocationInput inputField = new LocationInput();
		pane.add(new AddLocationButton(weatherstation, this, inputField));
		pane.add(inputField);
		
		frameContent.add(pane);
	}
	
	
	
	public void updatePanels() {
		Container pane = getContentPane();
		pane.removeAll();
		this.init();
		pane.repaint();
		pane.revalidate();
	}

}
