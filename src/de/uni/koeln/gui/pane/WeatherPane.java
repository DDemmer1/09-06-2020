package de.uni.koeln.gui.pane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import de.demmer.dennis.weatherstack.model.Weather;
import de.uni.koeln.Weatherstation;
import de.uni.koeln.gui.WeatherstationGUI;
import de.uni.koeln.gui.button.RemoveLocationButton;

public class WeatherPane extends JPanel {

	private Weather weather;
	private Color color;
	private Weatherstation weatherstation;
	private WeatherstationGUI gui;

	public WeatherPane(Weather weather, Weatherstation weatherstation, WeatherstationGUI gui) {
		this.weather = weather;
		this.weatherstation = weatherstation;
		this.gui = gui;
		color = Color.LIGHT_GRAY;
		setBackground(color);
		setSize(new Dimension(200, 700));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(20, 20, 20, -30),null));
	 
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void init() throws IOException, ParseException {
		Font font = new Font("Arial", 1, 17);

//		Location
		JTextArea locationText = new JTextArea(weather.getLocation().getName());
		locationText.setEditable(false);
		locationText.setFont(font);
		locationText.setBackground(color);

//		Temperature
		JTextArea temperatureText = new JTextArea(weather.getTemperature() + "°C - " + weather.getWeatherDescriptions().get(0));
		temperatureText.setEditable(false);
		temperatureText.setFont(font);
		temperatureText.setBackground(color);
		
		
//		Time
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
	    Date date = formatter.parse(weather.getLocation().getLocaltime());  
		JTextArea timeText = new JTextArea(new SimpleDateFormat("HH:mm").format(date));

//		Date date = new Date(weather.getLocation().getLocaltime());
		timeText.setEditable(false);
		timeText.setFont(font);
		timeText.setBackground(color);
		
		
//		Image
		String imageURL = getImagePath(weather.getWeatherDescriptions());
		BufferedImage image = ImageIO.read(new File(imageURL));;
		JLabel weatherLabel = new JLabel(new ImageIcon(image));
		weatherLabel.setAlignmentX(RIGHT_ALIGNMENT);
		weatherLabel.setBorder(new EmptyBorder(0, 0, 40, 0));
		
		//Remove Button
		RemoveLocationButton removeLocation = new RemoveLocationButton(weatherstation,weather.getLocation().getName(),gui);
		
		add(removeLocation);
		add(weatherLabel);
		add(locationText);
		add(temperatureText);
		add(timeText);	
	}
	
	
	private String getImagePath(List<String> description) {
		String desc = description.get(0);
		
		if(desc.toLowerCase().contains("cloudy")) {
			return "images/cloud.png";
		}
		
		if(desc.toLowerCase().contains("sunny")) {
			return "images/sunny.png";
		}
		
		if(desc.toLowerCase().contains("rain")) {
			return "images/rain.png";
		}
		return "images/climate.png";
	}
	
	
}
