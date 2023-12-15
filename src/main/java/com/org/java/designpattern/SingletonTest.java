package com.org.java.designpattern;

public class SingletonTest {
	private static SingletonTest t=new SingletonTest();
	
	private SingletonTest() {
		
	}
public static SingletonTest getTest()
{
	return t;
	
}
}
//Aproch-2


/*
 * Class Test { private static Test t=null; private Test() {
 * 
 * } public static Test getTest() { if(t==null) { t=new Test(); }
 * 
 * return t; } }
 */
 