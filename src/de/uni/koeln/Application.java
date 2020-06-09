package de.uni.koeln;

import java.util.List;
import java.util.Scanner;

import de.demmer.dennis.weatherstack.model.Weather;


public class Application {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		Weatherstation weatherstation = new Weatherstation();

		loop: while (true) {

			String input = scanner.next();

			switch (input) {
			
			case "add":
				weatherstation.addLocation(input);
				System.out.println(input + " wurde hinzugefügt!");
				break;
			case "exit":
				System.out.println("Programm wird beendet!");
				break loop;
			case "show":
				List<Weather> weatherList = weatherstation.getAllWeather();
				
				for (Weather weather : weatherList) {
					System.out.println("Ort: " + weather.getLocation().getName());
					System.out.println("Temperatur: " + weather.getTemperature());
				}
				
			// ...
			default:
				break;
			}

		}

	}

}
