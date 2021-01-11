package designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverDPDemo {

	public static void main(String[] args) {
		WeatherData wd = new WeatherData();
		new ConcurrentDisplay(wd);
		
		wd.setMeassurements(80, 65, 30.4f);
		wd.setMeassurements(70, 75, 31.4f);
	}

}

interface Subject {
	void register(Observer observer);

	void remove(Observer observer);

	void notifyObservers();
}

interface Observer {
	void update(float temp, float humidity, float pressure);
}

interface DisplayElement {
	void display();
}

class WeatherData implements Subject {

	private List<Observer> observers;
	private float temp, humidity, pressure;
	
	WeatherData(){
		observers = new ArrayList<>();
	}
	
	@Override
	public void register(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void remove(Observer observer) {
		int i = observers.indexOf(observer);
		if(i >= 0)
			observers.remove(i);
	}

	@Override
	public void notifyObservers() {
		observers.forEach(observer -> observer.update(temp, humidity, pressure));
	}
	
	public void meassurementChanged() {
		notifyObservers();
	}
	
	public void setMeassurements(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		meassurementChanged();
	}
}

class ConcurrentDisplay implements Observer,DisplayElement{

	private float temp, humidity;
	private Subject weatherData;
	
	public ConcurrentDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.register(this);
	}
	
	
	@Override
	public void display() {
		System.out.println("Current conditions: "+temp +"F degrees and "+ humidity+"% humidity");
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temp = temp;
		this.humidity=humidity;
		display();
	}
	
}