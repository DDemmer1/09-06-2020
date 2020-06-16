package de.uni.koeln;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import de.demmer.dennis.weatherstack.WeatherStack;
import de.demmer.dennis.weatherstack.exception.WeatherStackApiException;
import de.demmer.dennis.weatherstack.model.Location;
import de.demmer.dennis.weatherstack.model.Weather;

public class Weatherstation {

	private WeatherStack weatherstack;

	// location, weatherdata
	private Map<String, Weather> weather;

	public Weatherstation() {
		weather = new HashMap<String, Weather>();
		weatherstack = new WeatherStack("ecefb0a4a664089353537bd5059e946a");
	}

	public void addLocation(String location) throws WeatherStackApiException {
			Weather w = weatherstack.getWeatherFromLocation(location);		
			weather.put(location, w);			
	}

	public void deleteLocation(String location) {
		weather.remove(location);
	}

	public List<Weather> getAllWeather() {
		return new ArrayList<Weather>(weather.values());
	}

	public void updateWeatherData() {
		for (String location : weather.keySet()) {
			try {
				Weather w = weatherstack.getWeatherFromLocation(location);
				weather.put(location, w);
			} catch (WeatherStackApiException e) {
				e.printStackTrace();
			}
		}
	}

}
