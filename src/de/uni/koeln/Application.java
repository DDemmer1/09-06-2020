package de.uni.koeln;

import de.demmer.dennis.weatherstack.WeatherStack;
import de.demmer.dennis.weatherstack.exception.WeatherStackApiException;
import de.demmer.dennis.weatherstack.model.Weather;

public class Application {

	public static void main(String[] args) {
		try {
			String apiKey = "your_weatherstack_api_key_here";
			WeatherStack weatherStack = new WeatherStack(apiKey);
			Weather weather = weatherStack.getWeatherFromLocation("Cologne");
			

			System.out.println(weather);
			System.out.println(weather.getLocation().getCountry());
			System.out.println(weather.getLocation().getRegion());
			System.out.println(weather.getTemperature());
			System.out.println(weather.getWindSpeed());

		} catch (WeatherStackApiException weatherStackApiException) {
			weatherStackApiException.printStackTrace();
		}
	}

}
