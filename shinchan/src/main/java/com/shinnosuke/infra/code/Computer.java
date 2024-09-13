package com.shinnosuke.infra.code;

public class Computer extends Calculator {

	@Override
	public double area(double radius) {
		
		return Constants.PAI_2 * radius * radius;
	}
	
}
