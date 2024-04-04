package _08_California_Weather;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	JButton city = new JButton();
    JButton condition = new JButton();
    JButton temp = new JButton();
    HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
    void start() {     
        // All city keys have the first letter capitalized of each word
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setVisible(true);
        frame.setSize(new Dimension(600, 200));
        city.addActionListener(this);
        condition.addActionListener(this);
        temp.addActionListener(this);
        city.setText("Search for a city's weather condition");
        condition.setText("Search for cities that have a specific weather condition");
        temp.setText("Search for cities in a range of temperature");
        panel.add(city);
        panel.add(condition);
        panel.add(temp);
        frame.add(panel);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton button = (JButton) arg0.getSource();
		if (button == city) {
			String cityName = Utilities.capitalizeWords(JOptionPane.showInputDialog("Enter the city name"));
			WeatherData datum = weatherData.get(cityName);
			if (datum == null) {
				JOptionPane.showMessageDialog(null, "Unable to find weather data for: " + cityName);
			}
			else {
				JOptionPane.showMessageDialog(null, cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
			}
		}
		else if (button == condition) {
			String condition2 = Utilities.capitalizeWords(JOptionPane.showInputDialog("Enter a weather condition"));
			String ans = "";
			for (String city : weatherData.keySet()) {
				WeatherData weather = weatherData.get(city);
				if (weather.weatherSummary.equals(condition2)) {
					ans += city + "\n";
				}
			}
			System.out.println(ans);
		}
		else if (button == temp) {
			String a = JOptionPane.showInputDialog("Enter the minimum temperature");
			String b = JOptionPane.showInputDialog("Enter the maximum temperature");
			int min = Integer.parseInt(a);
			int max = Integer.parseInt(b);
			for (String city : weatherData.keySet()) {
				double temp = weatherData.get(city).temperatureF;
				if (min <= temp && max >= temp) {
					System.out.println(city);
				}
			}
		}
	}
}
