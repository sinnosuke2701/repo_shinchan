package com.shinnosuke.infra.code;

public class ComputerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int radius = 7;
		
		System.out.println("원의 반지름: " + radius);
		System.out.println();
		System.out.println("Calculator 객체의 원면적 구하는 프로그램 실행");
		System.out.println("원면적: " + radius * radius * Constants.PAI_1);
		System.out.println();
		System.out.println("Computer 객체의 원면적 구하는 프로그램 실행");
		System.out.println("원면적: " + radius * radius * Constants.PAI_2);
		
	}

}
