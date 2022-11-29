package model;

public class Fahrenheit implements Temperature{
	public Double convertTemperature(Double temp) {
		return temp*9/5+32;
	}
}

