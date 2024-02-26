package com.org.java.controller;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	public int addition(int a,int b) {
		int c=a+b;
		return c;
	}
	public int substraction(int a,int b) {
		int c=a-b;
		return c;
	}

}
